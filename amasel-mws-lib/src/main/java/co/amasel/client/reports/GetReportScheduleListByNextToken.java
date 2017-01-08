package co.amasel.client.reports;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.reports.MethodMap;
import co.amasel.model.reports.*;



public class GetReportScheduleListByNextToken {
    protected AmaselClientBase client;
    
    public GetReportScheduleListByNextToken(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(GetReportScheduleListByNextTokenRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.GetReportScheduleListByNextToken, request);
    }
}
