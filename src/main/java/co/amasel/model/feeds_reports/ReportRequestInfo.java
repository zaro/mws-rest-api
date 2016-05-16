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

public class ReportRequestInfo extends com.amazonaws.mws.model.ReportRequestInfo implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            reportRequestId = reader.read("ReportRequestId", String.class);
       
            reportType = reader.read("ReportType", String.class);
       
            startDate = reader.read("StartDate", XMLGregorianCalendar.class);
       
            endDate = reader.read("EndDate", XMLGregorianCalendar.class);
       
            scheduled = reader.read("Scheduled", boolean.class);
       
            submittedDate = reader.read("SubmittedDate", XMLGregorianCalendar.class);
       
            reportProcessingStatus = reader.read("ReportProcessingStatus", String.class);
       
            generatedReportId = reader.read("GeneratedReportId", String.class);
       
            startedProcessingDate = reader.read("StartedProcessingDate", XMLGregorianCalendar.class);
       
            completedDate = reader.read("CompletedDate", XMLGregorianCalendar.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("ReportRequestId", reportRequestId);
       
            writer.write("ReportType", reportType);
       
            writer.write("StartDate", startDate);
       
            writer.write("EndDate", endDate);
       
            writer.write("Scheduled", scheduled);
       
            writer.write("SubmittedDate", submittedDate);
       
            writer.write("ReportProcessingStatus", reportProcessingStatus);
       
            writer.write("GeneratedReportId", generatedReportId);
       
            writer.write("StartedProcessingDate", startedProcessingDate);
       
            writer.write("CompletedDate", completedDate);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "ReportRequestInfo",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
