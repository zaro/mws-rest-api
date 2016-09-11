package co.amasel.client.sellers;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.sellers.MethodMap;
import co.amasel.model.sellers.*;



public class ListMarketplaceParticipationsByNextToken extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public static AmaselClient fromVertxInstance(Vertx vertx) {
        AmaselClient c = new AmaselClient();
        c.vertx = vertx;
        return  c;
    }
    public Future<MwsApiResponse> invoke(ListMarketplaceParticipationsByNextTokenRequest request) throws ApiRequestException {
        return invoke(MethodMap.ListMarketplaceParticipationsByNextToken, request, endPoint, credentials);
    }
}
