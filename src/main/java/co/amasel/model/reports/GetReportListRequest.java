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

public class GetReportListRequest extends com.amazonaws.mws.model.GetReportListRequest implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            marketplace = reader.read("Marketplace", String.class);
       
            merchant = reader.read("Merchant", String.class);
            if( merchant == null) {
                // allow also SellerId, if Merchant is not set
                merchant = reader.read("SellerId", String.class);
            }

       
            maxCount = reader.read("MaxCount", Integer.class);
       
            reportTypeList = reader.read("ReportTypeList", TypeList.class);
       
            acknowledged = reader.read("Acknowledged", Boolean.class);
       
            availableFromDate = reader.read("AvailableFromDate", XMLGregorianCalendar.class);
       
            availableToDate = reader.read("AvailableToDate", XMLGregorianCalendar.class);
       
            reportRequestIdList = reader.read("ReportRequestIdList", IdList.class);
       
            mwsAuthToken = reader.read("MWSAuthToken", String.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("Marketplace", marketplace);
       
            writer.write("Merchant", merchant);
       
            writer.write("MaxCount", maxCount);
       
            writer.write("ReportTypeList", reportTypeList);
       
            writer.write("Acknowledged", acknowledged);
       
            writer.write("AvailableFromDate", availableFromDate);
       
            writer.write("AvailableToDate", availableToDate);
       
            writer.write("ReportRequestIdList", reportRequestIdList);
       
            writer.write("MWSAuthToken", mwsAuthToken);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "GetReportListRequest",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
