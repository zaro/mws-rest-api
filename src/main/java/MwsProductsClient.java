import co.amasel.ApiRequestException;
import co.amasel.MwsJsonObjectReader;
import com.amazonservices.mws.client.*;
import com.amazonservices.mws.products.MarketplaceWebServiceProductsConfig;
import com.amazonservices.mws.products.MarketplaceWebServiceProductsException;
import com.amazonservices.mws.products.model.*;
import io.vertx.core.json.JsonObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zaro on 11/21/15.
 */
public class MwsProductsClient {

    private static final String libraryName = "MarketplaceWebServiceProducts";

    private static final String libraryVersion = "2015-09-01";

    protected final MwsConnection connection;

    protected HashMap<String, RequestType> methodMap = new HashMap<>();

    public MwsProductsClient(
            String accessKey,
            String secretKey,
            String applicationName,
            String applicationVersion,
            String servicePath) {
        MarketplaceWebServiceProductsConfig cfg = new MarketplaceWebServiceProductsConfig();
        cfg.setServiceURL(servicePath);
        String servicePathStr = null;
        URI endPoint = null;
        try {
            endPoint = new URI(cfg.getServiceURL());
            // No leading '/' in path, fucks up MwsConnection later
            servicePathStr = endPoint.getPath().substring(1);
            endPoint = new URI(servicePath);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        connection = new MwsConnection(endPoint, applicationName, applicationVersion, accessKey, secretKey);
        connection.setAwsAccessKeyId(accessKey);
        connection.setAwsSecretKeyId(secretKey);
        connection.setApplicationName(applicationName);
        connection.setApplicationVersion(applicationVersion);
        connection.setLibraryVersion(libraryVersion);
        //connection.setProxyHost("localhost");
        //connection.setProxyPort(8000);

        methodMap.put("GetCompetitivePricingForASIN", new RequestType("GetCompetitivePricingForASIN", GetCompetitivePricingForASINResponse.class, servicePathStr));
        methodMap.put("GetCompetitivePricingForSKU", new RequestType("GetCompetitivePricingForSKU", GetCompetitivePricingForSKUResponse.class, servicePathStr));
        methodMap.put("GetLowestOfferListingsForASIN", new RequestType("GetLowestOfferListingsForASIN", GetLowestOfferListingsForASINResponse.class, servicePathStr));
        methodMap.put("GetLowestOfferListingsForSKU", new RequestType("GetLowestOfferListingsForSKU", GetLowestOfferListingsForSKUResponse.class, servicePathStr));
        methodMap.put("GetLowestPricedOffersForASIN", new RequestType("GetLowestPricedOffersForASIN", GetLowestPricedOffersForASINResponse.class, servicePathStr));
        methodMap.put("GetLowestPricedOffersForSKU", new RequestType("GetLowestPricedOffersForSKU", GetLowestPricedOffersForSKUResponse.class, servicePathStr));
        methodMap.put("GetMatchingProduct", new RequestType("GetMatchingProduct", GetMatchingProductResponse.class, servicePathStr));
        methodMap.put("GetMatchingProductForId", new RequestType("GetMatchingProductForId", GetMatchingProductForIdResponse.class, servicePathStr));
        methodMap.put("GetMyPriceForASIN", new RequestType("GetMyPriceForASIN", GetMyPriceForASINResponse.class, servicePathStr));
        methodMap.put("GetMyPriceForSKU", new RequestType("GetMyPriceForSKU", GetMyPriceForSKUResponse.class, servicePathStr));
        methodMap.put("GetProductCategoriesForASIN", new RequestType("GetProductCategoriesForASIN", GetProductCategoriesForASINResponse.class, servicePathStr));
        methodMap.put("GetProductCategoriesForSKU", new RequestType("GetProductCategoriesForSKU", GetProductCategoriesForSKUResponse.class, servicePathStr));
        methodMap.put("GetServiceStatus", new RequestType("GetServiceStatus", GetServiceStatusResponse.class, servicePathStr));
        methodMap.put("ListMatchingProducts", new RequestType("ListMatchingProducts", ListMatchingProductsResponse.class, servicePathStr));
    }

    public boolean hasMethod(String method){
        return methodMap.containsKey(method);
    }

    public String ucFirst(String s){
        char c[] = s.toCharArray();
        c[0] = Character.toLowerCase(c[0]);
        return new String(c);
    }

    public MwsObject createRequestFromJson(String method, JsonObject obj) throws ApiRequestException {
        RequestType r = methodMap.getOrDefault(method, null);
        if( r == null ){
            return null;
        }
        try {
            Class cls = Class.forName("co.amasel.model.products." + method + "Request");
            MwsObject mwsObject = (MwsObject) cls.newInstance();
            MwsJsonObjectReader reader = new MwsJsonObjectReader(obj);
            mwsObject.readFragmentFrom(reader);
            return mwsObject;
        } catch (ClassNotFoundException e) {
            throw new ApiRequestException("Cannot find request class for method: " + method);
        } catch (InstantiationException e) {
            throw new ApiRequestException("Cannot create request class for method: " + method);
        } catch (IllegalAccessException e) {
            throw new ApiRequestException("Cannot create request class for method: " + method);
        }
    }

    public Result invoke(String method, MwsObject request) throws ApiRequestException {
        RequestType r = methodMap.getOrDefault(method, null);
        if(r != null){
            long startTime = System.currentTimeMillis();
            MWSResponse obj = connection.call( r, request);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(elapsedTime);
            Method methodRef= null;
            AbstractMwsObject result = null;
            List<AbstractMwsObject> resultList = null;
            try {
                methodRef = obj.getClass().getMethod("get" + method + "Result");
                Object o = methodRef.invoke(obj);
                if (o instanceof List) {
                    resultList = (List<AbstractMwsObject>) o;
                } else {
                    result = (AbstractMwsObject) o;
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return new Result(obj, result, resultList);
        }
        throw new ApiRequestException("Invalid method : \"" + method + "\"");
    }

    public static class Result {
        public final MWSResponse response;
        public final AbstractMwsObject result;
        public final List<AbstractMwsObject> resultList;

        public Result(MWSResponse response, AbstractMwsObject result, List<AbstractMwsObject> resultList) {
            this.response = response;
            this.result = result;
            this.resultList = resultList;
        }
    }

    protected static class RequestType implements MwsRequestType {

        private final String operationName;
        private final Class<? extends MWSResponse> responseClass;
        private final String servicePath;

        public RequestType(String operationName, Class<? extends MWSResponse> responseClass, String servicePath) {
            this.operationName = operationName;
            this.responseClass = responseClass;
            this.servicePath = servicePath;
        }

        @Override
        public String getServicePath() {
            return this.servicePath;
        }

        @Override
        public String getOperationName() {
            return this.operationName;
        }

        @Override
        public Class<? extends MwsObject> getResponseClass() {
            return this.responseClass;
        }

        @Override
        public MwsException wrapException(Throwable cause) {
            return new MarketplaceWebServiceProductsException(cause);
        }

        @Override
        public void setRHMD(MwsObject response, MwsResponseHeaderMetadata rhmd) {
            ((MWSResponse)response).setResponseHeaderMetadata(new ResponseHeaderMetadata(rhmd));
        }
    }

}
