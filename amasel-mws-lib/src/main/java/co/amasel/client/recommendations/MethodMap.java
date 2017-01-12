package co.amasel.client.recommendations;

import java.util.HashMap;
import co.amasel.client.common.*;
import co.amasel.model.recommendations.*;

public class MethodMap implements AmaselMethodMap {
    static HashMap<String, MwsApiCall> methodMap = new HashMap<>();

    
    public static MwsApiCall GetLastUpdatedTimeForRecommendations = new MwsApiCall("GetLastUpdatedTimeForRecommendations", GetLastUpdatedTimeForRecommendationsRequest.class, GetLastUpdatedTimeForRecommendationsResponse.class, "/Recommendations/2013-04-01", "2013-04-01", 2);
    
    public static MwsApiCall GetServiceStatus = new MwsApiCall("GetServiceStatus", GetServiceStatusRequest.class, GetServiceStatusResponse.class, "/Recommendations/2013-04-01", "2013-04-01", 300);
    
    public static MwsApiCall ListRecommendationsByNextToken = new MwsApiCall("ListRecommendationsByNextToken", ListRecommendationsByNextTokenRequest.class, ListRecommendationsByNextTokenResponse.class, "/Recommendations/2013-04-01", "2013-04-01", 2);
    
    public static MwsApiCall ListRecommendations = new MwsApiCall("ListRecommendations", ListRecommendationsRequest.class, ListRecommendationsResponse.class, "/Recommendations/2013-04-01", "2013-04-01", 2);
    

    static public void init(String prefix, HashMap<String, MwsApiCall> map) {
        if(prefix == null){
            prefix = "";
        } else if(prefix.length() > 0 && '.' != prefix.charAt(prefix.length() - 1)) {
            prefix = prefix + ".";
        }
        
        map.put(prefix + "GetLastUpdatedTimeForRecommendations", MethodMap.GetLastUpdatedTimeForRecommendations);
        
        map.put(prefix + "GetServiceStatus", MethodMap.GetServiceStatus);
        
        map.put(prefix + "ListRecommendationsByNextToken", MethodMap.ListRecommendationsByNextToken);
        
        map.put(prefix + "ListRecommendations", MethodMap.ListRecommendations);
        
    }

    static {
        init(null, methodMap);
    }

    @Override
    public MwsApiCall get(String name) {
        return methodMap.get(name);
    }

}
    
