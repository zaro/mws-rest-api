package co.amasel.misc;

//import com.amazonservices.mws.products.model.GetCompetitivePricingForSKURequest;
//import com.amazonservices.mws.products.model.SellerSKUListType;
//import io.vertx.core.json.JsonArray;
//import io.vertx.core.json.JsonObject;
////import jodd.bean.BeanUtil;
//
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.datatype.XMLGregorianCalendar;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.text.SimpleDateFormat;
//import java.util.*;

/**
 * Created by zaro on 11/23/15.
 */
public class BeanToPostParameters {
//    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//    static {
//        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//    }
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
//
//    public void beanParamList(Object bean) {
//        if (bean == null){
//            return;
//        }
//        Class beanClass = bean.getClass();
//        if (beanClass.isPrimitive() ||
//            beanClass == BigDecimal.class || beanClass == BigInteger.class ||
//            String.class.isAssignableFrom(beanClass) ||
//            XMLGregorianCalendar.class.isAssignableFrom(beanClass) ||
//            Boolean.class.isAssignableFrom(beanClass)
//            ){
//            parameters.put(getPrefix(), bean.toString());
//        }
//        if (Date.class.isAssignableFrom(beanClass)) {
//            parameters.put(getPrefix(), BeanToJsonObject.dateFormat.format(bean));
//        }
//        if (Calendar.class.isAssignableFrom(beanClass)){
//            parameters.put(getPrefix(), BeanToJsonObject.dateFormat.format(((Calendar)bean).getTime()));
//        }
//        if (List.class.isAssignableFrom(beanClass)){
//            JsonArray arr = new JsonArray();
//            int i=1;
//            for(Object o: ((List)bean) ) {
//                pushPrefix(String.valueOf(i));
//                beanParamList(o);
//                popPrefix();
//            }
//        }
//        if (Map.class.isAssignableFrom(beanClass)) {
//            JsonObject obj = new JsonObject();
//            for(Object e: ((Map)bean).entrySet() ){
//                Map.Entry entry = (Map.Entry)e;
//                pushPrefix( entry.getKey().toString() );
//                beanParamList(entry.getValue());
//                popPrefix();
//            }
//        }
//        for( Field field: bean.getClass().getDeclaredFields() ){
//            Class fieldClass = field.getType();
//            String name = getFieldName(bean, field);
//            String xmlFieldName = getXmlFieldName(field);
//
//            if(name == null){
//                continue;
//            }
//            pushPrefix(xmlFieldName);
//            beanParamList( BeanUtil.getProperty(bean, name));
//        }
//    }
//
//    Map<String, String> parameters = new TreeMap<>();
//    List<String> prefix = new ArrayList<>();
//
//    public void pushPrefix(String p){
//        prefix.add(p);
//    }
//    public void popPrefix(){
//        prefix.remove( prefix.size() - 1);
//    }
//
//    public String getPrefix(){
//        return String.join(".", prefix);
//    }
//
//    public Map<String, String> getParameters(){
//        return parameters;
//    }
//
//    public void addBean(Object bean)  {
//        beanParamList(bean);
//    }
//
//    public static void main(String[] args){
//        GetCompetitivePricingForSKURequest req = new GetCompetitivePricingForSKURequest();
//        req.setSellerId("SellerId");
//        req.setSellerSKUList(new SellerSKUListType(Arrays.asList("id1", "id2")));
//        BeanToPostParameters p = new BeanToPostParameters();
//
//        long startTime = System.currentTimeMillis();
//        p.addBean(req);
//
//        long stopTime = System.currentTimeMillis();
//        long elapsedTime = stopTime - startTime;
//        System.out.println(elapsedTime);
//    }
}

