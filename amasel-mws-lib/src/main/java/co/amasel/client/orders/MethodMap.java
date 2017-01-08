package co.amasel.client.orders;

import java.util.HashMap;
import co.amasel.client.common.*;
import co.amasel.model.orders.*;

public class MethodMap implements AmaselMethodMap {
    static HashMap<String, MwsApiCall> methodMap = new HashMap<>();

    
    public static MwsApiCall GetOrder = new MwsApiCall("GetOrder", GetOrderRequest.class, GetOrderResponse.class, "/Orders/2013-09-01", "2013-09-01");
    
    public static MwsApiCall GetServiceStatus = new MwsApiCall("GetServiceStatus", GetServiceStatusRequest.class, GetServiceStatusResponse.class, "/Orders/2013-09-01", "2013-09-01");
    
    public static MwsApiCall ListOrderItemsByNextToken = new MwsApiCall("ListOrderItemsByNextToken", ListOrderItemsByNextTokenRequest.class, ListOrderItemsByNextTokenResponse.class, "/Orders/2013-09-01", "2013-09-01");
    
    public static MwsApiCall ListOrderItems = new MwsApiCall("ListOrderItems", ListOrderItemsRequest.class, ListOrderItemsResponse.class, "/Orders/2013-09-01", "2013-09-01");
    
    public static MwsApiCall ListOrdersByNextToken = new MwsApiCall("ListOrdersByNextToken", ListOrdersByNextTokenRequest.class, ListOrdersByNextTokenResponse.class, "/Orders/2013-09-01", "2013-09-01");
    
    public static MwsApiCall ListOrders = new MwsApiCall("ListOrders", ListOrdersRequest.class, ListOrdersResponse.class, "/Orders/2013-09-01", "2013-09-01");
    

    static public void init(String prefix, HashMap<String, MwsApiCall> map) {
        if(prefix == null){
            prefix = "";
        } else if(prefix.length() > 0 && '.' != prefix.charAt(prefix.length() - 1)) {
            prefix = prefix + ".";
        }
        
        map.put(prefix + "GetOrder", MethodMap.GetOrder);
        
        map.put(prefix + "GetServiceStatus", MethodMap.GetServiceStatus);
        
        map.put(prefix + "ListOrderItemsByNextToken", MethodMap.ListOrderItemsByNextToken);
        
        map.put(prefix + "ListOrderItems", MethodMap.ListOrderItems);
        
        map.put(prefix + "ListOrdersByNextToken", MethodMap.ListOrdersByNextToken);
        
        map.put(prefix + "ListOrders", MethodMap.ListOrders);
        
    }

    static {
        init(null, methodMap);
    }

    @Override
    public MwsApiCall get(String name) {
        return methodMap.get(name);
    }

}
    
