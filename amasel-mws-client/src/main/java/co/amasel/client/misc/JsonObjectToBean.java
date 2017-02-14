package co.amasel.client.misc;

//import co.amasel.JsonParseException;
//import co.amasel.misc.BeanToJsonObject;
//import io.vertx.core.json.JsonArray;
//import io.vertx.core.json.JsonObject;
////import jodd.bean.BeanUtil;
//
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.datatype.DatatypeConfigurationException;
//import javax.xml.datatype.DatatypeFactory;
//import javax.xml.datatype.XMLGregorianCalendar;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.text.ParsePosition;
//import java.util.*;

/**
 * Created by zaro on 11/23/15.
 */
public class JsonObjectToBean {
//
//    protected static String getXmlFieldName(Field field){
//        Annotation[] annotations = field.getAnnotationsByType(XmlElement.class);
//        if( annotations.length > 0) {
//            XmlElement element = (XmlElement) annotations[annotations.length - 1];
//            return element.name();
//        }
//        return null;
//    }
//
//    public static String getFieldName(Object bean, Field field) {
//        if (BeanUtil.hasProperty(bean, field.getName())) {
//            return field.getName();
//        }
//        return null;
//    }
//
//    public static Object objectToBean(Object obj, Class beanClass, Type pType) throws JsonParseException {
//        if(obj == null){
//            return obj;
//        }
//        Class objClass = obj.getClass();
//        if (beanClass.isAssignableFrom(objClass)) {
//            return obj;
//        }
//        if (String.class.isAssignableFrom(objClass)) {
//            if( beanClass.isAssignableFrom(String.class)){
//                return obj;
//            }
//            if (beanClass == BigDecimal.class){
//                return new BigDecimal((String)obj);
//            }
//            if(beanClass == BigInteger.class){
//                return new BigInteger((String)obj);
//            }
//            if (Date.class.isAssignableFrom(beanClass)) {
//                Date date =  BeanToJsonObject.dateFormat.parse((String)obj,new ParsePosition(0));
//                if(date != null) {
//                    return date;
//                }
//                throw  new JsonParseException("Invalid value for 'Date' :" +(String)obj);
//            }
//            if (XMLGregorianCalendar.class.isAssignableFrom(beanClass)){
//                Date date =  BeanToJsonObject.dateFormat.parse((String)obj,new ParsePosition(0));
//                if(date != null) {
//                    GregorianCalendar c = new GregorianCalendar();
//                    c.setTime(date);
//                    try {
//                        return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
//                    } catch (DatatypeConfigurationException e) {
//                        throw  new JsonParseException("Failed to createa 'XMLGregorianCalendar'");
//                    }
//                }
//                throw  new JsonParseException("Invalid value for 'Date' :" +(String)obj);
//            }
//            if (Calendar.class.isAssignableFrom(beanClass)){
//                Date date =  BeanToJsonObject.dateFormat.parse((String)obj,new ParsePosition(0));
//                if(date != null) {
//                    GregorianCalendar c = new GregorianCalendar();
//                    c.setTime(date);
//                    return c;
//                }
//                throw  new JsonParseException("Invalid value for 'Date' :" +(String)obj);
//            }
//        }
//        if (List.class.isAssignableFrom(beanClass)){
//            if( objClass != JsonArray.class ){
//                throw  new JsonParseException("Expected array but found :" +objClass.getName());
//            }
//            JsonArray arr = (JsonArray)obj;
//            List list = new ArrayList<>();
//            if(pType != null){
//                Class<?> listObjectClass = (Class<?>) ((ParameterizedType)pType).getActualTypeArguments()[0];
//                for (Object o : arr) {
//                    list.add(objectToBean(o, listObjectClass, null));
//                }
//            } else {
//                for (Object o : arr) {
//                    list.add(o);
//                }
//            }
//            return list;
//        }
//        // Below we handle Map and Bean , both require JsonObject
//        if( objClass != JsonObject.class ){
//            throw  new JsonParseException("Expected object["+beanClass.getName()+"] but found :[" +objClass.getName() +"] "+ obj.toString());
//        }
//        JsonObject object = (JsonObject)obj;
//        if (Map.class.isAssignableFrom(beanClass)) {
//            Map<String, Object> map = new HashMap<>();
//            if(pType != null) {
//                Class<?> mapObjectClass = (Class<?>) ((ParameterizedType)pType).getActualTypeArguments()[0];
//                for (Map.Entry<String, Object> e : object) {
//                    map.put(e.getKey().toString(), objectToBean(e.getValue(), mapObjectClass, null));
//                }
//            } else {
//                for (Map.Entry<String, Object> e : object) {
//                    map.put(e.getKey().toString(), e.getValue());
//                }
//            }
//            return obj;
//        }
//        // bean conversion
//        Object bean = null;
//        try {
//            bean = beanClass.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//            throw  new JsonParseException("Cannot instantiate :" +beanClass.getName());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//            throw  new JsonParseException("Cannot instantiate :" +beanClass.getName());
//        }
//
//        for( Field field: beanClass.getDeclaredFields() ){
//            Class fieldClass = field.getType();
//            Type parameterizedType = field.getGenericType();
//            String name = getFieldName(bean, field);
//            String xmlFieldName = getXmlFieldName(field);
//
//            if(name == null){
//                if( xmlFieldName == null){
//                    continue;
//                }
//                name = xmlFieldName;
//            }
//
//            Object jsonValue = object.getValue(xmlFieldName);
//            if (xmlFieldName.endsWith("List")){
//                Field[] fields = fieldClass.getDeclaredFields();
//                if (fields.length==1){
//                    String addXmlFieldName = getXmlFieldName(fields[0]);
//                    JsonObject o = new JsonObject();
//                    o.put(addXmlFieldName, jsonValue);
//                    jsonValue = o;
//                }
//            }
//
//            Object value = objectToBean(jsonValue, fieldClass, parameterizedType );
//            if(BeanUtil.hasProperty(bean, name)) {
//                BeanUtil.setProperty(bean, name, value);
//            } else if(BeanUtil.hasProperty(bean, xmlFieldName)){
//                BeanUtil.setProperty(bean, xmlFieldName, value);
//            }
//        }
//        return bean;
//
//    }
//
//    public static <T> T toBean(JsonObject json, Class<T> beanClass) throws JsonParseException {
//        return (T) objectToBean(json, beanClass, null);
//    }

}
