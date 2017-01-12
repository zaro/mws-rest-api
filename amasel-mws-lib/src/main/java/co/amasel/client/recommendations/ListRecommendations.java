package co.amasel.client.recommendations;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.recommendations.MethodMap;
import co.amasel.model.recommendations.*;



public class ListRecommendations {
    protected AmaselClientBase client;
    
    public ListRecommendations(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(ListRecommendationsRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.ListRecommendations, request);
    }
}
