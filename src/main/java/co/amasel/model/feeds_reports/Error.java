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

public class Error extends com.amazonaws.mws.model.Error implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){

            type = reader.read("Type", String.class);
       
            code = reader.read("Code", String.class);
       
            message = reader.read("Message", String.class);
       
            detail = reader.read("Detail", Detail.class);
       
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){

            writer.write("Type", type);
       
            writer.write("Code", code);
       
            writer.write("Message", message);
       
            writer.write("Detail", detail);
       
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "Error",this);
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
    
