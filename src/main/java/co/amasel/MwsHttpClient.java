package co.amasel;

//import co.amasel.model.common.AmaselMwsObject;
//import com.amazonservices.mws.client.*;
//import com.amazonservices.mws.products.model.MWSResponse;
//import io.vertx.core.Future;
//import io.vertx.core.Vertx;
//import io.vertx.core.http.HttpClient;
//import io.vertx.core.http.HttpClientOptions;
//import io.vertx.core.http.HttpClientRequest;
//import io.vertx.core.http.HttpClientResponse;
//import io.vertx.core.json.JsonObject;
//import io.vertx.core.logging.Logger;
//import io.vertx.core.logging.LoggerFactory;
////import jodd.bean.BeanUtil;
////import jodd.bean.BeanVisitor;
////import jodd.bean.BeanWalker;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.utils.URLEncodedUtils;
//import org.apache.http.message.BasicNameValuePair;
//
//import java.lang.reflect.InvocationTargetException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.*;

/**
 * Created by zaro on 11/23/15.
 */
public class MwsHttpClient {
//    private final Logger logger = LoggerFactory.getLogger("MwsHttpClient");
//
//    public MwsHttpClient(Vertx vertx) {
//        this.vertx = vertx;
//    }
//
//    Vertx vertx;
//
//    public static class Request {
//        /** The AWS access key id. */
//        final String awsAccessKeyId;
//
//        /** The AWS secret key id. */
//        final String awsSecretKeyId;
//
//        /** Method to use to create signature. */
//        final String signatureMethod = "HmacSHA256";
//
//        /** Use signature version. */
//        final String signatureVersion = "2";
//
//        /** The name of the operation to perform. */
//        final String operationName;
//
//        /** Container for parameters. */
//        private Map<String, String> parameters ;
//
//        String requestBody;
//
//        public Request(String awsAccessKeyId, String awsSecretKeyId, String operationName) {
//            this.awsAccessKeyId = awsAccessKeyId;
//            this.awsSecretKeyId = awsSecretKeyId;
//            this.operationName = operationName;
//        }
//
//        public Request withRequest(MwsObject object){
//            MwsObjectToPostParams p = new MwsObjectToPostParams();
//            object.writeFragmentTo(p);
//            parameters = p.getParameters();
//            return this;
//        }
//
//        public String getRequestBody(String serviceEndpointUrl, String serviceEndpointVersion) {
//
//            if (requestBody != null){
//                return requestBody;
//            }
//
//            URI serviceEndpointUri;
//            try {
//                serviceEndpointUri = new URI(serviceEndpointUrl);
//                if(serviceEndpointUri.getPath().isEmpty()){
//                    serviceEndpointUri = serviceEndpointUri.resolve("/");
//                }
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//                return null;
//            }
//            parameters.put("Action", operationName);
//            parameters.put("Version", serviceEndpointVersion);
//            parameters.put("Timestamp", MwsUtl.getFormattedTimestamp());
//            parameters.put("AWSAccessKeyId", getAwsAccessKeyId());
//            String signature = MwsUtl.signParameters(serviceEndpointUri,
//                    getSignatureVersion(),
//                    getSignatureMethod(), parameters,
//                    getAwsSecretKeyId());
//            parameters.put("Signature", signature);
//            List<NameValuePair> parameterList = new ArrayList<NameValuePair>();
//            for (Map.Entry<String, String> entry : parameters.entrySet()) {
//                String key = entry.getKey();
//                String value = entry.getValue();
//                if (!(key == null || key.equals("") || value == null || value
//                        .equals(""))) {
//                    parameterList.add(new BasicNameValuePair(key, value));
//                }
//            }
//            return requestBody = URLEncodedUtils.format(parameterList, "UTF-8");
//        }
//
//        public String getAwsAccessKeyId() {
//            return awsAccessKeyId;
//        }
//
//        public String getAwsSecretKeyId() {
//            return awsSecretKeyId;
//        }
//
//        public String getSignatureMethod() {
//            return signatureMethod;
//        }
//
//        public String getSignatureVersion() {
//            return signatureVersion;
//        }
//
//    }
//
//    public static class Response {
//        public MwsResponseHeaderMetadata meta;
//        public AmaselMwsObject response;
//        public final MwsObject result;
//        public final List<MwsObject> resultList;
//
//        public Response(MwsResponseHeaderMetadata meta, AmaselMwsObject response, MwsObject result, List<MwsObject> resultList) {
//            this.meta = meta;
//            this.response = response;
//            this.result = result;
//            this.resultList = resultList;
//        }
//    }
//
//
//    public String getUserAgent() {
//        return "test/1.0 (Language=Java/1.8.0_66/52.0/Oracle Corporation; Platform=Mac OS X/x86_64/10.11.1; MWSClientVersion=2015-09-01)";
//    }
//
//    public Future<Response> invoke(String methodKey, MwsObject requestObject, String endPoint, String awsAccessKeyId, String awsSecretKeyId) throws ApiRequestException {
//        final Future<Response> result = Future.future();
//        MwsMethodMap.RequestType reqType = MwsMethodMap.get(methodKey);
//        if(reqType == null){
//            throw new ApiRequestException("Invalid method : \"" + methodKey + "\"");
//        }
//        final String method = reqType.getOperationName();
//        HttpClientOptions opts = new HttpClientOptions().setSsl(endPoint.startsWith("https")).setKeepAlive(true);
//        opts.setTcpNoDelay(true);
//        opts.setConnectTimeout(50000);
//        opts.setIdleTimeout(50000);
//
//        HttpClient client = vertx.createHttpClient(opts);
//        if(endPoint.charAt(endPoint.length()-1) == '/'){
//            endPoint = endPoint.substring(0,endPoint.length()-1);
//        }
//        String uri = endPoint + reqType.getServicePath();
//        long startTime = System.currentTimeMillis();
//        System.out.println(uri);
//        HttpClientRequest request = client.postAbs(uri, response -> {
//            long stopTime = System.currentTimeMillis();
//            long elapsedTime = stopTime - startTime;
//            System.out.print("TIME TO REQ:");
//            System.out.println(elapsedTime);
//            System.out.println("> " + response.statusCode() + " " + response.statusMessage());
//            response.bodyHandler(totalBuffer -> {
//                long stopTime1 = System.currentTimeMillis();
//                long elapsedTime1 = stopTime1 - startTime;
//                System.out.print("TIME TO BODY:");
//                System.out.println(elapsedTime1);
//                MwsResponseHeaderMetadata meta = getResponseHeaderMetadata(response);
//                AmaselMwsObject responseObject = MwsUtl.newInstance(reqType.getResponseClass());
//                reqType.setRHMD(responseObject, meta);
//                System.out.println(totalBuffer);
//                MwsXmlReader reader = new MwsXmlReader(totalBuffer.toString());
//                if( response.statusCode() == 200) {
//                    responseObject.readFragmentFrom(reader);
//                    MwsObject mwsResult = null;
//                    List<MwsObject> mwsResultList = null;
//                    Object o = BeanAccess.getProperty(responseObject, method + "Result");
//                    if (o instanceof List) {
//                        mwsResultList = (List<MwsObject>) o;
//                    } else {
//                        mwsResult = (MwsObject) o;
//                    }
//                    logger.info("COMPLETE");
//                    result.complete(new Response(meta, responseObject, mwsResult, mwsResultList));
//                } else if( response.statusCode() >=400 ){
//                    System.out.println("WTF >=400");
//                    AmaselMwsException.XmlMwsException parsed = reader.read("Error", AmaselMwsException.XmlMwsException.class);
//                    result.complete(new Response(meta, responseObject, parsed, null));
//                } else {
//                    System.out.println("WTF");
//                }
//            });
//            response.exceptionHandler( exception -> {
//                logger.error(exception);
//                result.fail(exception);
//            });
//        });
//        request.exceptionHandler( exception ->{
//            logger.error(exception);
//            result.fail(exception);
//        });
//        request.putHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
//        request.putHeader("X-Amazon-User-Agent", getUserAgent());
//        request.putHeader("User-Agent", getUserAgent());
//        request.putHeader("Connection", "Keep-Alive");
//        Request r = new Request( awsAccessKeyId, awsSecretKeyId, reqType.getOperationName()).withRequest(requestObject);
//
//        System.out.println(uri);
//        String requestBody = r.getRequestBody(uri, reqType.getServiceVersion());
//        System.out.println(requestBody);
//        request.end(requestBody);
//        return result;
//    }
//
//    public MwsObject createRequestFromJson(String methodKey, JsonObject obj) throws ApiRequestException {
//        MwsMethodMap.RequestType r = MwsMethodMap.get(methodKey);
//        if( r == null ){
//            return null;
//        }
//        try {
//            Class cls = Class.forName("co.amasel.model." + methodKey + "Request");
//            MwsObject mwsObject = (MwsObject) (new MwsJsonObjectReader(obj)).readValue(cls);
//            return mwsObject;
//        } catch (ClassNotFoundException e) {
//            throw new ApiRequestException("Cannot find request class for method: " + methodKey);
//        }
//    }
//
//    /**
//     * Get the metadata from the response headers.
//     *
//     * @param response
//     *
//     * @return The metadata.
//     */
//    private MwsResponseHeaderMetadata getResponseHeaderMetadata(HttpClientResponse response) {
//        String requestId = response.getHeader("x-mws-request-id");
//
//        String timestamp = response.getHeader("x-mws-timestamp");
//
//        String contextString = response.getHeader("x-mws-response-context");
//        List<String> context = contextString != null ? Collections.unmodifiableList(Arrays.asList(contextString.split(","))) : null;
//
//        Double quotaMax;
//        try {
//            String quotaMaxHeader = response.getHeader("x-mws-quota-max");
//            quotaMax = quotaMaxHeader == null ? null : Double.valueOf(quotaMaxHeader);
//        } catch (NumberFormatException ex) {
//            quotaMax = null;
//        }
//
//        Double quotaRemaining;
//        try {
//            String quotaRemainingHeader = response.getHeader("x-mws-quota-remaining");
//            quotaRemaining = quotaRemainingHeader == null ? null : Double.valueOf(quotaRemainingHeader);
//        } catch (NumberFormatException ex) {
//            quotaRemaining = null;
//        }
//
//        Date quotaResetDate;
//        try {
//            String quotaResetHeader = response.getHeader("x-mws-quota-resetsOn");
//            quotaResetDate = quotaResetHeader == null ? null : MwsUtl.parseTimestamp(quotaResetHeader);
//        } catch (java.text.ParseException ex) {
//            quotaResetDate = null;
//        }
//
//        return new MwsResponseHeaderMetadata(requestId, context, timestamp, quotaMax, quotaRemaining, quotaResetDate);
//    }
//

}
