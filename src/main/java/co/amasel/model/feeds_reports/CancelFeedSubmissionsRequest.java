package co.amasel.model.feeds_reports;

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

public class CancelFeedSubmissionsRequest extends com.amazonaws.mws.model.CancelFeedSubmissionsRequest implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            marketplace = reader.read("Marketplace", String.class);
       
            merchant = reader.read("Merchant", String.class);
       
            feedSubmissionIdList = reader.read("FeedSubmissionIdList", IdList.class);
       
            feedTypeList = reader.read("FeedTypeList", TypeList.class);
       
            submittedFromDate = reader.read("SubmittedFromDate", XMLGregorianCalendar.class);
       
            submittedToDate = reader.read("SubmittedToDate", XMLGregorianCalendar.class);
       
            mwsAuthToken = reader.read("MWSAuthToken", String.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("Marketplace", marketplace);
       
            writer.write("Merchant", merchant);
       
            writer.write("FeedSubmissionIdList", feedSubmissionIdList);
       
            writer.write("FeedTypeList", feedTypeList);
       
            writer.write("SubmittedFromDate", submittedFromDate);
       
            writer.write("SubmittedToDate", submittedToDate);
       
            writer.write("MWSAuthToken", mwsAuthToken);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "CancelFeedSubmissionsRequest",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
