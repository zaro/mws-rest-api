package co.amasel.client.feeds;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.feeds.MethodMap;
import co.amasel.model.feeds.*;



public class CancelFeedSubmissions {
    protected AmaselClientBase client;
    
    public CancelFeedSubmissions(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(CancelFeedSubmissionsRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.CancelFeedSubmissions, request);
    }
}
