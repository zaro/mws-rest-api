package co.amasel.client.common;

import co.amasel.client.common.AmaselClientException;
import co.amasel.model.common.MwsJsonObjectReader;
import co.amasel.model.common.MwsObjectToPostParams;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by zaro on 5/20/16.
 */
public abstract class AmaselClientBase {
    protected static String userAgentPlatform =
            "mws-rest-api/1.0 (Language=" +
                    System.getProperty("java.version") + "/" +
                    System.getProperty("java.class.version") + "/" +
                    System.getProperty("java.vendor") + "; Platform=" +

                    System.getProperty("os.name") + "/" +
                    System.getProperty("os.arch") + "/" +
                    System.getProperty("os.version") +
                    ")";

    protected final Logger logger = LoggerFactory.getLogger("AmaselClient");
    public AmazonCredentials credentials;
    public String endPoint;

    protected String userAgent = userAgentPlatform;

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String clientIdString() {
        return String.format("<%08x>",this.hashCode());
    }


    public MwsObject createRequestFromJson(MwsApiCall apiCallDescription, JsonObject obj) throws AmaselClientException {
        if (apiCallDescription == null) {
            return null;
        }
        Class cls = apiCallDescription.getRequestClass();
        try {
            MwsObject mwsObject = (MwsObject) (new MwsJsonObjectReader(obj)).readValue(cls);
            return mwsObject;
        } catch (Exception e) {
            throw new AmaselClientException(e);
        }
    }

    /**
     * Get the metadata from the response headers.
     *
     * @param response
     * @return The metadata.
     */
    protected MwsResponseHeaderMetadata getResponseHeaderMetadata(HttpClientResponse response) {
        String requestId = response.getHeader("x-mws-request-id");

        String timestamp = response.getHeader("x-mws-timestamp");

        String contextString = response.getHeader("x-mws-response-context");
        List<String> context = contextString != null ? Collections.unmodifiableList(Arrays.asList(contextString.split(","))) : null;

        Double quotaMax;
        try {
            String quotaMaxHeader = response.getHeader("x-mws-quota-max");
            quotaMax = quotaMaxHeader == null ? null : Double.valueOf(quotaMaxHeader);
        } catch (NumberFormatException ex) {
            quotaMax = null;
        }

        Double quotaRemaining;
        try {
            String quotaRemainingHeader = response.getHeader("x-mws-quota-remaining");
            quotaRemaining = quotaRemainingHeader == null ? null : Double.valueOf(quotaRemainingHeader);
        } catch (NumberFormatException ex) {
            quotaRemaining = null;
        }

        Date quotaResetDate;
        try {
            String quotaResetHeader = response.getHeader("x-mws-quota-resetsOn");
            quotaResetDate = quotaResetHeader == null ? null : MwsUtl.parseTimestamp(quotaResetHeader);
        } catch (java.text.ParseException ex) {
            quotaResetDate = null;
        }

        return new MwsResponseHeaderMetadata(requestId, context, timestamp, quotaMax, quotaRemaining, quotaResetDate);
    }

    protected String calcMD5(String message) {
        return calcMD5(message.getBytes());
    }

    protected String calcMD5(Buffer totalBuffer) {
        return calcMD5(totalBuffer.getBytes());
    }

    protected String calcMD5(byte[] buffer) {
        String md5Hash = null;
        try {
            MessageDigest md5Calc = MessageDigest.getInstance("MD5");
            md5Calc.update(buffer);
            md5Hash = Base64.getEncoder().encodeToString(md5Calc.digest());
        } catch (NoSuchAlgorithmException e) {
            md5Hash = "[FAILED TO CALCULATE MD5]";
        }
        return md5Hash;
    }

    public static class Request {


        AmazonCredentials credentials;
        /**
         * Method to use to create signature.
         */
        final String signatureMethod = "HmacSHA256";

        /**
         * Use signature version.
         */
        final String signatureVersion = "2";

        /**
         * The name of the operation to perform.
         */
        final String operationName;

        /**
         * Container for parameters.
         */
        private Map<String, String> parameters;

        String requestParams;
        String serviceEndpointUrl;
        String serviceEndpointVersion;

        public Request(String awsAccessKeyId, String awsSecretKeyId, String operationName) {
            credentials = new AmazonCredentials(awsAccessKeyId, awsSecretKeyId);
            this.operationName = operationName;
        }

        public Request(AmazonCredentials credentials, String operationName) {
            this.credentials = credentials;
            this.operationName = operationName;
        }

        public Request withRequest(MwsObject object) {
            MwsObjectToPostParams p = new MwsObjectToPostParams();
            object.writeFragmentTo(p);
            parameters = p.getParameters();
            return this;
        }

        public Request withServiceEndpoint(String serviceEndpointUrl, String serviceEndpointVersion) {
            this.serviceEndpointUrl = serviceEndpointUrl;
            this.serviceEndpointVersion = serviceEndpointVersion;
            return this;
        }

        public String getRequestQs() {

            return getRequestParams();
        }

        public String getRequestBody() {

            return getRequestParams();
        }

        public String getRequestParams() {
            if (requestParams != null) {
                return requestParams;
            }

            URI serviceEndpointUri;
            try {
                serviceEndpointUri = new URI(serviceEndpointUrl);
                if (serviceEndpointUri.getPath().isEmpty()) {
                    serviceEndpointUri = serviceEndpointUri.resolve("/");
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
                return null;
            }
            parameters.put("Action", operationName);
            parameters.put("Version", serviceEndpointVersion);
            parameters.put("Timestamp", MwsUtl.getFormattedTimestamp());
            parameters.put("AWSAccessKeyId", getAwsAccessKeyId());
            try {
                String signature = MwsUtl.signParameters(serviceEndpointUri,
                        getSignatureVersion(),
                        getSignatureMethod(), parameters,
                        getAwsSecretKeyId());
                parameters.put("Signature", signature);
            } catch (IllegalArgumentException e) {
                throw new AmaselClientException("Failed to sign MWS request:" + e.toString());
            }
            List<NameValuePair> parameterList = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!(key == null || key.equals("") || value == null || value
                        .equals(""))) {
                    parameterList.add(new BasicNameValuePair(key, value));
                }
            }
            return requestParams = URLEncodedUtils.format(parameterList, "UTF-8");
        }

        public String getAwsAccessKeyId() {
            return credentials.awsAccessKeyId != null ? credentials.awsAccessKeyId : "";
        }

        public String getAwsSecretKeyId() {
            return credentials.awsSecretKeyId;
        }

        public String getSignatureMethod() {
            return signatureMethod;
        }

        public String getSignatureVersion() {
            return signatureVersion;
        }

    }

    public AmaselClientBase withCredentials(AmazonCredentials credentials) {
        this.credentials = credentials;
        return this;
    }

    public AmaselClientBase withEndpoint(String endPoint) {
        this.endPoint = endPoint;
        return this;
    }

    public abstract Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, JsonObject requestObject, String endPoint, AmazonCredentials credentials) throws AmaselClientException;
    public abstract Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, AmaselMwsObject requestObject, String endPoint, AmazonCredentials credentials) throws AmaselClientException;

    public abstract Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, JsonObject requestObject, String endPoint) throws AmaselClientException;
    public abstract Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, AmaselMwsObject requestObject, String endPoint) throws AmaselClientException;

    public abstract Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, JsonObject requestObject) throws AmaselClientException;
    public abstract Future<MwsApiResponse> invoke(MwsApiCall apiCallDescription, AmaselMwsObject requestObject) throws AmaselClientException;
}
