package co.amasel.client.common;

import co.amasel.ApiRequestException;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.client.MwsObject;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

/**
 * Created by zaro on 6/6/16.
 */
public class AmaselCachedClient extends AmaselClient {
    class CachedAmaselClientRequest extends AmaselClientRequest{

        public CachedAmaselClientRequest(MwsApiCall apiCallDescription, MwsObject requestObject, Future<MwsApiResponse> result, String endPoint, AmazonCredentials credentials, int numberOfRetries) {
            super(apiCallDescription, requestObject, result, endPoint, credentials, numberOfRetries);
        }
    }

    protected Optional<MwsApiResponse> fetchFromCache(JsonObject request){
        return null;
    }

    @Override
    public Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, AmaselMwsObject requestObject, String endPoint, AmazonCredentials credentials) throws ApiRequestException {
        final Future<MwsApiResponse> result = Future.future();
        if(apiCallDescription == null){
            throw new ApiRequestException("Invalid method description: null");
        }

        new CachedAmaselClientRequest(apiCallDescription, requestObject,result, endPoint,credentials, 3).makeRequest();
        return result;
    }

    @Override
    public Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, JsonObject requestObject, String endPoint, AmazonCredentials credentials) throws ApiRequestException {
        final Future<MwsApiResponse> result = Future.future();
        if(apiCallDescription == null){
            throw new ApiRequestException("Invalid method description: null");
        }
        // Create a request.
        MwsObject request = createRequestFromJson(apiCallDescription, requestObject);

        new AmaselClientRequest(apiCallDescription, request,result, endPoint,credentials, 3).makeRequest();
        return result;
    }

}
