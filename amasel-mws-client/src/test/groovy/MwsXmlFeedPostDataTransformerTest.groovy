/**
 * Created by zaro on 1/7/17.
 */

import co.amasel.client.common.MwsXmlFeedPostDataTransformer
import io.vertx.core.json.JsonObject
import io.vertx.groovy.ext.unit.TestContext
import io.vertx.groovy.ext.unit.junit.VertxUnitRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.xmlunit.matchers.CompareMatcher

@RunWith(VertxUnitRunner.class)
public class MwsXmlFeedPostDataTransformerTest {

    @Test
    void testMwsXmlFeedPostDataTransformer(TestContext context) {
        JsonObject json = new JsonObject('''{
                "SellerId" : "M_SELLER_354577",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "Query" : "queryString",
                "QueryContextId" : "All",
                "array": [ {"d" : "2" }, {"t":"3"} ],
                "FeedContent" : {
                    "MessageType" : "Inventory",
                    "messages" : [
                        {
                            "SKU": "ASUSVNA1", 
                            "Quantity" : 8,
                            "FulfillmentLatency": 1 
                        }, {
                            "SKU": "ASUS8VM" ,
                            "Quantity" : 6,
                            "FulfillmentLatency": 1 
                        }
                    ]
                }
            }''');

        def xml = '''<?xml version="1.0" encoding="UTF-8"?>
<AmazonEnvelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="amzn-envelope.xsd">
    <Header>
        <DocumentVersion>1.01</DocumentVersion>
        <MerchantIdentifier>M_SELLER_354577</MerchantIdentifier>
    </Header>
    <MessageType>Inventory</MessageType>
    <Message>
        <MessageID>1</MessageID>
        <OperationType>Update</OperationType>
        <Inventory>
            <SKU>ASUSVNA1</SKU>
            <Quantity>8</Quantity>
            <FulfillmentLatency>1</FulfillmentLatency>
        </Inventory>
    </Message>
    <Message>
        <MessageID>2</MessageID>
        <OperationType>Update</OperationType>
        <Inventory>
            <SKU>ASUS8VM</SKU>
            <Quantity>6</Quantity>
            <FulfillmentLatency>1</FulfillmentLatency>
        </Inventory>
    </Message>
</AmazonEnvelope>''';
        def converter = new MwsXmlFeedPostDataTransformer();
        converter.init(json);
        TestsCommon.assertThat(context, 'XML different' ,converter.getPostData(), CompareMatcher.isSimilarTo(xml).ignoreWhitespace())

    }

}
