package co.amasel.client.reports;

import java.util.HashMap;
import co.amasel.client.common.*;
import co.amasel.model.reports.*;

public class MethodMap implements AmaselMethodMap {
    static HashMap<String, MwsApiCall> methodMap = new HashMap<>();

    
    public static MwsApiCall CancelReportRequests = new MwsApiCall("CancelReportRequests", CancelReportRequestsRequest.class, CancelReportRequestsResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetReportCount = new MwsApiCall("GetReportCount", GetReportCountRequest.class, GetReportCountResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetReportListByNextToken = new MwsApiCall("GetReportListByNextToken", GetReportListByNextTokenRequest.class, GetReportListByNextTokenResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetReportList = new MwsApiCall("GetReportList", GetReportListRequest.class, GetReportListResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetReport = new MwsApiCall("GetReport", GetReportRequest.class, GetReportResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetReportRequestCount = new MwsApiCall("GetReportRequestCount", GetReportRequestCountRequest.class, GetReportRequestCountResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetReportRequestListByNextToken = new MwsApiCall("GetReportRequestListByNextToken", GetReportRequestListByNextTokenRequest.class, GetReportRequestListByNextTokenResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetReportRequestList = new MwsApiCall("GetReportRequestList", GetReportRequestListRequest.class, GetReportRequestListResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetReportScheduleCount = new MwsApiCall("GetReportScheduleCount", GetReportScheduleCountRequest.class, GetReportScheduleCountResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetReportScheduleListByNextToken = new MwsApiCall("GetReportScheduleListByNextToken", GetReportScheduleListByNextTokenRequest.class, GetReportScheduleListByNextTokenResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetReportScheduleList = new MwsApiCall("GetReportScheduleList", GetReportScheduleListRequest.class, GetReportScheduleListResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall ManageReportSchedule = new MwsApiCall("ManageReportSchedule", ManageReportScheduleRequest.class, ManageReportScheduleResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall RequestReport = new MwsApiCall("RequestReport", RequestReportRequest.class, RequestReportResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall UpdateReportAcknowledgements = new MwsApiCall("UpdateReportAcknowledgements", UpdateReportAcknowledgementsRequest.class, UpdateReportAcknowledgementsResponse.class, "/", "2009-01-01");
    

    static public void init(String prefix, HashMap<String, MwsApiCall> map) {
        if(prefix == null){
            prefix = "";
        } else if(prefix.length() > 0 && '.' != prefix.charAt(prefix.length() - 1)) {
            prefix = prefix + ".";
        }
        
        map.put(prefix + "CancelReportRequests", MethodMap.CancelReportRequests);
        
        map.put(prefix + "GetReportCount", MethodMap.GetReportCount);
        
        map.put(prefix + "GetReportListByNextToken", MethodMap.GetReportListByNextToken);
        
        map.put(prefix + "GetReportList", MethodMap.GetReportList);
        
        map.put(prefix + "GetReport", MethodMap.GetReport);
        
        map.put(prefix + "GetReportRequestCount", MethodMap.GetReportRequestCount);
        
        map.put(prefix + "GetReportRequestListByNextToken", MethodMap.GetReportRequestListByNextToken);
        
        map.put(prefix + "GetReportRequestList", MethodMap.GetReportRequestList);
        
        map.put(prefix + "GetReportScheduleCount", MethodMap.GetReportScheduleCount);
        
        map.put(prefix + "GetReportScheduleListByNextToken", MethodMap.GetReportScheduleListByNextToken);
        
        map.put(prefix + "GetReportScheduleList", MethodMap.GetReportScheduleList);
        
        map.put(prefix + "ManageReportSchedule", MethodMap.ManageReportSchedule);
        
        map.put(prefix + "RequestReport", MethodMap.RequestReport);
        
        map.put(prefix + "UpdateReportAcknowledgements", MethodMap.UpdateReportAcknowledgements);
        
    }

    static {
        init(null, methodMap);
    }

    @Override
    public MwsApiCall get(String name) {
        return methodMap.get(name);
    }

}
    
