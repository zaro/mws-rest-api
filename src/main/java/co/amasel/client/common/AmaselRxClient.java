package co.amasel.client.common;

import co.amasel.ApiRequestException;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.client.MwsObject;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * Created by zaro on 6/14/16.
 */
public class AmaselRxClient extends AmaselClientBase {
    public Vertx vertx;

//    public static AmaselClient fromVertxInstance(Vertx vertx) {
//        AmaselClient c = new AmaselClient();
//        c.vertx = vertx;
//        return  c;
//    }
//
//    public Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, AmaselMwsObject requestObject, String endPoint, AmazonCredentials credentials) throws ApiRequestException {
//        final Future<MwsApiResponse> result = Future.future();
//        if(apiCallDescription == null){
//            throw new ApiRequestException("Invalid method description: null");
//        }
//        new AmaselClientRequest(apiCallDescription, requestObject,result, endPoint,credentials, 3).makeRequest();
//        return result;
//    }
//
//    public Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, JsonObject requestObject, String endPoint, AmazonCredentials credentials) throws ApiRequestException {
//        final Future<MwsApiResponse> result = Future.future();
//        if(apiCallDescription == null){
//            throw new ApiRequestException("Invalid method description: null");
//        }
//        // Create a request.
//        MwsObject request = createRequestFromJson(apiCallDescription, requestObject);
//
//        new AmaselClientRequest(apiCallDescription, request,result, endPoint,credentials, 3).makeRequest();
//        return result;
//    }

}
