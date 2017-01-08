package co.amasel.client.reports;

import io.vertx.core.Future;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import co.amasel.client.reports.MethodMap;
import co.amasel.model.reports.*;



public class UpdateReportAcknowledgements {
    protected AmaselClientBase client;
    
    public UpdateReportAcknowledgements(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(UpdateReportAcknowledgementsRequest request) throws AmaselClientException {
        return client.invoke(MethodMap.UpdateReportAcknowledgements, request);
    }
}
