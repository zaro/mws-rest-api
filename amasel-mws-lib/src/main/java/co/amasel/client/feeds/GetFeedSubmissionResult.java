package co.amasel.client.feeds;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.feeds.MethodMap;
import co.amasel.model.feeds.*;



public class GetFeedSubmissionResult {
    protected AmaselClientBase client;
    
    public GetFeedSubmissionResult(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(GetFeedSubmissionResultRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.GetFeedSubmissionResult, request);
    }
}
