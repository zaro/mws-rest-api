package co.amasel.client.feeds;

import java.util.HashMap;
import co.amasel.client.common.*;
import co.amasel.model.feeds.*;

public class MethodMap implements AmaselMethodMap {
    static HashMap<String, MwsApiCall> methodMap = new HashMap<>();

    
    public static MwsApiCall CancelFeedSubmissions = new MwsApiCall("CancelFeedSubmissions", CancelFeedSubmissionsRequest.class, CancelFeedSubmissionsResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetFeedSubmissionCount = new MwsApiCall("GetFeedSubmissionCount", GetFeedSubmissionCountRequest.class, GetFeedSubmissionCountResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetFeedSubmissionListByNextToken = new MwsApiCall("GetFeedSubmissionListByNextToken", GetFeedSubmissionListByNextTokenRequest.class, GetFeedSubmissionListByNextTokenResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetFeedSubmissionList = new MwsApiCall("GetFeedSubmissionList", GetFeedSubmissionListRequest.class, GetFeedSubmissionListResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall GetFeedSubmissionResult = new MwsApiCall("GetFeedSubmissionResult", GetFeedSubmissionResultRequest.class, GetFeedSubmissionResultResponse.class, "/", "2009-01-01");
    
    public static MwsApiCall SubmitFeed = new MwsApiCall("SubmitFeed", SubmitFeedRequest.class, SubmitFeedResponse.class, "/", "2009-01-01");
    

    static public void init(String prefix, HashMap<String, MwsApiCall> map) {
        if(prefix == null){
            prefix = "";
        } else if(prefix.length() > 0 && '.' != prefix.charAt(prefix.length() - 1)) {
            prefix = prefix + ".";
        }
        
        map.put(prefix + "CancelFeedSubmissions", MethodMap.CancelFeedSubmissions);
        
        map.put(prefix + "GetFeedSubmissionCount", MethodMap.GetFeedSubmissionCount);
        
        map.put(prefix + "GetFeedSubmissionListByNextToken", MethodMap.GetFeedSubmissionListByNextToken);
        
        map.put(prefix + "GetFeedSubmissionList", MethodMap.GetFeedSubmissionList);
        
        map.put(prefix + "GetFeedSubmissionResult", MethodMap.GetFeedSubmissionResult);
        
        map.put(prefix + "SubmitFeed", MethodMap.SubmitFeed);
        
    }

    static {
        init(null, methodMap);
    }

    @Override
    public MwsApiCall get(String name) {
        return methodMap.get(name);
    }

}
    
