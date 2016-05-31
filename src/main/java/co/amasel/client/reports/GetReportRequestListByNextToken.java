package co.amasel.client.reports;

import co.amasel.client.common.MwsApiResponse;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.model.reports.*;



public class GetReportRequestListByNextToken extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public GetReportRequestListByNextToken(Vertx vertx, String endPoint, AmazonCredentials credentials) {
        super(vertx);
        this.endPoint = endPoint;
        this.credentials = credentials;
    }
    public Future<MwsApiResponse> invoke(GetReportRequestListByNextTokenRequest request) throws ApiRequestException {
        return invoke(MethodMap.GetReportRequestListByNextToken, request, endPoint, credentials);
    }
}
