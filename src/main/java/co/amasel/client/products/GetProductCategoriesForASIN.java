package co.amasel.client.products;

import co.amasel.client.common.MwsApiResponse;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.model.products.*;



public class GetProductCategoriesForASIN extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public GetProductCategoriesForASIN(Vertx vertx, String endPoint, AmazonCredentials credentials) {
        super(vertx);
        this.endPoint = endPoint;
        this.credentials = credentials;
    }
    public Future<MwsApiResponse> invoke(GetProductCategoriesForASINRequest request) throws ApiRequestException {
        return invoke(MethodMap.GetProductCategoriesForASIN, request, endPoint, credentials);
    }
}
