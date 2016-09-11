package co.amasel.client.common;

import co.amasel.*;
import co.amasel.misc.BeanAccess;
import co.amasel.model.common.AmaselMwsException;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import com.amazonservices.mws.client.MwsXmlReader;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.rx.java.RxHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/*
<ns0:ErrorResponse xmlns:ns0="https://mws.amazonservices.com/Orders/2013-09-01">
        <ns0:Error>
        <ns0:Type />
        <ns0:Code>RequestThrottled</ns0:Code>
        <ns0:Message>Request is throttled</ns0:Message>
        </ns0:Error>
        <ns0:RequestID>0648fc1c-009b-420b-8430-ae0072b44e9b</ns0:RequestID>
        </ns0:ErrorResponse>
*/

/**
 * Created by zaro on 5/20/16.
 */
public class AmaselClient extends AmaselClientBase {
    public Vertx vertx;

    public static AmaselClient fromVertxInstance(Vertx vertx) {
        AmaselClient c = new AmaselClient();
        c.vertx = vertx;
        return  c;
    }

    protected class AmaselClientRequest {
        public final MwsApiCall apiCallDescription;
        public final MwsObject requestObject;
        public final Future<MwsApiResponse> result;
        public final HttpClientOptions opts;
        public final String uri;
        public final AmazonCredentials credentials;
        HttpResponseHandler responseHandler;
        int numberOfRetries;
        int retryDelayMs;

        public AmaselClientRequest(MwsApiCall apiCallDescription, MwsObject requestObject, Future<MwsApiResponse> result, String endPoint, AmazonCredentials credentials, int numberOfRetries) {
            this.apiCallDescription = apiCallDescription;
            this.requestObject = requestObject;
            this.result = result;

            opts = new HttpClientOptions().setSsl(endPoint.startsWith("https")).setKeepAlive(true);
            opts.setTcpNoDelay(true);
            opts.setConnectTimeout(50000);
            opts.setIdleTimeout(50000);

            if(endPoint.charAt(endPoint.length()-1) == '/'){
                endPoint = endPoint.substring(0,endPoint.length()-1);
            }
            uri = endPoint + apiCallDescription.getServicePath();
            this.credentials = credentials;
            this.numberOfRetries = numberOfRetries;
            this.retryDelayMs = 1000;
        }

        HttpResponseHandler getResponseHandler(){
            if(responseHandler == null){
                responseHandler = new HttpResponseHandler();
            }
            return responseHandler;
        }


        public void makeRequest() throws ApiRequestException {
            io.vertx.core.http.HttpClient client = vertx.createHttpClient(opts);

            HttpClientRequest request = client.postAbs(uri, getResponseHandler());
            request.exceptionHandler( exception ->{
                failRequest(exception);
            });
            request.putHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            request.putHeader("X-Amazon-User-Agent", getUserAgent());
            request.putHeader("User-Agent", getUserAgent());
            request.putHeader("Connection", "Keep-Alive");
            Request r = new Request( credentials, apiCallDescription.getOperationName()).withRequest(requestObject);

            try {
                String requestBody = r.getRequestBody(uri, apiCallDescription.getServiceVersion());
                request.end(requestBody);
            } catch (RuntimeException exception) {
                throw new ApiRequestException(exception.toString());
            }
        }

        protected void completeRequest(MwsApiResponse apiResponse){
            result.complete(apiResponse);
        }

        protected void failRequest(Throwable exception){
            logger.error(exception);
            result.fail(exception);
        }

        public boolean retryRequest(AmaselMwsException.XmlMwsException xmlException){
            if(numberOfRetries == 0){
                return false;
            }
            if(xmlException != null){
                if(xmlException.getErrorCode().equals("RequestThrottled")){
                    numberOfRetries--;
                } else {
                    return false;
                }
            } else {
                numberOfRetries--;
            }
            logger.info("Retry request.");
            vertx.setTimer(retryDelayMs, id->{
                try {
                    makeRequest();
                } catch (ApiRequestException e) {
                    logger.error("Failed to retry request" + e);
                }
            });
            retryDelayMs = (int)(1.5 * (double)retryDelayMs);
            return true;
        }

        protected class HttpResponseHandler implements Handler<HttpClientResponse> {
            HttpClientResponse response = null;
            Handler<Buffer> handler = null;
            long startTime;

            Handler<Buffer> getBodyHandler() {
                startTime = System.currentTimeMillis();
                //response.bodyHandler();
                if (handler == null) {
                    if (apiCallDescription.getOperationName().equals("GetReport")) {
                        handler = new GertReportHandler();
                    } else {
                        handler = new MwsCallHandler();
                    }
                }
                return handler;
            }

            @Override
            public void handle(HttpClientResponse response) {
                this.response = response;
                long stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                //System.out.print("TIME TO REQ:");
                //System.out.println(elapsedTime);
                //System.out.println("> " + response.statusCode() + " " + response.statusMessage());
                response.bodyHandler(getBodyHandler());
                response.exceptionHandler(exception -> {
                    failRequest(exception);
                });

            }

