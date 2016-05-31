package co.amasel.client.common;

import io.vertx.core.json.JsonObject;

/**
 * Created by zaro on 5/20/16.
 */
public class AmazonCredentials {
    /** The AWS access key id. */
    protected final String awsAccessKeyId;

    /** The AWS secret key id. */
    protected final String awsSecretKeyId;

    public String getAwsAccessKeyId() {
        return awsAccessKeyId;
    }

    public String getAwsSecretKeyId() {
        return awsSecretKeyId;
    }

    public AmazonCredentials(String awsAccessKeyId, String awsSecretKeyId) {
        this.awsAccessKeyId = awsAccessKeyId != null ? awsAccessKeyId : "";
        this.awsSecretKeyId = awsSecretKeyId != null ? awsSecretKeyId : "";
    }

    public AmazonCredentials(JsonObject obj) {
        if(obj.containsKey("AWSAccessKeyId")) {
            this.awsAccessKeyId = obj.getString("AWSAccessKeyId");
        } else {
            this.awsAccessKeyId = "";
        }
        if(obj.containsKey("AWSSecretKeyId")) {
            this.awsSecretKeyId = obj.getString("AWSSecretKeyId");
        } else {
            this.awsSecretKeyId = "";
        }
    }

    public static AmazonCredentials override(AmazonCredentials o, String awsAccessKeyId, String awsSecretKeyId) {
        String akey = (o !=null) ? o.awsAccessKeyId : null;
        String skey = (o !=null) ? o.awsSecretKeyId : null;
        if(awsAccessKeyId != null){
            akey = awsAccessKeyId;
        }
        if(awsSecretKeyId != null){
            skey = awsSecretKeyId;
        }
        return new AmazonCredentials(akey, skey);
    }
}
