package co.amasel.client.reports;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.reports.MethodMap;
import co.amasel.model.reports.*;



public class GetReportCount extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public static AmaselClient fromVertxInstance(Vertx vertx) {
        AmaselClient c = new AmaselClient();
        c.vertx = vertx;
        return  c;
    }
    public Future<MwsApiResponse> invoke(GetReportCountRequest request) throws AmaselClientException {
        return invoke(MethodMap.GetReportCount, request, endPoint, credentials);
    }
}
