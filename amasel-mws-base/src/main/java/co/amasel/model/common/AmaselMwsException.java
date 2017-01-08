package co.amasel.model.common;

import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import com.amazonservices.mws.client.MwsWriter;
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

    public static class XmlMwsException extends AmaselMwsObject {

        private String errorCode;
        private String errorType;
        private String message;
        private String detail;

        public String getErrorCode() {
            return errorCode;
        }

        public String getErrorType() {
            return errorType;
        }

        public String getMessage() {
            return message;
        }

        public String getDetail() {
            return detail;
        }

        @Override
        public void readFragmentFrom(MwsReader r) {
            this.errorType = r.read("Type", String.class);
            this.errorCode = r.read("Code", String.class);
            this.message = r.read("Message", String.class);
            this.detail = r.read("Detail", String.class);
        }

        @Override
        public void writeFragmentTo(MwsWriter w) {
            w.write("Code", this.errorCode);
            w.write("Type", this.errorType);
            w.write("Message", this.message);
            w.write("Detail", this.detail);
        }

        @Override
        public void writeTo(MwsWriter w) {
            w.write("Error", this);
        }

        public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
            return null;
        }

        @Override
        public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hdm) {
        }

    }


}
