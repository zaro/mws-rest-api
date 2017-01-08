package co.amasel.client.sellers;

import java.util.HashMap;
import co.amasel.client.common.*;
import co.amasel.model.sellers.*;

public class MethodMap implements AmaselMethodMap {
    static HashMap<String, MwsApiCall> methodMap = new HashMap<>();

    
    public static MwsApiCall GetServiceStatus = new MwsApiCall("GetServiceStatus", GetServiceStatusRequest.class, GetServiceStatusResponse.class, "/Sellers/2011-07-01", "2011-07-01");
    
    public static MwsApiCall ListMarketplaceParticipationsByNextToken = new MwsApiCall("ListMarketplaceParticipationsByNextToken", ListMarketplaceParticipationsByNextTokenRequest.class, ListMarketplaceParticipationsByNextTokenResponse.class, "/Sellers/2011-07-01", "2011-07-01");
    
    public static MwsApiCall ListMarketplaceParticipations = new MwsApiCall("ListMarketplaceParticipations", ListMarketplaceParticipationsRequest.class, ListMarketplaceParticipationsResponse.class, "/Sellers/2011-07-01", "2011-07-01");
    

    static public void init(String prefix, HashMap<String, MwsApiCall> map) {
        if(prefix == null){
            prefix = "";
        } else if(prefix.length() > 0 && '.' != prefix.charAt(prefix.length() - 1)) {
            prefix = prefix + ".";
        }
        
        map.put(prefix + "GetServiceStatus", MethodMap.GetServiceStatus);
        
        map.put(prefix + "ListMarketplaceParticipationsByNextToken", MethodMap.ListMarketplaceParticipationsByNextToken);
        
        map.put(prefix + "ListMarketplaceParticipations", MethodMap.ListMarketplaceParticipations);
        
    }

    static {
        init(null, methodMap);
    }

    @Override
    public MwsApiCall get(String name) {
        return methodMap.get(name);
    }

}
    
