package co.amasel.client.sellers;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.sellers.MethodMap;
import co.amasel.model.sellers.*;



public class ListMarketplaceParticipations {
    protected AmaselClientBase client;
    
    public ListMarketplaceParticipations(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(ListMarketplaceParticipationsRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.ListMarketplaceParticipations, request);
    }
}
