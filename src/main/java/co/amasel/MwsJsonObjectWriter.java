package co.amasel;

import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsWriter;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

/**
 * Created by zaro on 11/22/15.
 */
public class MwsJsonObjectWriter implements MwsWriter {

    Stack<JsonObject> obj = new Stack<>();
    Stack<String> keys = new Stack<>();

    public MwsJsonObjectWriter() {
        this.obj.push( new JsonObject() );
    }

    public JsonObject getJsonObject(){
        return this.obj.peek();
    }

    class TextNode {
        boolean isTextNode;
        String text;
        public TextNode() {
            isTextNode = false;
        }

        public TextNode(boolean isTextNode, String text) {
            this.isTextNode = isTextNode;
            this.text = text;
        }
    }

    TextNode getNodeText(Node node){
        if( node.hasChildNodes() ){
            NodeList children = node.getChildNodes();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < children.getLength(); ++i) {
                if( children.item(i).getNodeType() != Node.TEXT_NODE ){
                    return new TextNode();
                }
                sb.append(children.item(i).getNodeValue());
            }
            return new TextNode(true, sb.toString());
        }
        return new TextNode();
    }


    JsonObject domNodeToJsonObject(Node node) {
        JsonObject newObj = new JsonObject();
        NamedNodeMap attributes = node.getAttributes();
        if(attributes  != null) {
            for (int i = 0; i < attributes.getLength(); ++i) {
                Node attr = attributes.item(i);
                putDomNode(newObj, "~" + attr.getLocalName(), attr);
            }
        }
        NodeList children = node.getChildNodes();
        if(children!= null) {
            for (int i = 0; i < children.getLength(); ++i) {
                Node child = children.item(i);
                putDomNode(newObj, child.getLocalName(), child);
            }
        }
        return newObj;
    }

    void putDomNode(JsonObject o,String key,Node node){
        if( !node.hasChildNodes() && !node.hasAttributes()) {
            o.put(key, node.getNodeValue());
            return ;
        }
        TextNode tn = getNodeText(node);
        if(tn.isTextNode) {
            o.put(key, tn.text);
            return;
        }
        JsonObject newObj = domNodeToJsonObject(node);
        if(newObj.size() > 0 ){
            o.put(key, newObj);
        }
    }

    void addDomNode(JsonArray o,Node node){
        if( !node.hasChildNodes() && !node.hasAttributes()) {
            o.add( node.getNodeValue() );
            return ;
        }
        TextNode tn = getNodeText(node);
        if(tn.isTextNode) {
            o.add(tn.text);
            return;
        }
        JsonObject newObj = domNodeToJsonObject(node);
        if(newObj.size() > 0 ){
            o.add(newObj);
        }
    }


    void addValue(JsonArray o, Object value) {
        if (value == null) {
            o.addNull();
        } else if (value instanceof MwsObject) {
            MwsJsonObjectWriter or =  new MwsJsonObjectWriter();
            ((MwsObject) value).writeFragmentTo(or);
            o.add( or.getJsonObject() );
        } else if (value instanceof List) {
            JsonArray a = new JsonArray();
            for(Object v: (List)value){
                addValue(a, v);
            }
            o.add(a);
        } else if (value instanceof Boolean) {
            o.add((Boolean)value );
        } else if (value instanceof Number) {
            o.add( value );
        } else if (value instanceof String) {
            o.add((String)value );
        } else if (value instanceof XMLGregorianCalendar) {
            o.add( ((XMLGregorianCalendar) value).toXMLFormat());
        } else if (value instanceof Enum) {
            o.add( value.toString());
        } else if (value instanceof Node) {
            addDomNode(o, (Node) value);
        } else {
            throw new IllegalArgumentException("Unsupported type "+value.getClass().getName());
        }
    }

    void putValue(String key, Object value) {
        JsonObject o = obj.peek();
        if (value == null) {
            o.putNull( key );
        } else if (value instanceof MwsObject) {
            beginObject( key );
            ((MwsObject) value).writeFragmentTo(this);
            endObject( key );
        } else if (value instanceof List) {
            JsonArray a = new JsonArray();
            for(Object v: (List)value){
                addValue(a, v);
            }
            o.put(key, a);
        } else if (value instanceof Boolean) {
            o.put(key, (Boolean)value );
        } else if (value instanceof BigDecimal) {
            o.put(key, value.toString() );
        } else if (value instanceof Number) {
            o.put(key, value );
        } else if (value instanceof String) {
            o.put(key, (String)value );
        } else if (value instanceof XMLGregorianCalendar) {
           o.put(key, ((XMLGregorianCalendar) value).toXMLFormat());
        } else if (value instanceof Enum) {
            o.put(key, value.toString());
        } else if (value instanceof Node) {
            putDomNode(o, key, (Node) value);
        } else {
            throw new IllegalArgumentException("Unsupported type "+value.getClass().getName());
        }
    }


    @Override
    public void beginObject(String s) {
        JsonObject o = new JsonObject();
        obj.peek().put(s, o);
        obj.push( o );
        keys.push(s);
    }

    @Override
    public void close() {
    }

    @Override
    public void endObject(String s) {
        obj.pop();
        keys.pop();
    }


    @Override
    public void write(String namespace, String name, MwsObject mwsObject) {
        putValue(name , mwsObject);
    }

    @Override
    public void write(String name, Object o) {
        putValue(name , o);
    }

    @Override
    public void writeAttribute(String name, Object o) {
        putValue("~" + name , o);
    }

    @Override
    public void writeList(String name, Collection<?> collection) {
        putValue(name , collection);
    }

    @Override
    public void writeList(String name, String s1, Collection<?> collection) {
        putValue(name , collection);
    }

    @Override
    public void writeAny(Collection<Element> collection) {

        putValue("#$%$any", collection);
        JsonObject o = obj.pop();
        String key = keys.pop();
        Object replacement =o.getValue("#$%$any");
        if(replacement instanceof JsonObject){
            obj.peek().put(key, (JsonObject)replacement);
        } else if (replacement instanceof JsonArray){
            obj.peek().put(key, (JsonArray) replacement);
        } else {
            obj.peek().put(key, replacement);
        }
        obj.push(new JsonObject());
        keys.push("");
    }

    @Override
    public void writeValue(Object v) {
        putValue("#$%$value", v);
        JsonObject o = obj.pop();
        String key = keys.pop();
        Object replacement =o.getValue("#$%$value");
        if(replacement instanceof JsonObject){
            obj.peek().put(key, (JsonObject)replacement);
        } else if (replacement instanceof JsonArray){
            obj.peek().put(key, (JsonArray) replacement);
        } else {
            obj.peek().put(key, replacement);
        }
        obj.push(new JsonObject());
        keys.push("");
    }
}
