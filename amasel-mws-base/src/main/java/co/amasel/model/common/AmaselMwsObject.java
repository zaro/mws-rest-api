package co.amasel.model.common;

import co.amasel.model.common.MwsJsonObjectWriter;
import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import com.amazonservices.mws.client.MwsWriter;
import io.vertx.core.json.JsonObject;

/**
 * Created by zaro on 5/14/16.
 */
public abstract class AmaselMwsObject implements MwsObject{
    abstract public MwsResponseHeaderMetadata getMwsHeaderMetadata();
    abstract public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hdm);

    JsonObject toJsonObject(){
        MwsJsonObjectWriter out = new MwsJsonObjectWriter();
        writeFragmentTo(out);
        return  out.getJsonObject();
    }

    abstract public void readFragmentFrom(MwsReader mwsReader);

    abstract public void writeFragmentTo(MwsWriter mwsWriter);


    // The rest of the methods are not really used
    @Override
    public String toJSON() {
        return null;
    }

    @Override
    public String toJSONFragment() {
        return null;
    }

    @Override
    public String toXML() {
        return null;
    }

    @Override
    public String toXMLFragment() {
        return null;
    }


    @Override
    public void writeTo(MwsWriter mwsWriter) {

    }
}
