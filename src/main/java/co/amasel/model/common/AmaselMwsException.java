package co.amasel.model.common;

import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import io.vertx.core.json.JsonObject;

/**
 * Created by zaro on 5/13/16.
 */
public class AmaselMwsException extends com.amazonservices.mws.client.MwsException {

    public AmaselMwsException(int statusCode, String message, String errorCode, String errorType, String xml, MwsResponseHeaderMetadata rhmd) {
        super(statusCode, message, errorCode, errorType, xml, rhmd);
    }

    public AmaselMwsException(int statusCode, String message, Throwable cause) {
        super(statusCode, message, cause);
    }

    public AmaselMwsException(Throwable cause) {
        super(cause);
    }

    public static class XmlMwsException extends com.amazonservices.mws.client.MwsException.XmlMwsException implements AmaselMwsObject{

        @Override
        public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
            return null;
        }

        @Override
        public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hdm) {
        }
    }
}
