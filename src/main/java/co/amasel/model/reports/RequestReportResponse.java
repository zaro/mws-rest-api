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

public class RequestReportResponse extends com.amazonaws.mws.model.RequestReportResponse implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            requestReportResult = reader.read("RequestReportResult", RequestReportResult.class);
       
            responseMetadata = reader.read("ResponseMetadata", ResponseMetadata.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("RequestReportResult", requestReportResult);
       
            writer.write("ResponseMetadata", responseMetadata);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "RequestReportResponse",this);
    }

    
    protected MwsResponseHeaderMetadata responseHeaderMetadata;
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return this.responseHeaderMetadata;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
        this.responseHeaderMetadata = hmd;
    }
    
}
    
