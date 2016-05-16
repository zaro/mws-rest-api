package co.amasel.codegen

import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlEnum
import javax.xml.bind.annotation.XmlType
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by zaro on 11/24/15.
 */
class Codegen {
    Codegen() {
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
    static void main(String[] args){
        def outDir = "/Users/zaro/dev/mws-rest-api/src/main/java/co/amasel/model"
        def dir = new File(outDir)
        dir.mkdirs()
        def packNames = [   MaWS:["com.amazonaws.mws.model","feeds_reports"],
                            MWSProducts:["com.amazonservices.mws.products.model","products" ],
                            MWSOrders: ["com.amazonservices.mws.orders._2013_09_01.model","orders" ]]
        for(url in  ClassEnumerator.getClassPath()){
            def fileName = url.getPath().split('/')[-1]
            for( pack in packNames) {
                if (fileName.startsWith(pack.key)) {
                    println(fileName)
                    def sourcePackageName = pack.value[0]
                    def modelName = pack.value[1]
                    def templateString = classTemplates.containsKey(modelName) ? classTemplates[modelName] : classTemplates["*"]
                    def template = new groovy.text.StreamingTemplateEngine().createTemplate(templateString)

                    for (cls in ClassEnumerator.processJarfile(url, sourcePackageName)) {
                        if(cls.isInterface() || cls.isEnum()){
                            continue
                        }
                        println(cls.getSimpleName())
                        if (["package-info","MWSResponse","FeedProcessingStatus", "ResponseMetadata","ResponseHeaderMetadata","ObjectFactory","ProductsUtil" ].contains(cls.getSimpleName()) || cls.getName().contains('$')){
                            continue
                        }
                        XmlType[] xmlTypes = cls.getAnnotationsByType(XmlType)
                        def props = []
                        if(xmlTypes.length){
                            def xmlElementTypeName = xmlTypes[0].name()
                            for(property in xmlTypes[0].propOrder()){
                                if (property.length() == 0)
                                    continue
                                def field = cls.getDeclaredField(property)
                                def elementName = property
                                def attirbute = false
                                Type parameterizedType = field.getGenericType();
                                String pType = null
                                String pTypeSimple = null
                                if (parameterizedType != null && parameterizedType instanceof ParameterizedType){
                                    pType = ((ParameterizedType)parameterizedType).getActualTypeArguments()[0].getTypeName()
                                    def l =  pType.split("\\.")
                                    pTypeSimple = l[l.length-1]
                                }

                                XmlElement[] elementAnnotations = field.getAnnotationsByType(XmlElement)
                                if(elementAnnotations.length){
                                    elementName = elementAnnotations[0].name()
                                }
                                XmlAttribute[] attributeAnnotations = field.getAnnotationsByType(XmlAttribute)
                                if(attributeAnnotations.length){
                                    attirbute = true
                                    if( attributeAnnotations[0].name())
                                        elementName = attributeAnnotations[0].name()
                                }
                                if(field.getType().getSimpleName().endsWith("Stream")){
                                    continue
                                }
                                props.push([
                                        type: field.getType().getSimpleName(),
                                        name: property,
                                        elementName: elementName,
                                        attribute: attirbute,
                                        enum: field.getDeclaringClass().isEnum(),
                                        pType: pType,
                                        pTypeSimple: pTypeSimple
                                ])
                            }
                        }
                        def binding =[
                                packageName: 'co.amasel.model.' + modelName,
                                sourcePackageName : sourcePackageName,
                                fullClassName: cls.getName(),
                                className: cls.getSimpleName(),
                                props: props
                        ]
                        def modelDir = new File(dir, modelName)
                        modelDir.mkdirs()
                        def outFile = new File(modelDir, cls.getSimpleName() + ".java")
                        FileOutputStream out = new FileOutputStream(outFile)
                        String t = template.make(binding)
                        out.write(t.bytes)
                        out.close()
                        //println template.make(binding)
                    }
                }
            }

        }

        //println ClassLoader.forName(pack + ".Error").getPackage().getMetaClass()

    }
}
