package co.amasel;

import com.amazonservices.mws.client.MwsJsonWriter;
import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsUtl;
import com.amazonservices.mws.client.MwsWriter;
import io.vertx.core.http.HttpServerResponse;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;

/**
 * Created by zaro on 11/21/15.
 */
public class MwsApiJsonSerialize  implements MwsWriter {
    final HttpServerResponse response;

    public MwsApiJsonSerialize(HttpServerResponse response) {
        this.response = response;
    }

    protected void append(String v) {
        response.write(v);
    }

    protected void append(String v, int start, int end) {
        response.write(v.substring(start, end));
    }


    /* -------- COPY FROM MwsJsonWriter ----------- */

    /** Escape sequences for escaped chars, in order. */
    private static final String[] ESCAPE_SEQ = new String[]{"\\\"", "\\\\",
            "\\/", "\\b", "\\f", "\\n", "\\r", "\\t"};

    /** Chars that must be escaped for JSON. */
    private static final String ESCAPED_CHARS = "\"\\/\b\f\n\r\t";


    /** Inside an object. */
    private int inObject;

    /** True if after a value. */
    private boolean needComma;

    /**
     * Append a value.
     *
     * @param value
     */
    private void appendValue(Object value) {
        if (value == null) {
            append("null");
        } else if (value instanceof MwsObject) {
            append("{");
            needComma = false;
            ((MwsObject) value).writeFragmentTo(this);
            append("}");
        } else if (value instanceof Boolean || value instanceof Number) {
            append(value.toString());
        } else if (value instanceof String) {
            append("\"");
            escape((String) value);
            append("\"");
        } else if (value instanceof Node) {
            appendValue(toXmlString((Node) value));
        } else if (value instanceof XMLGregorianCalendar) {
            append("\"");
            append(((XMLGregorianCalendar) value).toXMLFormat());
            append("\"");
        } else if (value instanceof Enum) {
            append("\"");
            append(value.toString());
            append("\"");
        } else {
            throw new IllegalArgumentException("Unsupported type "+value.getClass().getName());
        }
        needComma = true;
    }

    /**
     * Output comma and "name": as appropriate for the current output state.
     *
     * @param name
     */
    private void commaName(String name) {
        if (needComma) {
            append(",");
        }
        append("\"");
        escape(name);
        append("\":");
    }

    /**
     * Output escaped value.
     *
     * @param value
     */
    private void escape(String value) {
        int n = value.length();
        int i = 0;
        for (int j = 0; j < n; ++j) {
            char c = value.charAt(j);
            int k = ESCAPED_CHARS.indexOf(c);
            if (k >= 0 || c < ' ') {
                if (i < j) {
                    append(value, i, j);
                }
                if (k >= 0) {
                    append(ESCAPE_SEQ[k]);
                } else {
                    append("\\u");
                    append(String.format("%04x", Integer.valueOf(c)));
                }
                i = j + 1;
            }
        }
        if (i < n) {
            append(value, i, n);
        }
    }

    @Override
    public void beginObject(String name) {
        if (inObject>0) {
            commaName(name);
        }
        append("{");
        needComma = false;
        inObject++;
    }

    @Override
    public void endObject(String name) {
        append("}");
        needComma = true;
        inObject--;
    }

    @Override
    public void write(String namespace, String name, MwsObject value) {
        if (value != null) {
            beginObject(name);
            //writeAttribute("xmlns", namespace);
            value.writeFragmentTo(this);
            endObject(name);
        }
    }

    @Override
    public void write(String name, Object value) {
        if (value != null) {
            commaName(name);
            appendValue(value);
        }
    }

    @Override
    public void writeAttribute(String name, Object value) {
        write(name, value);
    }

    @Override
    public void writeValue(Object value) {
        write("Value", value);
    }


    @Override
    public void close() {
    }

    @Override
    public void writeList(String name, Collection<?> list) {
        if (list==null) {
            return;
        }
        commaName(name);
        append("[");
        needComma = false;
        for (Object value : list) {
            if (needComma) {
                append(",");
            }
            appendValue(value);
        }
        append("]");
        needComma = true;
    }

    @Override
    public void writeList(String name, String memberName, Collection<?> list) {
        writeList(name, list);
    }

    @Override
    public void writeAny(Collection<Element> elements) {
        if(elements != null) {
            for(Element element : elements) {
                String name = element.getLocalName();
                if(name == null) {
                    name = element.getTagName();
                }
                write(name, element);
            }
        }
    }

    /** Thread local transformer factory. */
    private static final ThreadLocal<TransformerFactory> threadTF = new ThreadLocal<TransformerFactory>();

    static String toXmlString(Node node) {
        try {
            Transformer transformer = getTF().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(node);
            transformer.transform(source, result);
            return sw.toString();
        } catch (Exception e) {
            throw wrap(e);
        }
    }
    public static TransformerFactory getTF() {
        TransformerFactory tf = threadTF.get();
        if (tf == null) {
            tf = TransformerFactory.newInstance();
            threadTF.set(tf);
        }
        return tf;
    }

    public static RuntimeException wrap(Throwable e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new RuntimeException(e);
    }
}
