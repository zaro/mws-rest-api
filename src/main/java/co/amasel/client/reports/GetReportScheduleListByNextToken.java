package co.amasel.client.reports;

import co.amasel.client.common.MwsApiResponse;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.model.reports.*;



public class GetReportScheduleListByNextToken extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public GetReportScheduleListByNextToken(Vertx vertx, String endPoint, AmazonCredentials credentials) {
        super(vertx);
        this.endPoint = endPoint;
        this.credentials = credentials;
    }
    public Future<MwsApiResponse> invoke(GetReportScheduleListByNextTokenRequest request) throws ApiRequestException {
        return invoke(MethodMap.GetReportScheduleListByNextToken, request, endPoint, credentials);
    }
}
