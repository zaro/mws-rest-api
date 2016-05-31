package co.amasel.client.products;

import co.amasel.client.common.MwsApiResponse;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.model.products.*;



public class GetMatchingProductForId extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public GetMatchingProductForId(Vertx vertx, String endPoint, AmazonCredentials credentials) {
        super(vertx);
        this.endPoint = endPoint;
        this.credentials = credentials;
    }
    public Future<MwsApiResponse> invoke(GetMatchingProductForIdRequest request) throws ApiRequestException {
        return invoke(MethodMap.GetMatchingProductForId, request, endPoint, credentials);
    }
}
