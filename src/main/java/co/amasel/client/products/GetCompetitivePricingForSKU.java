package co.amasel.client.products;

import co.amasel.client.common.MwsApiResponse;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.model.products.*;



public class GetCompetitivePricingForSKU extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public GetCompetitivePricingForSKU(Vertx vertx, String endPoint, AmazonCredentials credentials) {
        super(vertx);
        this.endPoint = endPoint;
        this.credentials = credentials;
    }
    public Future<MwsApiResponse> invoke(GetCompetitivePricingForSKURequest request) throws ApiRequestException {
        return invoke(MethodMap.GetCompetitivePricingForSKU, request, endPoint, credentials);
    }
}
