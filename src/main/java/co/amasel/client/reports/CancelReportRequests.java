package co.amasel.client.reports;

import co.amasel.client.common.MwsApiResponse;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.model.reports.*;



public class CancelReportRequests extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public CancelReportRequests(Vertx vertx, String endPoint, AmazonCredentials credentials) {
        super(vertx);
        this.endPoint = endPoint;
        this.credentials = credentials;
    }
    public Future<MwsApiResponse> invoke(CancelReportRequestsRequest request) throws ApiRequestException {
        return invoke(MethodMap.CancelReportRequests, request, endPoint, credentials);
    }
}
