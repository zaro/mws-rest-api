package co.amasel;

import co.amasel.client.common.AmaselClientException;

/**
 * Created by zaro on 11/21/15.
 */
public class ApiRequestException extends AmaselClientException {
    public ApiRequestException(String message) {
        super(message);
    }
}
