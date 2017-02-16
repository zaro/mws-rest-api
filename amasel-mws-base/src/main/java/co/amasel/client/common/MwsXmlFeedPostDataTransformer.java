package co.amasel.client.common;

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
import java.io.StringWriter;
import java.util.*;

/**
 * Created by zaro on 1/7/17.
 */
public class MwsXmlFeedPostDataTransformer extends MwsPostDataTransformer {
    static protected Map<String, List<String>> FIELD_ORDERS = new HashMap<>();
    static {
        FIELD_ORDERS.put("Inventory", Arrays.asList(
                "SKU", "FulfillmentCenterID", "Available", "Quantity", "Lookup",
                "RestockDate", "FulfillmentLatency", "SwitchFulfillmentTo"
        ));
        FIELD_ORDERS.put("Price",Arrays.asList(
                "SKU" ,"StandardPrice", "MAP", "DepositAmount",
                "Sale", "Previous"
        ));
        FIELD_ORDERS.put("ProductImage",Arrays.asList(
                "SKU" ,"ImageType", "ImageLocation"
        ));
        // TODO: complete the lists below
        FIELD_ORDERS.put("Product",Arrays.asList(
                "SKU"
        ));
        FIELD_ORDERS.put("Relationship",Arrays.asList(
                "ParentSKU"
        ));
        FIELD_ORDERS.put("OrderFulfillment",Arrays.asList(
                "AmazonOrderID", "MerchantOrderID", "MerchantFulfillmentID",
                "FulfillmentDate",
                "FulfillmentData", // Complex SEQUENCE TODO
                "Item" // Complex SEQUENCE TODO
        ));
    }
    protected String sellerId;
    protected String body;
    protected String contentType;
    protected int messageId;

    Document doc;

    public MwsXmlFeedPostDataTransformer(){
    }

    public MwsXmlFeedPostDataTransformer init(JsonObject request){
        super.init(request);
        this.sellerId = request.getString("SellerId");
        messageId = 1;
        getDocument();
        buildXmlDoc(request);
        makeBody();
        return this;
    }



    protected Document getDocument() {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            doc = icBuilder.newDocument();
            doc.setXmlVersion("1.0");
            doc.setXmlStandalone(true);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return doc;
    }

    protected  Node makeElement(String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    protected Node makeMessage(String messageType, JsonObject jsonMessage){
        Element message = doc.createElement("Message");
        message.appendChild(makeElement("MessageID", String.valueOf(jsonMessage.getValue("MessageID", messageId++))));
        message.appendChild(makeElement("OperationType", jsonMessage.getString("OperationType", "Update")));

        Element messageContent = doc.createElement(messageType);
        Set<String> usedKeys = new HashSet<>();
        usedKeys.add("MessageID");
        usedKeys.add("OperationType");

        if( FIELD_ORDERS.containsKey(messageType) ){
            for (String key : FIELD_ORDERS.get(messageType) ) {
                if(jsonMessage.containsKey(key)) {
                    messageContent.appendChild(makeElement(key, String.valueOf(jsonMessage.getValue(key))));
                    usedKeys.add(key);
                }
            }

        }
        for (String key : jsonMessage.fieldNames()) {
            if(!usedKeys.contains(key)) {
                messageContent.appendChild(makeElement(key, String.valueOf(jsonMessage.getValue(key))));
            }
        }

        message.appendChild(messageContent);

        return message;
    }

    protected void buildXmlDoc(JsonObject request){
        JsonObject feedContent = request.getJsonObject("FeedContent");
        if(feedContent == null) {
            return;
        }

        Element mainRootElement = doc.createElement("AmazonEnvelope");
        mainRootElement.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
        mainRootElement.setAttribute("xsi:noNamespaceSchemaLocation","amzn-envelope.xsd");

        doc.appendChild(mainRootElement);

        String messageType = feedContent.getString("MessageType");

        Element header = doc.createElement("Header");
        header.appendChild(makeElement("DocumentVersion", "1.01"));
        header.appendChild(makeElement("MerchantIdentifier", sellerId));

        mainRootElement.appendChild(header);

        mainRootElement.appendChild(makeElement("MessageType", messageType));

        JsonArray messages = feedContent.getJsonArray("messages");
        for(int pos = 0; pos < messages.size(); ++pos){
            JsonObject el = messages.getJsonObject(pos);
            mainRootElement.appendChild(makeMessage(messageType, el));
        }
    }

    protected void makeBody() {
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        body = writer.getBuffer().toString();
        contentType = "application/xml; charset=utf-8";
    }

    public boolean hasPostData() {
        return body != null;
    }

    public String getPostData() {
        return body;
    }

    public String getContentType() {
        return contentType;
    }

}
