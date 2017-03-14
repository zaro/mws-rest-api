package co.amasel.client.common;

import io.vertx.core.json.JsonObject;

/**
 * Created by zaro on 1/7/17.
 */
public class MwsPostDataTransformer {

    public MwsPostDataTransformer(){
    }

    public MwsPostDataTransformer init(JsonObject request, String encoding) { return this;}

    public boolean hasPostData() {
        return false;
    }

    public byte[] getPostData() {
        return null;
    }

    public String getPostDataAsString() {
        return null;
    }

    public String getContentType() {
        return null;
    }

}
