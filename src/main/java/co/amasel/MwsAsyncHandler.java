package co.amasel;

import co.amasel.client.common.*;
import co.amasel.model.common.AmaselMwsException;
import co.amasel.presets.PresetDb;
import co.amasel.server.PluginShared;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import com.amazonservices.mws.products.MarketplaceWebServiceProductsException;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.LoggerHandler;
import io.vertx.ext.web.handler.ResponseTimeHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * Created by zaro on 11/21/15.
 */
public class MwsAsyncHandler<AmaselClientClass extends AmaselClient> extends AbstractVerticle {
    private final Logger logger = LoggerFactory.getLogger("MwsAsyncHandler");

    static HashMap<String, MwsApiCall> methodMap = new HashMap<>();

    static {
        co.amasel.client.feeds.MethodMap.init("feeds", methodMap);
        co.amasel.client.reports.MethodMap.init("reports", methodMap);
        co.amasel.client.products.MethodMap.init("products", methodMap);
        co.amasel.client.orders.MethodMap.init("orders", methodMap);
        co.amasel.client.sellers.MethodMap.init("sellers", methodMap);
    }

    private String mountPath;
    /** The client application name. */
    private static final String appName = "test";

    /** The client application version. */
    private static final String appVersion = "1.0";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public MwsAsyncHandler(String mountPath) {
        if(mountPath != null){
            this.mountPath = mountPath;
        } else {
            this.mountPath = "/mws";
        }
    }

    public void sendError(RoutingContext context, Throwable e){
        JsonObject o = new JsonObject();
        o.put("error", e.getMessage());
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        o.put("stackTrace", sw.toString());
        context.response().setStatusCode(400).putHeader("Content-Type", "application/json").end(o.encodePrettily());
    }

    public void handleRequest(RoutingContext routingContext){
        String apiName = routingContext.request().getParam("apiName");
        String requestMethod =  routingContext.request().getParam("requestMethod");
        String methodKey = apiName + "." + requestMethod;
        try {
            AmaselClient client = AmaselClientClass.fromVertxInstance(vertx);
            logger.warn("Search for method " + methodKey);
            MwsApiCall apiCall = methodMap.get(methodKey);
            if( apiCall == null){
                logger.warn("Cannot find " + methodKey);
                routingContext.next();
                return;
            }

            JsonObject jsonRequestNoDef =  routingContext.getBody().length() > 0 ? routingContext.getBodyAsJson() : null;

            MultiMap requestParams = routingContext.request().params();
            String preset = null;
            try {
                preset = ApiRequestParams.getQueryString(requestParams, "preset", "default");
            } catch (ApiRequestException e) {
                sendError(routingContext, e);
                return;
            }
            Future<JsonObject> jsonRequestFuture = PresetDb.getAsDefaults(preset, jsonRequestNoDef);
            jsonRequestFuture.setHandler( defaults-> {
                if(defaults.failed()){
                    sendError(routingContext, defaults.cause());
                    return;
                }
                JsonObject jsonRequest = defaults.result();
                final ApiRequestParams params;
                try {
                    params = new ApiRequestParams(requestParams, jsonRequest);
                } catch (ApiRequestException e) {
                    sendError(routingContext, e);
                    return;
                }

                AmazonCredentials cred  = new AmazonCredentials( params.awsAccessKey, params.awsSecretKey);

                if(params.userAgent != null){
                    client.setUserAgent(params.userAgent);
                }

                String serviceURL = AmazonMwsEndpoint.get(params.endPoint);

                long startTime = System.currentTimeMillis();
                try {
                    client.invoke(apiCall,jsonRequest, serviceURL, cred).setHandler(asyncResponse -> {
                        long stopTime = System.currentTimeMillis();
                        long elapsedTime = stopTime - startTime;
                        System.out.print("TIME TO HANDLER:");
                        System.out.println(elapsedTime);
                        if( asyncResponse.failed() ){
                            sendError(routingContext, asyncResponse.cause() );
                            return;
                        }
                        MwsApiResponse response = asyncResponse.result();
                        if(params.xml){
                            routingContext.response()
                                    .putHeader("Content-Type","text/xml")
                                    .end(response.response.toXML());
                        } else {
                            HttpServerResponse r = routingContext.response();
                            if(!params.raw) {
                                r.putHeader("Content-Type", "application/json");
                            }

                            JsonObject outObj = new JsonObject();
                            try {
                                String resultKey = response.result instanceof AmaselMwsException.XmlMwsException ? "error" : "result";
                                if (params.raw) {
                                    for(Map.Entry<String, String> it: response.headers){
                                        r.putHeader(it.getKey(), it.getValue());
                                    }
                                    r.end(response.rawResponse);
                                    return;
                                } else if (params.full) {
                                    MwsJsonObjectWriter out = new MwsJsonObjectWriter();
                                    response.response.writeFragmentTo(out);
                                    outObj.put(resultKey, out.getJsonObject());
                                } else {
                                    outObj.put(resultKey, response.asJsonObjectOrArray(params));
                                }
                                if (params.meta) {
                                    MwsResponseHeaderMetadata rhmd = response.response.getMwsHeaderMetadata();
                                    JsonObject o = new JsonObject();
                                    o.put("requestId", rhmd.getRequestId());
                                    o.put("responseContext", rhmd.getResponseContext());
                                    o.put("timestamp", rhmd.getTimestamp());
                                    o.put("quotaMax", rhmd.getQuotaMax());
                                    o.put("quotaRemaining", rhmd.getQuotaRemaining());
                                    o.put("quotaResetsAt", rhmd.getQuotaResetsAt() != null ? dateFormat.format(rhmd.getQuotaResetsAt()) : null);
                                    o.put("timeElapsed", elapsedTime);
                                    outObj.put("_meta", o);
                                }
                            } catch( Exception e){
                                outObj.put("error", "" + e);
                                StringWriter sw = new StringWriter();
                                e.printStackTrace(new PrintWriter(sw));
                                outObj.put("stackTrace", sw.toString());
                            }
                            r.end(params.pretty ? outObj.encodePrettily() : outObj.encode());
                        }
                    });
                } catch (ApiRequestException e) {
                    sendError(routingContext, e);
                }

            });

        } catch (io.vertx.core.VertxException |
                MarketplaceWebServiceProductsException | io.vertx.core.json.DecodeException e) {
            sendError(routingContext, e);
        }
    }

    @Override
    public void start(Future<Void> fut) {
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));


        Router restAPI = Router.router(vertx);

        restAPI.route().handler(LoggerHandler.create());
        restAPI.route().handler(ResponseTimeHandler.create());

        restAPI.route().handler(BodyHandler.create());
        restAPI.post("/:apiName/:requestMethod").handler(r->{
            handleRequest(r);
        });

        PluginShared.getMainRouter().mountSubRouter(mountPath, restAPI);

        logger.info("Start /mws/* service");

    }
}
