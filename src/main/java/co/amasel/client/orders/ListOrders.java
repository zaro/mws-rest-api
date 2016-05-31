package co.amasel.client.orders;

import co.amasel.client.common.MwsApiResponse;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.model.orders.*;



public class ListOrders extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public ListOrders(Vertx vertx, String endPoint, AmazonCredentials credentials) {
        super(vertx);
        this.endPoint = endPoint;
        this.credentials = credentials;
    }
    public Future<MwsApiResponse> invoke(ListOrdersRequest request) throws ApiRequestException {
        return invoke(MethodMap.ListOrders, request, endPoint, credentials);
    }
}
