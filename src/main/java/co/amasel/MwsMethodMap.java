package co.amasel;

import co.amasel.model.common.AmaselMwsObject;
import com.amazonaws.mws.MarketplaceWebServiceConfig;
import com.amazonservices.mws.client.*;
import com.amazonservices.mws.orders._2013_09_01.MarketplaceWebServiceOrdersConfig;
import com.amazonservices.mws.products.MWSEndpoint;
import com.amazonservices.mws.products.MarketplaceWebServiceProductsConfig;
import co.amasel.model.products.*;
import co.amasel.model.feeds_reports.*;
import co.amasel.model.orders.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * Created by zaro on 11/23/15.
 */
public class MwsMethodMap {
    static HashMap<String, RequestType> methodMap = new HashMap<>();

    static RequestType get(String method){
        return methodMap.getOrDefault(method, null);
    }

    public static boolean hasMethod(String method){
        return get(method) != null;
    }

    static public void initProducts(){
        MarketplaceWebServiceProductsConfig cfg = new MarketplaceWebServiceProductsConfig();
        String servicePathStr;
        String serviceVersion = cfg.getServiceVersion();

        cfg.setServiceURL(MWSEndpoint.UK_PROD.toString());
        try {
            URI endPoint = new URI(cfg.getServiceURL());
            // No leading '/' in path, fucks up MwsConnection later
            servicePathStr = endPoint.getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        if(servicePathStr.isEmpty()){
            servicePathStr = "/";
        }
        methodMap.put("products.GetCompetitivePricingForASIN", new RequestType("GetCompetitivePricingForASIN", GetCompetitivePricingForASINResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetCompetitivePricingForSKU", new RequestType("GetCompetitivePricingForSKU", GetCompetitivePricingForSKUResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetLowestOfferListingsForASIN", new RequestType("GetLowestOfferListingsForASIN", GetLowestOfferListingsForASINResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetLowestOfferListingsForSKU", new RequestType("GetLowestOfferListingsForSKU", GetLowestOfferListingsForSKUResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetLowestPricedOffersForASIN", new RequestType("GetLowestPricedOffersForASIN", GetLowestPricedOffersForASINResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetLowestPricedOffersForSKU", new RequestType("GetLowestPricedOffersForSKU", GetLowestPricedOffersForSKUResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetMatchingProduct", new RequestType("GetMatchingProduct", GetMatchingProductResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetMatchingProductForId", new RequestType("GetMatchingProductForId", GetMatchingProductForIdResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetMyPriceForASIN", new RequestType("GetMyPriceForASIN", GetMyPriceForASINResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetMyPriceForSKU", new RequestType("GetMyPriceForSKU", GetMyPriceForSKUResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetProductCategoriesForASIN", new RequestType("GetProductCategoriesForASIN", GetProductCategoriesForASINResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetProductCategoriesForSKU", new RequestType("GetProductCategoriesForSKU", GetProductCategoriesForSKUResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.GetServiceStatus", new RequestType("GetServiceStatus", co.amasel.model.products.GetServiceStatusResponse.class, servicePathStr, serviceVersion));
        methodMap.put("products.ListMatchingProducts", new RequestType("ListMatchingProducts", ListMatchingProductsResponse.class, servicePathStr, serviceVersion));
    }

    static public void initOrders(){
        MarketplaceWebServiceOrdersConfig cfg = new MarketplaceWebServiceOrdersConfig();
        String servicePathStr;
        String serviceVersion = cfg.getServiceVersion();

        cfg.setServiceURL(MWSEndpoint.UK_PROD.toString());
        try {
            URI endPoint = new URI(cfg.getServiceURL());
            // No leading '/' in path, fucks up MwsConnection later
            servicePathStr = endPoint.getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        methodMap.put("orders.ListOrders", new RequestType("ListOrders", ListOrdersResponse.class, servicePathStr, serviceVersion));
        methodMap.put("orders.ListOrdersByNextToken", new RequestType("ListOrdersByNextToken", ListOrdersByNextTokenResponse.class, servicePathStr, serviceVersion));
        methodMap.put("orders.GetOrder", new RequestType("GetOrder", GetOrderResponse.class, servicePathStr, serviceVersion));
        methodMap.put("orders.ListOrderItems", new RequestType("ListOrderItems", ListOrderItemsResponse.class, servicePathStr, serviceVersion));
        methodMap.put("orders.ListOrderItemsByNextToken", new RequestType("ListOrderItemsByNextToken", ListOrderItemsByNextTokenResponse.class, servicePathStr, serviceVersion));
        methodMap.put("orders.GetServiceStatus", new RequestType("GetServiceStatus", co.amasel.model.orders.GetServiceStatusResponse.class, servicePathStr, serviceVersion));

    }

    static public void initFeedsReports(){
        MarketplaceWebServiceConfig cfg = new MarketplaceWebServiceConfig();
        String servicePathStr;
        String serviceVersion = cfg.getServiceVersion();

        cfg.setServiceURL(MWSEndpoint.UK_PROD.toString());
        try {
            URI endPoint = new URI(cfg.getServiceURL());
            // No leading '/' in path, fucks up MwsConnection later
            servicePathStr = endPoint.getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        methodMap.put("feeds.SubmitFeed", new RequestType("SubmitFeed", SubmitFeedResponse.class, servicePathStr, serviceVersion));
        methodMap.put("feeds.GetFeedSubmissionList", new RequestType("GetFeedSubmissionList", GetFeedSubmissionListResponse.class, servicePathStr, serviceVersion));
        methodMap.put("feeds.GetFeedSubmissionListByNextToken", new RequestType("GetFeedSubmissionListByNextToken", GetFeedSubmissionListByNextTokenResponse.class, servicePathStr, serviceVersion));
        methodMap.put("feeds.GetFeedSubmissionCount", new RequestType("GetFeedSubmissionCount", GetFeedSubmissionCountResponse.class, servicePathStr, serviceVersion));
        methodMap.put("feeds.CancelFeedSubmissions", new RequestType("CancelFeedSubmissions", CancelFeedSubmissionsResponse.class, servicePathStr, serviceVersion));
        methodMap.put("feeds.GetFeedSubmissionResult", new RequestType("GetFeedSubmissionResult", GetFeedSubmissionResultResponse.class, servicePathStr, serviceVersion));


        methodMap.put("reports.RequestReport", new RequestType("RequestReport", RequestReportResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.GetReportRequestList", new RequestType("GetReportRequestList", GetReportRequestListResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.GetReportRequestListByNextToken", new RequestType("GetReportRequestListByNextToken", GetReportRequestListByNextTokenResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.GetReportRequestCount", new RequestType("GetReportRequestCount", GetReportRequestCountResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.CancelReportRequests", new RequestType("CancelReportRequests", CancelReportRequestsResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.GetReportList", new RequestType("GetReportList", GetReportListResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.GetReportListByNextToken", new RequestType("GetReportListByNextToken", GetReportListByNextTokenResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.GetReportCount", new RequestType("GetReportCount", GetReportCountResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.GetReport", new RequestType("GetReport", GetReportResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.ManageReportSchedule", new RequestType("ManageReportSchedule", ManageReportScheduleResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.GetReportScheduleList", new RequestType("GetReportScheduleList", GetReportScheduleListResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.GetReportScheduleListByNextToken", new RequestType("GetReportScheduleListByNextToken", GetReportScheduleListByNextTokenResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.GetReportScheduleCount", new RequestType("GetReportScheduleCount", GetReportScheduleCountResponse.class, servicePathStr, serviceVersion));
        methodMap.put("reports.GetReportScheduleCount", new RequestType("GetReportScheduleCount", GetReportScheduleCountResponse.class, servicePathStr, serviceVersion));

    }


    static {
        initProducts();
        initOrders();
        initFeedsReports();
    }

    protected static class RequestType /*implements MwsRequestType*/ {

        private final String operationName;
        private final Class<? extends AmaselMwsObject> responseClass;
        private final String servicePath;
        private final String serviceVersion;

        public RequestType(String operationName, Class<? extends AmaselMwsObject> responseClass, String servicePath, String serviceVersion) {
            this.operationName = operationName;
            this.responseClass = responseClass;
            this.servicePath = servicePath;
            this.serviceVersion = serviceVersion;
        }

        //@Override
        public String getServicePath() {
            return this.servicePath;
        }

        public String getServiceVersion() {
            return this.serviceVersion;
        }

        //@Override
        public String getOperationName() {
            return this.operationName;
        }

        //@Override
        public Class<? extends AmaselMwsObject> getResponseClass() {
            return this.responseClass;
        }

        //@Override
        public MwsException wrapException(Throwable cause) {
            return new MwsException(cause);
        }

        //@Override
        public void setRHMD(MwsObject response, MwsResponseHeaderMetadata rhmd) {
            ((AmaselMwsObject)response).setMwsHeaderMetadata(rhmd);
        }
    }
}
