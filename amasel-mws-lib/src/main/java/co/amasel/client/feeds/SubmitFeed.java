package co.amasel.client.feeds;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.feeds.MethodMap;
import co.amasel.model.feeds.*;



public class SubmitFeed extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public static AmaselClient fromVertxInstance(Vertx vertx) {
        AmaselClient c = new AmaselClient();
        c.vertx = vertx;
        return  c;
    }
    public Future<MwsApiResponse> invoke(SubmitFeedRequest request) throws AmaselClientException {
        return invoke(MethodMap.SubmitFeed, request, endPoint, credentials);
    }
}
