package co.amasel;

import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/**
 * Created by zaro on 5/13/16.
 */
public class MwsException extends com.amazonservices.mws.client.MwsException {

    public MwsException(int statusCode, String message, String errorCode, String errorType, String xml, MwsResponseHeaderMetadata rhmd) {
        super(statusCode, message, errorCode, errorType, xml, rhmd);
    }

    public MwsException(int statusCode, String message, Throwable cause) {
        super(statusCode, message, cause);
    }

    public MwsException(Throwable cause) {
        super(cause);
    }

    public static class XmlMwsException extends com.amazonservices.mws.client.MwsException.XmlMwsException {

    }
}
