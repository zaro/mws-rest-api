package co.amasel.client.products;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.products.MethodMap;
import co.amasel.model.products.*;



public class GetMyPriceForSKU {
    protected AmaselClientBase client;
    
    public GetMyPriceForSKU(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(GetMyPriceForSKURequest request) throws AmaselClientException {
        return client.invoke(MethodMap.GetMyPriceForSKU, request);
    }
}
