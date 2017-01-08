package co.amasel.client.sellers;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.sellers.MethodMap;
import co.amasel.model.sellers.*;



public class ListMarketplaceParticipationsByNextToken {
    protected AmaselClientBase client;
    
    public ListMarketplaceParticipationsByNextToken(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(ListMarketplaceParticipationsByNextTokenRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.ListMarketplaceParticipationsByNextToken, request);
    }
}
