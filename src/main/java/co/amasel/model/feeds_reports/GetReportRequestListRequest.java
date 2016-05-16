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

public class GetReportRequestListRequest extends com.amazonaws.mws.model.GetReportRequestListRequest implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            marketplace = reader.read("Marketplace", String.class);
       
            merchant = reader.read("Merchant", String.class);
       
            reportRequestIdList = reader.read("ReportRequestIdList", IdList.class);
       
            reportTypeList = reader.read("ReportTypeList", TypeList.class);
       
            reportProcessingStatusList = reader.read("ReportProcessingStatusList", StatusList.class);
       
            maxCount = reader.read("MaxCount", Integer.class);
       
            requestedFromDate = reader.read("RequestedFromDate", XMLGregorianCalendar.class);
       
            requestedToDate = reader.read("RequestedToDate", XMLGregorianCalendar.class);
       
            mwsAuthToken = reader.read("MWSAuthToken", String.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("Marketplace", marketplace);
       
            writer.write("Merchant", merchant);
       
            writer.write("ReportRequestIdList", reportRequestIdList);
       
            writer.write("ReportTypeList", reportTypeList);
       
            writer.write("ReportProcessingStatusList", reportProcessingStatusList);
       
            writer.write("MaxCount", maxCount);
       
            writer.write("RequestedFromDate", requestedFromDate);
       
            writer.write("RequestedToDate", requestedToDate);
       
            writer.write("MWSAuthToken", mwsAuthToken);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "GetReportRequestListRequest",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
