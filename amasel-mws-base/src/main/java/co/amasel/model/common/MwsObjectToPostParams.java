package co.amasel.model.common;

import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsWriter;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.w3c.dom.Element;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zaro on 11/23/15.
 */
public class MwsObjectToPostParams implements MwsWriter {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    static {
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }


    public void beanParamList(String name, Object bean) {
        if (bean == null){
            return;
        }
        pushPrefix(name);
        Class beanClass = bean.getClass();
        if(MwsObject.class.isAssignableFrom(beanClass)){
            ((MwsObject)bean).writeFragmentTo(this);
        } else if (Date.class.isAssignableFrom(beanClass)) {
            parameters.put(getPrefix(), dateFormat.format(bean));
        } else if (Calendar.class.isAssignableFrom(beanClass)){
            parameters.put(getPrefix(), dateFormat.format(((Calendar)bean).getTime()));
        } else if (List.class.isAssignableFrom(beanClass)){
            JsonArray arr = new JsonArray();
            int i=1;
            for(Object o: ((List)bean) ) {
                beanParamList(String.valueOf(i++), o);
            }
        } else if (Map.class.isAssignableFrom(beanClass)) {
            JsonObject obj = new JsonObject();
            for(Object e: ((Map)bean).entrySet() ){
                Map.Entry entry = (Map.Entry)e;
                beanParamList(entry.getKey().toString(), entry.getValue());
            }
        } else {
            parameters.put(getPrefix(), bean.toString());
        }
        popPrefix();
    }

    Map<String, String> parameters = new TreeMap<>();
    List<String> prefix = new ArrayList<>();

    public void pushPrefix(String p){
        prefix.add(p);
    }
    public void popPrefix(){
        prefix.remove( prefix.size() - 1);
    }

    public String getPrefix(){
        return String.join(".", prefix);
    }

    public Map<String, String> getParameters(){
        return parameters;
    }



    @Override
    public void beginObject(String s) {
        pushPrefix(s);
    }

    @Override
    public void close() {

    }

    @Override
    public void endObject(String s) {
        popPrefix();
    }

    @Override
    public void write(String xmlNamespace, String name, MwsObject mwsObject) {
        pushPrefix(name);
        mwsObject.writeFragmentTo(this);
        popPrefix();
    }

    @Override
    public void write(String name, Object o) {
        beanParamList(name, o);
    }

    @Override
    public void writeAttribute(String s, Object o) {

    }

    @Override
    public void writeList(String name, Collection<?> collection) {
        beanParamList(name, collection);
    }

    @Override
    public void writeList(String name, String memberName, Collection<?> collection) {
        pushPrefix(name);
        beanParamList(memberName, collection);
        popPrefix();
    }

    @Override
    public void writeAny(Collection<Element> collection) {

    }

    @Override
    public void writeValue(Object o) {

    }

}

