package co.amasel.codegen

/**
 * Created by zaro on 5/20/16.
 */
class ModelTemplate {
    static String get(String modelName){
        return classTemplates.containsKey(modelName) ? classTemplates[modelName] : classTemplates["*"];
    }
    static def classTemplates=[
            "feeds_reports": '''\
package <%= packageName %>;

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

public class <%= className %> extends <%= fullClassName %> implements AmaselMwsObject {
    public void readFragmentFrom(MwsReader reader){
<%  props.each { p ->
        if( p.attribute ){ %>
            <%= p.name %> = reader.readAttribute("<%= p.elementName  %>", <%= p.type %>.class);
       <%} else if( p.enum ) {%>
            <%= p.name %> = <%= className %>.fromValue( reader.read("<%= p.elementName  %>", String.class) ) ;
       <%} else if( p.type == "List" ) {%>
            <%= p.name %> = (List)reader.readList("<%= p.elementName  %>", <%= p.pTypeSimple %>.class);
       <%} else if( p.elementName == "Merchant") {%>
            <%= p.name %> = reader.read("<%= p.elementName  %>", <%= p.type %>.class);
            if( <%= p.name %> == null) {
                // allow also SellerId, if Merchant is not set
                <%= p.name %> = reader.read("SellerId", <%= p.type %>.class);
            }

       <%} else {%>
            <%= p.name %> = reader.read("<%= p.elementName  %>", <%= p.type %>.class);
       <%}
} %>
    }

    public String toJSON(){ return "NOT IMPLEMENTED"; }

    public String toJSONFragment(){ return "NOT IMPLEMENTED"; }

    public String toXML(){ return "NOT IMPLEMENTED";}

    public String toXMLFragment(){ return "NOT IMPLEMENTED";}

    public void writeFragmentTo(MwsWriter writer){
<%  props.each { p ->
        if( p.attribute ){ %>
             writer.readAttribute("<%= p.elementName  %>", <%= p.name %>);
       <%} else if( p.enum ) {%>
            writer.write("<%= p.elementName  %>", <%= p.name %>.toString() ) ;
       <%} else if( p.type == "List" ) {%>
            writer.writeList("<%= p.elementName  %>", <%= p.name %>);
       <%} else {%>
            writer.write("<%= p.elementName  %>", <%= p.name %>);
       <%}
} %>
    }

    public void writeTo(MwsWriter w){
        w.write("XML_NS", "<%= className %>",this);
    }

    <% if ( className.endsWith("Response") ) { %>
    protected MwsResponseHeaderMetadata responseHeaderMetadata;
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return this.responseHeaderMetadata;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
        this.responseHeaderMetadata = hmd;
    }
    <% } else { %>
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    <% } %>
}
    ''',
            "*": '''\
package <%= packageName %>;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import co.amasel.model.common.AmaselMwsObject;
import <%= sourcePackageName %>.ResponseHeaderMetadata;


public class <%= className %> extends <%= fullClassName %> implements AmaselMwsObject {
    public <%= className %>() {
        super();
    }

    <% if ( className.endsWith("Response") ) { %>
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return getResponseHeaderMetadata();
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
        setResponseHeaderMetadata(new ResponseHeaderMetadata(hmd));
    }
    <% } else { %>
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    <% } %>
}
'''
    ]
}
