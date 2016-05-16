package co.amasel;

import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsUtl;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.w3c.dom.Element;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class MwsJsonObjectReader implements MwsReader {

        private Object currentElement;


        /**
         * Read an element into a new instance of a class.
         *
         * @param element
         *            The element, if null returns null.
         *
         * @param cls
         *            The class to create an instance of.
         *
         * @return The new instance.
         */
        @SuppressWarnings("unchecked")
        private <T> T parseElement(Object element, Class<T> cls) {
            T value = (T)element;
            if (element == null) {
                value = null;
            } else if (MwsObject.class.isAssignableFrom(cls)) {
                try {
                    value = cls.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("Failed to create: " + cls.getName());
                }
                Object holdElement = currentElement;
                setCurrentElement( element );
                ((MwsObject) value).readFragmentFrom(this);
                currentElement = holdElement;
            } else if (cls == Object.class) {
                value = (T)element;
            } else if (cls == String.class) {
                value = (T)element.toString();
            } else  if( cls == Boolean.class || cls == boolean.class ){
                value = (T)element;
            } else if (cls == Integer.class || cls == int.class) {
                value = (T)element;
            } else if (cls == Long.class || cls == long.class) {
                value = (T)element;
            } else if (cls == Float.class || cls == float.class) {
                value = (T)element;
            } else if (cls == Double.class || cls == double.class) {
                value = (T)element;
            } else if (cls == BigDecimal.class) {
                value = (T)new BigDecimal( element.toString() );
            } else if (cls == ArrayList.class && element instanceof JsonArray) {
                List<T> list = new ArrayList<>();
                Iterator<Object> iter = ((JsonArray)element).iterator();
                while( iter.hasNext() ){
                    list.add( (T)parseElement( iter.next(), cls) );
                }
                value = (T)list;
            } else if (XMLGregorianCalendar.class == cls) {
                value = (T)MwsUtl.getDTF().newXMLGregorianCalendar(element.toString());
            } else if (Enum.class.isAssignableFrom(cls)) {
                value = getEnumValue(cls, element.toString());
            }
            return value;
        }

        private static final ConcurrentHashMap<Object, HashMap<String, Object>> enumMaps =
                new ConcurrentHashMap<Object, HashMap<String, Object>>();
        static <T> T getEnumValue(Class<T> cls, String name) {
            HashMap<String, Object> enumMap = enumMaps.get(cls);
            if (enumMap == null) {
                T[] consts = cls.getEnumConstants();
                enumMap = new HashMap<String, Object>(consts.length);
                for (T e : consts) {
                    enumMap.put(((Enum<?>) e).toString(), e);
                }
                enumMaps.put(cls, enumMap);
            }
            T v = (T) enumMap.get(name);
            if (v == null) {
                v = (T) enumMap.get("Other");
            }
            return v;
        }

        /**
         * Set the current element and positions to its first child.
         *
         * @param element
         */
        private void setCurrentElement(Object element) {
            currentElement = element;
        }

        @Override
        public void close() {
        }

        @Override
        public <T> T read(String name, Class<T> cls) {
            T value = parseElement(((JsonObject)currentElement).getValue(name),  cls);
            return value;
        }

        @Override
        public <T> T readAttribute(String name, Class<T> cls) {
            T value = parseElement(((JsonObject)currentElement).getValue("~" + name),  cls);
            return value;
        }


        @Override
        public <T> List<T> readList(String memberName, Class<T> cls) {
            return parseElement(currentElement, ArrayList.class);
        }

        @Override
        public <T> List<T> readList(String name, String memberName, Class<T> cls) {
            return parseElement(((JsonObject)currentElement).getJsonArray(name), ArrayList.class);
        }

        @Override
        public List<Element> readAny() {
            return parseElement(currentElement, ArrayList.class);

        }

        @Override
        public <T> T readValue(Class<T> cls) {
            return parseElement(currentElement, cls);
        }


        public MwsJsonObjectReader(JsonObject object) {
            try {
                setCurrentElement(object);
            } catch (Exception e) {
                throw MwsUtl.wrap(e);
            }
        }

    }
