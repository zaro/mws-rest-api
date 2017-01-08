package co.amasel.client.products;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.products.MethodMap;
import co.amasel.model.products.*;



public class GetLowestOfferListingsForASIN {
    protected AmaselClientBase client;
    
    public GetLowestOfferListingsForASIN(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(GetLowestOfferListingsForASINRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.GetLowestOfferListingsForASIN, request);
    }
}
