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

public class GetReportListResult extends com.amazonaws.mws.model.GetReportListResult implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            nextToken = reader.read("NextToken", String.class);
       
            hasNext = reader.read("HasNext", boolean.class);
       
            reportInfo = (List)reader.readList("ReportInfo", ReportInfo.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("NextToken", nextToken);
       
            writer.write("HasNext", hasNext);
       
            writer.writeList("ReportInfo", reportInfo);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "GetReportListResult",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
