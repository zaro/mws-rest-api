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

public class ReportSchedule extends com.amazonaws.mws.model.ReportSchedule implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            reportType = reader.read("ReportType", String.class);
       
            schedule = reader.read("Schedule", String.class);
       
            scheduledDate = reader.read("ScheduledDate", XMLGregorianCalendar.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("ReportType", reportType);
       
            writer.write("Schedule", schedule);
       
            writer.write("ScheduledDate", scheduledDate);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "ReportSchedule",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
