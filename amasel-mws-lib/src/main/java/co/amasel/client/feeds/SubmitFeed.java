package co.amasel.client.feeds;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.feeds.MethodMap;
import co.amasel.model.feeds.*;



public class SubmitFeed {
    protected AmaselClientBase client;
    
    public SubmitFeed(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(SubmitFeedRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.SubmitFeed, request);
    }
}
