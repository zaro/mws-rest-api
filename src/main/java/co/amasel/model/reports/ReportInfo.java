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

public class ReportInfo extends com.amazonaws.mws.model.ReportInfo implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            reportId = reader.read("ReportId", String.class);
       
            reportType = reader.read("ReportType", String.class);
       
            reportRequestId = reader.read("ReportRequestId", String.class);
       
            availableDate = reader.read("AvailableDate", XMLGregorianCalendar.class);
       
            acknowledged = reader.read("Acknowledged", boolean.class);
       
            acknowledgedDate = reader.read("AcknowledgedDate", XMLGregorianCalendar.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("ReportId", reportId);
       
            writer.write("ReportType", reportType);
       
            writer.write("ReportRequestId", reportRequestId);
       
            writer.write("AvailableDate", availableDate);
       
            writer.write("Acknowledged", acknowledged);
       
            writer.write("AcknowledgedDate", acknowledgedDate);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "ReportInfo",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
