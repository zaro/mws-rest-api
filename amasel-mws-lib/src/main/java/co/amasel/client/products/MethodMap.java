package co.amasel.client.products;

import java.util.HashMap;
import co.amasel.client.common.*;
import co.amasel.model.products.*;

public class MethodMap implements AmaselMethodMap {
    static HashMap<String, MwsApiCall> methodMap = new HashMap<>();

    
    public static MwsApiCall GetCompetitivePricingForASIN = new MwsApiCall("GetCompetitivePricingForASIN", GetCompetitivePricingForASINRequest.class, GetCompetitivePricingForASINResponse.class, "/Products/2011-10-01", "2011-10-01", 0.1);
    
    public static MwsApiCall GetCompetitivePricingForSKU = new MwsApiCall("GetCompetitivePricingForSKU", GetCompetitivePricingForSKURequest.class, GetCompetitivePricingForSKUResponse.class, "/Products/2011-10-01", "2011-10-01", 0.1);
    
    public static MwsApiCall GetLowestOfferListingsForASIN = new MwsApiCall("GetLowestOfferListingsForASIN", GetLowestOfferListingsForASINRequest.class, GetLowestOfferListingsForASINResponse.class, "/Products/2011-10-01", "2011-10-01", 0.1);
    
    public static MwsApiCall GetLowestOfferListingsForSKU = new MwsApiCall("GetLowestOfferListingsForSKU", GetLowestOfferListingsForSKURequest.class, GetLowestOfferListingsForSKUResponse.class, "/Products/2011-10-01", "2011-10-01", 0.1);
    
    public static MwsApiCall GetLowestPricedOffersForASIN = new MwsApiCall("GetLowestPricedOffersForASIN", GetLowestPricedOffersForASINRequest.class, GetLowestPricedOffersForASINResponse.class, "/Products/2011-10-01", "2011-10-01", 0.2);
    
    public static MwsApiCall GetLowestPricedOffersForSKU = new MwsApiCall("GetLowestPricedOffersForSKU", GetLowestPricedOffersForSKURequest.class, GetLowestPricedOffersForSKUResponse.class, "/Products/2011-10-01", "2011-10-01", 0.2);
    
    public static MwsApiCall GetMatchingProductForId = new MwsApiCall("GetMatchingProductForId", GetMatchingProductForIdRequest.class, GetMatchingProductForIdResponse.class, "/Products/2011-10-01", "2011-10-01", 0.2);
    
    public static MwsApiCall GetMatchingProduct = new MwsApiCall("GetMatchingProduct", GetMatchingProductRequest.class, GetMatchingProductResponse.class, "/Products/2011-10-01", "2011-10-01", 0.5);
    
    public static MwsApiCall GetMyFeesEstimate = new MwsApiCall("GetMyFeesEstimate", GetMyFeesEstimateRequest.class, GetMyFeesEstimateResponse.class, "/Products/2011-10-01", "2011-10-01", 0.1);
    
    public static MwsApiCall GetMyPriceForASIN = new MwsApiCall("GetMyPriceForASIN", GetMyPriceForASINRequest.class, GetMyPriceForASINResponse.class, "/Products/2011-10-01", "2011-10-01", 0.1);
    
    public static MwsApiCall GetMyPriceForSKU = new MwsApiCall("GetMyPriceForSKU", GetMyPriceForSKURequest.class, GetMyPriceForSKUResponse.class, "/Products/2011-10-01", "2011-10-01", 0.1);
    
    public static MwsApiCall GetProductCategoriesForASIN = new MwsApiCall("GetProductCategoriesForASIN", GetProductCategoriesForASINRequest.class, GetProductCategoriesForASINResponse.class, "/Products/2011-10-01", "2011-10-01", 5);
    
    public static MwsApiCall GetProductCategoriesForSKU = new MwsApiCall("GetProductCategoriesForSKU", GetProductCategoriesForSKURequest.class, GetProductCategoriesForSKUResponse.class, "/Products/2011-10-01", "2011-10-01", 5);
    
    public static MwsApiCall GetServiceStatus = new MwsApiCall("GetServiceStatus", GetServiceStatusRequest.class, GetServiceStatusResponse.class, "/Products/2011-10-01", "2011-10-01", 300);
    
    public static MwsApiCall ListMatchingProducts = new MwsApiCall("ListMatchingProducts", ListMatchingProductsRequest.class, ListMatchingProductsResponse.class, "/Products/2011-10-01", "2011-10-01", 5);
    

    static public void init(String prefix, HashMap<String, MwsApiCall> map) {
        if(prefix == null){
            prefix = "";
        } else if(prefix.length() > 0 && '.' != prefix.charAt(prefix.length() - 1)) {
            prefix = prefix + ".";
        }
        
        map.put(prefix + "GetCompetitivePricingForASIN", MethodMap.GetCompetitivePricingForASIN);
        
        map.put(prefix + "GetCompetitivePricingForSKU", MethodMap.GetCompetitivePricingForSKU);
        
        map.put(prefix + "GetLowestOfferListingsForASIN", MethodMap.GetLowestOfferListingsForASIN);
        
        map.put(prefix + "GetLowestOfferListingsForSKU", MethodMap.GetLowestOfferListingsForSKU);
        
        map.put(prefix + "GetLowestPricedOffersForASIN", MethodMap.GetLowestPricedOffersForASIN);
        
        map.put(prefix + "GetLowestPricedOffersForSKU", MethodMap.GetLowestPricedOffersForSKU);
        
        map.put(prefix + "GetMatchingProductForId", MethodMap.GetMatchingProductForId);
        
        map.put(prefix + "GetMatchingProduct", MethodMap.GetMatchingProduct);
        
        map.put(prefix + "GetMyFeesEstimate", MethodMap.GetMyFeesEstimate);
        
        map.put(prefix + "GetMyPriceForASIN", MethodMap.GetMyPriceForASIN);
        
        map.put(prefix + "GetMyPriceForSKU", MethodMap.GetMyPriceForSKU);
        
        map.put(prefix + "GetProductCategoriesForASIN", MethodMap.GetProductCategoriesForASIN);
        
        map.put(prefix + "GetProductCategoriesForSKU", MethodMap.GetProductCategoriesForSKU);
        
        map.put(prefix + "GetServiceStatus", MethodMap.GetServiceStatus);
        
        map.put(prefix + "ListMatchingProducts", MethodMap.ListMatchingProducts);
        
    }

    static {
        init(null, methodMap);
    }

    @Override
    public MwsApiCall get(String name) {
        return methodMap.get(name);
    }

}
    
