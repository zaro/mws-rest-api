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

public class SubmitFeedRequest extends com.amazonaws.mws.model.SubmitFeedRequest implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            marketplace = reader.read("Marketplace", String.class);
       
            marketplaceIdList = reader.read("MarketplaceIdList", IdList.class);
       
            merchant = reader.read("Merchant", String.class);
            if( merchant == null) {
                // allow also SellerId, if Merchant is not set
                merchant = reader.read("SellerId", String.class);
            }

       
            contentMD5 = reader.read("ContentMD5", String.class);
       
            feedType = reader.read("FeedType", String.class);
       
            purgeAndReplace = reader.read("PurgeAndReplace", Boolean.class);
       
            mwsAuthToken = reader.read("MWSAuthToken", String.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("Marketplace", marketplace);
       
            writer.write("MarketplaceIdList", marketplaceIdList);
       
            writer.write("Merchant", merchant);
       
            writer.write("ContentMD5", contentMD5);
       
            writer.write("FeedType", feedType);
       
            writer.write("PurgeAndReplace", purgeAndReplace);
       
            writer.write("MWSAuthToken", mwsAuthToken);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "SubmitFeedRequest",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
