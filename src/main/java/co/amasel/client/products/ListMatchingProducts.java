package co.amasel.client.products;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.products.MethodMap;
import co.amasel.model.products.*;



public class ListMatchingProducts extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public static AmaselClient fromVertxInstance(Vertx vertx) {
        AmaselClient c = new AmaselClient();
        c.vertx = vertx;
        return  c;
    }
    public Future<MwsApiResponse> invoke(ListMatchingProductsRequest request) throws ApiRequestException {
        return invoke(MethodMap.ListMatchingProducts, request, endPoint, credentials);
    }
}
