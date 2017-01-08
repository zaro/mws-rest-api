package co.amasel.client.common;

import co.amasel.client.common.AmaselClientException;
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

        public CachedAmaselClientRequest(MwsApiCall apiCallDescription, MwsObject requestObject, Future<MwsApiResponse> result, String endPoint, AmazonCredentials credentials, MwsPostDataTransformer postData, int numberOfRetries) {
            super(apiCallDescription, requestObject, result, endPoint, credentials, postData, numberOfRetries);
        }
    }

    protected Optional<MwsApiResponse> fetchFromCache(JsonObject request){
        return null;
    }

    @Override
    public Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, AmaselMwsObject requestObject, String endPoint, AmazonCredentials credentials) throws AmaselClientException {
        final Future<MwsApiResponse> result = Future.future();
        if(apiCallDescription == null){
            throw new AmaselClientException("Invalid method description: null");
        }

        new CachedAmaselClientRequest(apiCallDescription, requestObject,result, endPoint,credentials, null, 3).makeRequest();
        return result;
    }

    @Override
    public Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, JsonObject requestObject, String endPoint, AmazonCredentials credentials) throws AmaselClientException {
        final Future<MwsApiResponse> result = Future.future();
        if(apiCallDescription == null){
            throw new AmaselClientException("Invalid method description: null");
        }
        // Create a request.
        MwsObject request = createRequestFromJson(apiCallDescription, requestObject);
        MwsPostDataTransformer postData = apiCallDescription.makePostDataTransformer();
        postData.init(requestObject);

        new AmaselClientRequest(apiCallDescription, request,result, endPoint,credentials, postData, 3).makeRequest();
        return result;
    }

}
