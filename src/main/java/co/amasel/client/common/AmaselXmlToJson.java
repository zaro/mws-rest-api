package co.amasel.client.common;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * Created by zaro on 5/30/16.
 */
public class AmaselXmlToJson {
    static class JsonPoint {
        String name;
        JsonObject o;
        Object v;

        public JsonPoint(String name, Object v) {
            this.name = name;
            o = null;
            this.v = v;
        }

        public JsonPoint(String name) {
            this.name = name;
            v = null;
            o = new JsonObject();
        }

        public boolean isObject(){
            return  o != null;
        }
        public boolean isValue(){
            return  v != null;
        }


        public void put(JsonPoint obj){
            if( o != null ){
                if( o.containsKey(obj.name) ){
                    try {
                        JsonArray arr = o.getJsonArray(obj.name);
                        arr.add(obj.asObject());
                    } catch (ClassCastException e ) {
                        JsonArray  arr = new JsonArray();
                        arr.add(o.getValue(obj.name));
                        arr.add(obj.asObject());
                        o.put(obj.name, arr);
                    }
                } else {
                    o.put(obj.name, obj.asObject());
                }
            } else {
                v = obj.v;
            }
        }

        public Object asObject() {
            return  o != null ? o : v;
        }

        public String toString() {
            if(v != null){
                return v.toString();
            }
            if(o != null){
                return o.encode();
            }
            return "null";
        }

    }

    static class NodeDescription {
        final String name;
        final boolean isText;
        //final boolean isArray;
        //final Set<String> arrays;
        final List<Node> children;

        public NodeDescription(Node node, NodeDescription parent){
            name = node.getNodeName();
            //isArray = parent != null ? parent.isChildAnArray(name) : false;
            boolean isText = true;
            //HashMap<String, Integer> seen = new HashMap<>();
            children = new Vector<>();
            NodeList nodeList = node.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node currentNode = nodeList.item(i);
                short nodeType = currentNode.getNodeType();
                String nodeName = currentNode.getNodeName();
                if (nodeType == Node.ELEMENT_NODE) {
                    //if(seen.containsKey(nodeName)){
                    //    seen.put(nodeName, seen.get(nodeName) +1);
                    //} else {
                    //    seen.put(nodeName, 1);
                    //}
                    children.add(currentNode);
                }
                if( nodeType != Node.TEXT_NODE && nodeType != Node.COMMENT_NODE ){
                    isText = false;
                }
            }
            this.isText = isText;
            //arrays = new HashSet<>();
            //for(Map.Entry<String, Integer> entry: seen.entrySet()){
            //    if(entry.getValue() > 1){
            //        arrays.add(entry.getKey());
            //    }
            //}
        }

        //public boolean isChildAnArray(String nodeName){
        //    return arrays.contains(nodeName);
        //}
    }

    public static JsonObject convert(String xmlString) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlString));
        Document document = docBuilder.parse(is);
        JsonPoint json = traverse(document.getDocumentElement(), null);

        return json.o;
    }

    public static JsonObject convert(File file) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(file);
        JsonPoint json = traverse(document.getDocumentElement(), null);

        return json.o;
    }

    public static JsonPoint traverse(Node node, NodeDescription nType) {
        // do something with the current node instead of System.out
        NodeDescription nodeDescription = (nType != null) ? nType : new NodeDescription(node, null);

        if( nodeDescription.isText ){
            return new JsonPoint(nodeDescription.name,node.getTextContent());
        }

        JsonPoint json = new JsonPoint(nodeDescription.name);

        NamedNodeMap attributes = node.getAttributes();
        for(int i = 0; i < attributes.getLength(); ++i){
            Node attribute = attributes.item(i);
            json.put( new JsonPoint("~"  + attribute.getNodeName(), attribute.getNodeValue()) );
        }

        for(Node currentNode : nodeDescription.children){
            //calls this method for all the children which is Element
            NodeDescription childNodeDescription =  new NodeDescription(currentNode, nodeDescription);
            JsonPoint childJson = traverse(currentNode, childNodeDescription);
            json.put( childJson );
        }
        return json;
    }

    public static void main(String[] args) throws SAXException, IOException,
            ParserConfigurationException, TransformerException {
        JsonObject o = AmaselXmlToJson.convert(new File("document.xml"));
        System.out.println(o.encodePrettily());
    }


}
