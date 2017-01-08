package co.amasel.client.reports;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.reports.MethodMap;
import co.amasel.model.reports.*;



public class GetReportRequestList {
    protected AmaselClientBase client;
    
    public GetReportRequestList(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(GetReportRequestListRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.GetReportRequestList, request);
    }
}
