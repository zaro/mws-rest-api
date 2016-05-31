package co.amasel.client.feeds;

import co.amasel.client.common.MwsApiResponse;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.model.feeds.*;



public class SubmitFeed extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public SubmitFeed(Vertx vertx, String endPoint, AmazonCredentials credentials) {
        super(vertx);
        this.endPoint = endPoint;
        this.credentials = credentials;
    }
    public Future<MwsApiResponse> invoke(SubmitFeedRequest request) throws ApiRequestException {
        return invoke(MethodMap.SubmitFeed, request, endPoint, credentials);
    }
}
