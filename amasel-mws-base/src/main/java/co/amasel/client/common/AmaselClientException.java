package co.amasel.client.common;

/**
 * Created by zaro on 5/27/16.
 */
public class AmaselClientException extends RuntimeException {
    public AmaselClientException(String message) {
        super(message);
    }

    public AmaselClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmaselClientException(Throwable cause) {
        super(cause);
    }

    public AmaselClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
