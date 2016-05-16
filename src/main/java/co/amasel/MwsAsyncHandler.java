package co.amasel;

import com.amazonservices.mws.client.AbstractMwsObject;
import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import com.amazonservices.mws.products.MWSEndpoint;
import com.amazonservices.mws.products.MarketplaceWebServiceProductsException;
import com.amazonservices.mws.products.model.ResponseHeaderMetadata;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.LoggerHandler;
import io.vertx.ext.web.handler.ResponseTimeHandler;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by zaro on 11/21/15.
 */
public class MwsAsyncHandler extends AbstractVerticle{
    private final Logger logger = LoggerFactory.getLogger("MwsAsyncHandler");

    private static final String accessKey = "XXXXXXXXXXXXXXX";

    /** Developer AWS secret key. */
    private static final String secretKey = "XXXXXXXXXXXXXXX";

    /** The client application name. */
    private static final String appName = "test";

    /** The client application version. */
    private static final String appVersion = "1.0";
    private static final String serviceURL = MWSEndpoint.UK_PROD.toString();
    //private static final String serviceURL = "http://localhost:1337/";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public void sendError(RoutingContext context, Throwable e){
        JsonObject o = new JsonObject();
        o.put("error", e.getMessage());
        context.response().setStatusCode(400).putHeader("Content-Type", "application/json").end(o.encodePrettily());
    }

    public void handleRequest(RoutingContext routingContext){
        String apiName = routingContext.request().getParam("apiName");
        String requestMethod =  routingContext.request().getParam("requestMethod");
        String methodKey = apiName + "." + requestMethod;
        try {
            System.out.println("--------");
            MwsHttpClient client = new MwsHttpClient(vertx);

            if( !MwsMethodMap.hasMethod(methodKey) ){
                routingContext.next();
                return;
            }

            ApiRequestParams params ;
            params = new ApiRequestParams(routingContext.request().params(), null);

            // Create a request.
            MwsObject request  = null;
            JsonObject jsonRequest = routingContext.getBodyAsJson();
            request = client.createRequestFromJson(methodKey, jsonRequest);

            long startTime = System.currentTimeMillis();
            client.invoke(methodKey,request, serviceURL,accessKey, secretKey).setHandler(asyncResponse -> {
                long stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                System.out.print("TIME TO HANDLER:");
                System.out.println(elapsedTime);
                if( asyncResponse.failed() ){
                    sendError(routingContext, asyncResponse.cause() );
                    return;
                }
                MwsHttpClient.Response response = asyncResponse.result();
                if(params.xml){
                    routingContext.response()
                            .putHeader("Content-Type","text/xml")
                            .end(response.response.toXML());
                } else {
                    HttpServerResponse r = routingContext.response()
                            .putHeader("Content-Type", "application/json");

                    JsonObject outObj = new JsonObject();
                    String resultKey = response.result instanceof MwsException.XmlMwsException ? "error" : "result";
                    if (params.full) {
                        MwsJsonObjectWriter out = new MwsJsonObjectWriter();
                        response.response.writeFragmentTo(out);
                        outObj.put(resultKey, out.getJsonObject());
                    } else {
                        if( response.result != null) {
                            MwsJsonObjectWriter out = new MwsJsonObjectWriter();
                            response.result.writeFragmentTo(out);
                            outObj.put(resultKey, out.getJsonObject());
                        } else {
                            JsonArray arr = new JsonArray();
                            for(MwsObject result: response.resultList){
                                MwsJsonObjectWriter out = new MwsJsonObjectWriter();
                                result.writeFragmentTo(out);
                                arr.add(out.getJsonObject());
                            }
                            outObj.put(resultKey, arr);
                        }
                    }
                    if(params.meta){
                        MwsResponseHeaderMetadata rhmd = response.response.getMwsHeaderMetadata();
                        JsonObject o = new JsonObject();
                        o.put("requestId", rhmd.getRequestId());
                        o.put("responseContext", rhmd.getResponseContext());
                        o.put("timestamp", rhmd.getTimestamp());
                        o.put("quotaMax", rhmd.getQuotaMax());
                        o.put("quotaRemaining", rhmd.getQuotaRemaining());
                        o.put("quotaResetsAt", rhmd.getQuotaResetsAt() != null ? dateFormat.format( rhmd.getQuotaResetsAt() ) : null );
                        outObj.put("_meta", o);
                    }
                    r.end(params.pretty ? outObj.encodePrettily() : outObj.encode());
                }
            });

        } catch (ApiRequestException e) {
            sendError(routingContext, e);
        } catch (MarketplaceWebServiceProductsException e){
            sendError(routingContext, e);
        } catch (io.vertx.core.json.DecodeException e){
            sendError(routingContext, e);
        }
    }

    @Override
    public void start(Future<Void> fut) {
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        logger.info("START");

        HttpServer serv = vertx.createHttpServer();

        Router restAPI = Router.router(vertx);

        restAPI.route().handler(BodyHandler.create());
        restAPI.post("/:apiName/:requestMethod").handler(r->{
            handleRequest(r);
        });

        Router mainRouter = Router.router(vertx);

        mainRouter.route().handler(ResponseTimeHandler.create());
        mainRouter.route().handler(LoggerHandler.create());
        mainRouter.mountSubRouter("/mws", restAPI);


        serv.requestHandler(mainRouter::accept)
        .listen(8080, result -> {
            if (result.succeeded()) {
                fut.complete();
            } else {
                fut.fail(result.cause());
            }
        });


    }
}
