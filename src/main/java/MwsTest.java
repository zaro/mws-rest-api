import co.amasel.ApiRequestException;
import co.amasel.ApiRequestParams;
import co.amasel.MwsJsonObjectWriter;
import com.amazonservices.mws.client.AbstractMwsObject;
import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.products.MWSEndpoint;
import com.amazonservices.mws.products.MarketplaceWebServiceProductsClient;
import com.amazonservices.mws.products.MarketplaceWebServiceProductsConfig;
import com.amazonservices.mws.products.MarketplaceWebServiceProductsException;
import com.amazonservices.mws.products.model.GetServiceStatusRequest;
import com.amazonservices.mws.products.model.GetServiceStatusResponse;
import com.amazonservices.mws.products.model.MWSResponse;
import com.amazonservices.mws.products.model.ResponseHeaderMetadata;
import com.amazonservices.mws.products.samples.GetServiceStatusSample;
import com.amazonservices.mws.products.samples.MarketplaceWebServiceProductsSampleConfig;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
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

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by zaro on 11/21/15.
 */
public class MwsTest extends AbstractVerticle{
    private final Logger logger = LoggerFactory.getLogger("MwsTest");

    private static final String accessKey = "XXXXXXXXXXXXXXX";

    /** Developer AWS secret key. */
    private static final String secretKey = "XXXXXXXXXXXXXXX";

    /** The client application name. */
    private static final String appName = "test";

    /** The client application version. */
    private static final String appVersion = "1.0";
    //private static final String serviceURL = MWSEndpoint.UK_PROD.toString();
    private static final String serviceURL = "http://localhost:1337/";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public void sendError(RoutingContext context, Exception e){
        String out = e.getMessage();
        e.printStackTrace();
        context.response().setStatusCode(400).end(out != null ? out : "UNKNOWN ERROR");
    }

    public void handleRequest(RoutingContext routingContext){
        String requestMethod =  routingContext.request().getParam("requestMethod");
        try {

            MwsProductsClient client = new MwsProductsClient(accessKey, secretKey,
                    appName, appVersion, serviceURL);

            if( !client.hasMethod(requestMethod) ){
                routingContext.next();
                return;
            }

            ApiRequestParams params ;
            params = new ApiRequestParams(routingContext.request().params(), null);

            // Create a request.
            MwsObject request  = null;
            JsonObject jsonRequest = routingContext.getBodyAsJson();
            request = client.createRequestFromJson(requestMethod, jsonRequest);

            // Make the call.
            MwsProductsClient.Result response = null;
            response = client.invoke(requestMethod,request);
            // We recommend logging every the request id and timestamp of every call.

            if(params.xml){
                routingContext.response()
                        .putHeader("Content-Type","text/xml")
                        .end(response.response.toXML());
            } else {
                HttpServerResponse r = routingContext.response()
                        .putHeader("Content-Type", "application/json");

                JsonObject outObj = new JsonObject();
                if (params.full) {
                    MwsJsonObjectWriter out = new MwsJsonObjectWriter();
                    response.response.writeFragmentTo(out);
                    outObj.put("result", out.getJsonObject());
                } else {
                    if( response.result != null) {
                        MwsJsonObjectWriter out = new MwsJsonObjectWriter();
                        response.result.writeFragmentTo(out);
                        outObj.put("result", out.getJsonObject());
                    } else {
                        JsonArray arr = new JsonArray();
                        for(AbstractMwsObject result: response.resultList){
                            MwsJsonObjectWriter out = new MwsJsonObjectWriter();
                            result.writeFragmentTo(out);
                            arr.add(out.getJsonObject());
                        }
                        outObj.put("result", arr);
                    }
                }
                if(params.meta){
                    ResponseHeaderMetadata rhmd = response.response.getResponseHeaderMetadata();
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
        } catch (ApiRequestException e) {
            sendError(routingContext, e);
        } catch (MarketplaceWebServiceProductsException e){
            sendError(routingContext, e);
        }
    }

    @Override
    public void start(Future<Void> fut) {
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        logger.info("Start");

        HttpServer serv = vertx.createHttpServer();

        Router restAPI = Router.router(vertx);

        restAPI.route().handler(LoggerHandler.create()).handler(BodyHandler.create());
        restAPI.post("/:requestMethod").handler(r->{
           handleRequest(r);
        });

        Router mainRouter = Router.router(vertx);

        mainRouter.route().handler(ResponseTimeHandler.create());
        mainRouter.mountSubRouter("/products", restAPI);


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
