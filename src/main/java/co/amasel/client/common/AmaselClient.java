package co.amasel.client.common;

import co.amasel.*;
import co.amasel.misc.BeanAccess;
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
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by zaro on 5/20/16.
 */
public class AmaselClient extends AmaselClientBase {
    Vertx vertx;

    public AmaselClient(Vertx vertx) {
        this.vertx = vertx;
    }

    @Override
    public Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, MwsObject requestObject, String endPoint, AmazonCredentials credentials) throws ApiRequestException {
        final Future<MwsApiResponse> result = Future.future();
        if(apiCallDescription == null){
            throw new ApiRequestException("Invalid method description: null");
        }
        HttpClientOptions opts = new HttpClientOptions().setSsl(endPoint.startsWith("https")).setKeepAlive(true);
        opts.setTcpNoDelay(true);
        opts.setConnectTimeout(50000);
        opts.setIdleTimeout(50000);

        io.vertx.core.http.HttpClient client = vertx.createHttpClient(opts);
        if(endPoint.charAt(endPoint.length()-1) == '/'){
            endPoint = endPoint.substring(0,endPoint.length()-1);
        }
        String uri = endPoint + apiCallDescription.getServicePath();
        long startTime = System.currentTimeMillis();
        System.out.println(uri);
        HttpClientRequest request = client.postAbs(uri, response -> {
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            //System.out.print("TIME TO REQ:");
            //System.out.println(elapsedTime);
            //System.out.println("> " + response.statusCode() + " " + response.statusMessage());
            if(apiCallDescription.getOperationName().equals("GetReport")) {
                response.bodyHandler(getGetReportHandler(apiCallDescription, result, response));
            } else {
                response.bodyHandler(getMwsCallHandler(apiCallDescription, result, response));
            }
            response.exceptionHandler( exception -> {
                logger.error(exception);
                result.fail(exception);
            });
        });
        request.exceptionHandler( exception ->{
            logger.error(exception);
            result.fail(exception);
        });
        request.putHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        request.putHeader("X-Amazon-User-Agent", getUserAgent());
        request.putHeader("User-Agent", getUserAgent());
        request.putHeader("Connection", "Keep-Alive");
        Request r = new Request( credentials, apiCallDescription.getOperationName()).withRequest(requestObject);

        System.out.println(uri);

        try {
            String requestBody = r.getRequestBody(uri, apiCallDescription.getServiceVersion());
            request.end(requestBody);
        } catch (RuntimeException exception) {
            throw new ApiRequestException(exception.toString());
        }
        return result;
    }

    @NotNull
    private Handler<Buffer> getMwsCallHandler(MwsApiCall apiCallDescription, Future<MwsApiResponse> result, HttpClientResponse response) {
        return totalBuffer -> {
            MwsResponseHeaderMetadata meta = getResponseHeaderMetadata(response);
            AmaselMwsObject responseObject = MwsUtl.newInstance(apiCallDescription.getResponseClass());
            responseObject.setMwsHeaderMetadata(meta);
            //System.out.println(totalBuffer);
            MwsXmlReader reader = new MwsXmlReader(totalBuffer.toString());
            if( response.statusCode() == 200) {
                responseObject.readFragmentFrom(reader);
                MwsObject mwsResult = null;
                List<MwsObject> mwsResultList = null;
                Object o = BeanAccess.getProperty(responseObject, apiCallDescription.getOperationName() + "Result");
                if (o instanceof List) {
                    mwsResultList = (List<MwsObject>) o;
                } else {
                    mwsResult = (MwsObject) o;
                }
                logger.info("COMPLETE");
                result.complete(new MwsApiResponse(meta, responseObject, mwsResult, mwsResultList, false, totalBuffer, response.getHeader("Content-Type")));
            } else if( response.statusCode() >=400 ){
                System.out.println("WTF >=400");
                MwsException.XmlMwsException parsed = reader.read("Error", MwsException.XmlMwsException.class);
                result.complete(new MwsApiResponse(meta, responseObject, parsed, null, false, totalBuffer, response.getHeader("Content-Type")));
            } else {
                System.out.println("WTF");
                result.complete(new MwsApiResponse(meta, "Unknown response from Amazon MWS:" + response.statusCode() + " " +response.statusMessage() ));
            }
        };
    }


    @NotNull
    private Handler<Buffer> getGetReportHandler(MwsApiCall apiCallDescription, Future<MwsApiResponse> result, HttpClientResponse response) {
        return totalBuffer -> {
            MwsResponseHeaderMetadata meta = getResponseHeaderMetadata(response);
            if( response.statusCode() == 200) {
                String md5Hash = null;
                try {
                    MessageDigest md5Calc = MessageDigest.getInstance("MD5");
                    md5Calc.update(totalBuffer.getBytes());
                    md5Hash = Base64.getEncoder().encodeToString(md5Calc.digest());
                } catch (NoSuchAlgorithmException e) {
                    md5Hash = "[FAILED TO CALCULATE MD5]";
                }
                String amazonMd5 = response.getHeader("Content-MD5");
                if(amazonMd5 == null){
                    amazonMd5 = "";
                }
                if( !md5Hash.equals(amazonMd5) ){
                    String error = "Invalid MD5 on received content: amazon=" + amazonMd5+ " , calculated=" + md5Hash;
                    result.complete(new MwsApiResponse(meta, error));
                }
                result.complete(new MwsApiResponse(meta, true, totalBuffer, response.getHeader("Content-Type")));
            } else if( response.statusCode() >=400 ){
                System.out.println("WTF >=400");
                AmaselMwsObject responseObject = MwsUtl.newInstance(apiCallDescription.getResponseClass());
                responseObject.setMwsHeaderMetadata(meta);
                MwsXmlReader reader = new MwsXmlReader(totalBuffer.toString());
                MwsException.XmlMwsException parsed = reader.read("Error", MwsException.XmlMwsException.class);
                result.complete(new MwsApiResponse(meta, responseObject, parsed, null, true, totalBuffer, response.getHeader("Content-Type")));
            } else {
                System.out.println("WTF");
                result.complete(new MwsApiResponse(meta, "Unknown response from Amazon MWS:" + response.statusCode() + " " +response.statusMessage() ));
            }
        };
    }

}
