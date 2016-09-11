package co.amasel.model.common;

import co.amasel.MwsJsonObjectWriter;
import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import io.vertx.core.json.JsonObject;

/**
 * Created by zaro on 5/14/16.
 */
public interface AmaselMwsObject extends MwsObject{
    MwsResponseHeaderMetadata getMwsHeaderMetadata();
    void setMwsHeaderMetadata(MwsResponseHeaderMetadata hdm);

    default JsonObject toJsonObject(){
        MwsJsonObjectWriter out = new MwsJsonObjectWriter();
        writeFragmentTo(out);
        return  out.getJsonObject();
    }
}