            class MwsCallHandler implements Handler<Buffer> {

                @Override
                public void handle(Buffer totalBuffer) {
                    MwsResponseHeaderMetadata meta = getResponseHeaderMetadata(response);
                    AmaselMwsObject responseObject = MwsUtl.newInstance(apiCallDescription.getResponseClass());
                    responseObject.setMwsHeaderMetadata(meta);
                    MwsXmlReader reader = new MwsXmlReader(totalBuffer.toString());
                    if (response.statusCode() == 200) {
                        responseObject.readFragmentFrom(reader);
                        AmaselMwsObject mwsResult = null;
                        List<AmaselMwsObject> mwsResultList = null;
                        Object o = BeanAccess.getProperty(responseObject, apiCallDescription.getOperationName() + "Result");
                        if (o instanceof List) {
                            mwsResultList = (List<AmaselMwsObject>) o;
                        } else {
                            mwsResult = (AmaselMwsObject) o;
                        }
                        logger.info("COMPLETE");
                        completeRequest(new MwsApiResponse(meta, responseObject, mwsResult, mwsResultList, false, totalBuffer, response.headers()));
                    } else if (response.statusCode() >= 400) {
                        System.out.println("WTF >=400");
                        AmaselMwsException.XmlMwsException parsed = reader.read("Error", AmaselMwsException.XmlMwsException.class);
                        if(!retryRequest(parsed)) {
                            completeRequest(new MwsApiResponse(meta, responseObject, parsed, null, false, totalBuffer, response.headers()));
                        }
                    } else {
                        System.out.println("WTF");
                        completeRequest(new MwsApiResponse(meta, "Unknown response from Amazon MWS:" + response.statusCode() + " " + response.statusMessage()));
                    }
                }
            }

            protected class GertReportHandler implements Handler<Buffer> {

                @Override
                public void handle(Buffer totalBuffer) {
                    MwsResponseHeaderMetadata meta = getResponseHeaderMetadata(response);
                    if (response.statusCode() == 200) {
                        String md5Hash = null;
                        try {
                            MessageDigest md5Calc = MessageDigest.getInstance("MD5");
                            md5Calc.update(totalBuffer.getBytes());
                            md5Hash = Base64.getEncoder().encodeToString(md5Calc.digest());
                        } catch (NoSuchAlgorithmException e) {
                            md5Hash = "[FAILED TO CALCULATE MD5]";
                        }
                        String amazonMd5 = response.getHeader("Content-MD5");
                        if (amazonMd5 == null) {
                            amazonMd5 = "[MISSING]";
                        }
                        if (!md5Hash.equals(amazonMd5)) {
                            String error = "Invalid MD5 on received content: amazon=" + amazonMd5 + " , calculated=" + md5Hash;
                            completeRequest(new MwsApiResponse(meta, error));
                        } else {
                            completeRequest(new MwsApiResponse(meta, true, totalBuffer, response.headers()));
                        }
                    } else if (response.statusCode() >= 400) {
                        System.out.println("WTF >=400");
                        AmaselMwsObject responseObject = MwsUtl.newInstance(apiCallDescription.getResponseClass());
                        responseObject.setMwsHeaderMetadata(meta);
                        MwsXmlReader reader = new MwsXmlReader(totalBuffer.toString());
                        AmaselMwsException.XmlMwsException parsed = reader.read("Error", AmaselMwsException.XmlMwsException.class);
                        if(!retryRequest(parsed)) {
                            completeRequest(new MwsApiResponse(meta, responseObject, parsed, null, true, totalBuffer, response.headers()));
                        }
                    } else {
                        System.out.println("WTF");
                        completeRequest(new MwsApiResponse(meta, "Unknown response from Amazon MWS:" + response.statusCode() + " " + response.statusMessage()));
                    }
                }
            }
        }
    }

    public Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, AmaselMwsObject requestObject, String endPoint, AmazonCredentials credentials) throws ApiRequestException {
        final Future<MwsApiResponse> result = Future.future();
        if(apiCallDescription == null){
            throw new ApiRequestException("Invalid method description: null");
        }
        new AmaselClientRequest(apiCallDescription, requestObject,result, endPoint,credentials, 3).makeRequest();
        return result;
    }

    public Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, JsonObject requestObject, String endPoint, AmazonCredentials credentials) throws ApiRequestException {
        final Future<MwsApiResponse> result = Future.future();
        if(apiCallDescription == null){
            throw new ApiRequestException("Invalid method description: null");
        }
        // Create a request.
        MwsObject request = createRequestFromJson(apiCallDescription, requestObject);

        new AmaselClientRequest(apiCallDescription, request,result, endPoint,credentials, 3).makeRequest();
        return result;
    }

}
