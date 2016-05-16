package co.amasel;

import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsWriter;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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

    public MwsJsonObjectWriter() {
        this.obj.push( new JsonObject() );
    }

    public JsonObject getJsonObject(){
        return this.obj.peek();
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
        } else {
            throw new IllegalArgumentException("Unsupported type "+value.getClass().getName());
        }
    }


    @Override
    public void beginObject(String s) {
        JsonObject o = new JsonObject();
        obj.peek().put(s, o);
        obj.push( o );
    }

    @Override
    public void close() {
    }

    @Override
    public void endObject(String s) {
        obj.pop();
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
        putValue("#$%any", collection);
    }

    @Override
    public void writeValue(Object o) {
        putValue("#$%value", o);
    }
}
