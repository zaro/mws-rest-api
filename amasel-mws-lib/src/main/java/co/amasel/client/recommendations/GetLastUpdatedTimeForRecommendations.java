package co.amasel.client.recommendations;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.recommendations.MethodMap;
import co.amasel.model.recommendations.*;



public class GetLastUpdatedTimeForRecommendations {
    protected AmaselClientBase client;
    
    public GetLastUpdatedTimeForRecommendations(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(GetLastUpdatedTimeForRecommendationsRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.GetLastUpdatedTimeForRecommendations, request);
    }
}
