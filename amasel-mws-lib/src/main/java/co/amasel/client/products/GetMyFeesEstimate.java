package co.amasel.client.products;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.products.MethodMap;
import co.amasel.model.products.*;



public class GetMyFeesEstimate {
    protected AmaselClientBase client;
    
    public GetMyFeesEstimate(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(GetMyFeesEstimateRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.GetMyFeesEstimate, request);
    }
}
