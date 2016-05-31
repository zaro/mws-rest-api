package co.amasel.model.feeds;

import co.amasel.model.common.AmaselMwsObject;

import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

import com.amazonaws.mws.model.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class GetFeedSubmissionCountResponse extends com.amazonaws.mws.model.GetFeedSubmissionCountResponse implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            getFeedSubmissionCountResult = reader.read("GetFeedSubmissionCountResult", GetFeedSubmissionCountResult.class);
       
            responseMetadata = reader.read("ResponseMetadata", ResponseMetadata.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("GetFeedSubmissionCountResult", getFeedSubmissionCountResult);
       
            writer.write("ResponseMetadata", responseMetadata);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "GetFeedSubmissionCountResponse",this);
    }

    
    protected MwsResponseHeaderMetadata responseHeaderMetadata;
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return this.responseHeaderMetadata;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
        this.responseHeaderMetadata = hmd;
    }
    
}
    