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

public class FeedSubmissionInfo extends com.amazonaws.mws.model.FeedSubmissionInfo implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            feedSubmissionId = reader.read("FeedSubmissionId", String.class);
       
            feedType = reader.read("FeedType", String.class);
       
            submittedDate = reader.read("SubmittedDate", String.class);
       
            feedProcessingStatus = reader.read("FeedProcessingStatus", String.class);
       
            startedProcessingDate = reader.read("StartedProcessingDate", XMLGregorianCalendar.class);
       
            completedProcessingDate = reader.read("CompletedProcessingDate", XMLGregorianCalendar.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("FeedSubmissionId", feedSubmissionId);
       
            writer.write("FeedType", feedType);
       
            writer.write("SubmittedDate", submittedDate);
       
            writer.write("FeedProcessingStatus", feedProcessingStatus);
       
            writer.write("StartedProcessingDate", startedProcessingDate);
       
            writer.write("CompletedProcessingDate", completedProcessingDate);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "FeedSubmissionInfo",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
