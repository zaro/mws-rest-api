package co.amasel.client.orders;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.orders.MethodMap;
import co.amasel.model.orders.*;



public class ListOrders {
    protected AmaselClientBase client;
    
    public ListOrders(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(ListOrdersRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.ListOrders, request);
    }
}
