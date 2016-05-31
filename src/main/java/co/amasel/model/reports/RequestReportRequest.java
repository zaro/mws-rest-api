package co.amasel.model.reports;

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

public class RequestReportRequest extends com.amazonaws.mws.model.RequestReportRequest implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            marketplace = reader.read("Marketplace", String.class);
       
            marketplaceIdList = reader.read("MarketplaceIdList", IdList.class);
       
            merchant = reader.read("Merchant", String.class);
            if( merchant == null) {
                // allow also SellerId, if Merchant is not set
                merchant = reader.read("SellerId", String.class);
            }

       
            reportType = reader.read("ReportType", String.class);
       
            startDate = reader.read("StartDate", XMLGregorianCalendar.class);
       
            endDate = reader.read("EndDate", XMLGregorianCalendar.class);
       
            reportOptions = reader.read("ReportOptions", String.class);
       
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
       
            writer.write("ReportType", reportType);
       
            writer.write("StartDate", startDate);
       
            writer.write("EndDate", endDate);
       
            writer.write("ReportOptions", reportOptions);
       
            writer.write("MWSAuthToken", mwsAuthToken);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "RequestReportRequest",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
