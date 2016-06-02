package co.amasel.client.common;

import co.amasel.ApiRequestException;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by zaro on 6/1/16.
 */
public class AmaselJsonToXml {
    Document doc;
    boolean convertNumbers;

    public Node getTextElement(String name, String text){
        Node element = doc.createElement(name);
        element.appendChild(doc.createTextNode(text));
        return element;
    }

    public List<Node> traverse(JsonArray jsonNode, String nodeName) {
        Vector<Node> nodes = new Vector<>();
        for(Object value: jsonNode){
            if(value instanceof JsonObject){
                Node child = traverse((JsonObject) value, nodeName);
                nodes.add(child);
            }else if(value instanceof JsonArray){
                List<Node> children = traverse((JsonArray) value, nodeName);
                nodes.addAll(children);
            }else {
                nodes.add(getTextElement(nodeName,value.toString()));
            }
        }
        return nodes;
    }

    public Node traverse(JsonObject jsonNode, String nodeName) {
        Element node = doc.createElement(nodeName);
        for(Map.Entry<String, Object> it : jsonNode){
            String key = it.getKey();
            Object value = it.getValue();
            if(key.startsWith("~")){
                node.setAttribute(key.substring(1), value.toString());
            }else if(value instanceof JsonObject){
                Node child = traverse((JsonObject) value, key);
                node.appendChild(child);
            }else if(value instanceof JsonArray){
                List<Node> children = traverse((JsonArray) value, key);
                for(Node child:children){
                    node.appendChild(child);
                }
            }else {
                node.appendChild(getTextElement(key,value.toString()));
            }
        }
        return node;
    }

    public static String convert(JsonObject object, boolean convertNumbers) throws ParserConfigurationException, TransformerException, ApiRequestException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        if(object.size() != 1){
            throw new ApiRequestException("AmaselJsonToXml.convert : root JsonObject must have exactly 1 element ");
        }
        // root elements
        AmaselJsonToXml c = new AmaselJsonToXml();
        c.doc = docBuilder.newDocument();
        c.doc.setXmlStandalone(true);
        c.convertNumbers = convertNumbers;
        String rootName = object.iterator().next().getKey();
        Element rootElement = (Element) c.traverse(object.getJsonObject(rootName),rootName);
        c.doc.appendChild(rootElement);

        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");


        DOMSource source = new DOMSource(c.doc);

        ByteArrayOutputStream baos= new ByteArrayOutputStream();
        StreamResult result = new StreamResult(baos);
        transformer.transform(source, result);

        try {
            return baos.toString("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "UNSUPPORTED ENCODING";
        }

    }
    public static String convert(JsonObject object) throws ParserConfigurationException, TransformerException, ApiRequestException {
        return convert(object, false);
    }

}
