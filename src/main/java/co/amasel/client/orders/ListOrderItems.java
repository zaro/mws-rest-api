package co.amasel.client.orders;

import co.amasel.client.common.MwsApiResponse;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.model.orders.*;



public class ListOrderItems extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public ListOrderItems(Vertx vertx, String endPoint, AmazonCredentials credentials) {
        super(vertx);
        this.endPoint = endPoint;
        this.credentials = credentials;
    }
    public Future<MwsApiResponse> invoke(ListOrderItemsRequest request) throws ApiRequestException {
        return invoke(MethodMap.ListOrderItems, request, endPoint, credentials);
    }
}
