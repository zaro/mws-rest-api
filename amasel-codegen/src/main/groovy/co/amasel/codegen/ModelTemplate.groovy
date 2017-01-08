package co.amasel.codegen

/**
 * Created by zaro on 5/20/16.
 */
class ModelTemplate {
    static get(String modelName){
        return methodTemplates.containsKey(modelName) ? methodTemplates[modelName] : methodTemplates["*"];
    }
    static def methodTemplates=[
            'feeds_reports': [
                    'readFragmentFrom': [
                            'args':     ['MwsReader'],
                            'argsName': ['reader'],
                            'returns': 'void',
                            'template': '''
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
''' ],
                    'writeFragmentTo': [
                            'args':     ['MwsWriter'],
                            'argsName': ['writer'],
                            'returns': 'void',
                            'template': '''
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
'''],
                     'getMwsHeaderMetadata': [
                             'args':     [],
                             'argsName': [],
                             'returns': 'MwsResponseHeaderMetadata',
                             'template': '''
    <% if ( className.endsWith("Response") ) { %>
        return this.mwsResponseHeaderMetadata;
    <% } else { %>
        return null;
    }
    <% } %>

'''],
                      'setMwsHeaderMetadata': [
                                     'args':     ['MwsResponseHeaderMetadata'],
                                     'argsName': ['hmd'],
                                     'returns': 'void',
                                     'template': '''
    <% if ( className.endsWith("Response") ) { %>
        this.mwsResponseHeaderMetadata = hmd;
    <% } else { %>
    <% } %>
'''],
                    'toXMLFragment' :[
                            'makePublic' : true,
                            'args':     [],
                    ],
                    'toJSONFragment' :[
                            'makePublic' : true,
                            'args':     [],
                    ],
                    'mwsResponseHeaderMetadata' : [
                            field : true,
                            'template': 'protected MwsResponseHeaderMetadata mwsResponseHeaderMetadata',

                    ]
            ],
            '*': [
                    'readFragmentFrom': null ,
                    'writeFragmentTo': null ,
                    'getMwsHeaderMetadata': [
                            'args':     [],
                            'argsName': [],
                            'returns': 'MwsResponseHeaderMetadata',
                            'template': '''
    <% if ( className.endsWith("Response") ) { %>
        return getResponseHeaderMetadata();
    <% } else { %>
        return null;
    }
    <% } %>

'''],
                    'setMwsHeaderMetadata': [
                            'args':     ['MwsResponseHeaderMetadata'],
                            'argsName': ['hmd'],
                            'returns': 'void',
                            'template': '''
    <% if ( className.endsWith("Response") ) { %>
        setResponseHeaderMetadata(new ResponseHeaderMetadata(hmd));
    <% } else { %>
    <% } %>
''']
            ]
    ]

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
