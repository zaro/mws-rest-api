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

public class ManageReportScheduleResult extends com.amazonaws.mws.model.ManageReportScheduleResult implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            count = reader.read("Count", int.class);
       
            reportSchedule = (List)reader.readList("ReportSchedule", ReportSchedule.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("Count", count);
       
            writer.writeList("ReportSchedule", reportSchedule);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "ManageReportScheduleResult",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
