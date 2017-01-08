package co.amasel.client.products;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.products.MethodMap;
import co.amasel.model.products.*;



public class GetMatchingProduct extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public static AmaselClient fromVertxInstance(Vertx vertx) {
        AmaselClient c = new AmaselClient();
        c.vertx = vertx;
        return  c;
    }
    public Future<MwsApiResponse> invoke(GetMatchingProductRequest request) throws AmaselClientException {
        return invoke(MethodMap.GetMatchingProduct, request, endPoint, credentials);
    }
}
