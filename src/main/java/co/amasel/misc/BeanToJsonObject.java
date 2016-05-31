package co.amasel.misc;

import co.amasel.misc.BeanAccess;
import com.amazonservices.mws.products.model.GetCompetitivePricingForSKURequest;
import com.amazonservices.mws.products.model.SellerSKUListType;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zaro on 11/23/15.
 */
public class BeanToJsonObject {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    static {
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    protected static String getXmlFieldName(Field field){
        Annotation[] annotations = field.getAnnotationsByType(XmlElement.class);
        if( annotations.length > 0) {
            XmlElement element = (XmlElement) annotations[annotations.length - 1];
            return element.name();
        }
        return null;
    }

    public static String getFieldName(Object bean, Field field) {
        if (BeanAccess.hasProperty(bean, field.getName())) {
            return field.getName();
        }
        return null;
    }


    public static Object beanToObject(Object bean) {
        return beanToObject(bean, false);
    }
    public static Object beanToObject(Object bean, boolean hintList) {
        if (bean == null){
            return null;
        }
        Class beanClass = bean.getClass();
        if (beanClass.isPrimitive()) {
            return bean;
        }
        if (beanClass == BigDecimal.class || beanClass == BigInteger.class) {
            return bean.toString();
        }
        if (String.class.isAssignableFrom(beanClass)) {
            return bean;
        }
        if (Boolean.class.isAssignableFrom(beanClass)) {
            return bean;
        }
        if (Date.class.isAssignableFrom(beanClass)) {
            return dateFormat.format(bean);
        }
        if (XMLGregorianCalendar.class.isAssignableFrom(beanClass)){
            return dateFormat.format(((XMLGregorianCalendar)bean).toGregorianCalendar().getTime());
        }
        if (Calendar.class.isAssignableFrom(beanClass)){
            return dateFormat.format(((Calendar)bean).getTime());
        }
        if (List.class.isAssignableFrom(beanClass)){
            JsonArray arr = new JsonArray();
            for(Object o: ((List)bean) ) {
                arr.add(beanToObject(o));
            }
            return arr;
        }
        if (Map.class.isAssignableFrom(beanClass)) {
            JsonObject obj = new JsonObject();
            for(Object e: ((Map)bean).entrySet() ){
                Map.Entry entry = (Map.Entry)e;
                obj.put( entry.getKey().toString(), beanToObject(entry.getValue()) );
            }
            return obj;
        }
        // bean conversion
        JsonObject obj = new JsonObject();
        for( Field field: bean.getClass().getDeclaredFields() ){
            Class fieldClass = field.getType();
            String name = getFieldName(bean, field);
            String xmlFieldName = getXmlFieldName(field);

            if(name == null){
                continue;
            }
            Object value = null;
            value = beanToObject( BeanAccess.getProperty(bean, name), xmlFieldName.endsWith("List"));
            obj.put(xmlFieldName, value);
        }
        if( obj.size() == 1 && hintList){
            Map.Entry<String,Object> it = obj.iterator().next();
            return it.getValue();
        }
        return obj;
    }
    public static JsonObject fromBean(Object bean)  {
        Object result = beanToObject(bean);
        if(JsonObject.class.isAssignableFrom(result.getClass())){
            return (JsonObject) result;
        }
        JsonObject obj = new JsonObject();
        obj.put("beanAsJson", result);
        return obj;
    }

    public static void main(String[] args){
        GetCompetitivePricingForSKURequest req = new GetCompetitivePricingForSKURequest();
        req.setSellerId("SellerId");
        req.setSellerSKUList(new SellerSKUListType(Arrays.asList("id1", "id2")));
        System.out.print(fromBean(req).encodePrettily());
    }
}

