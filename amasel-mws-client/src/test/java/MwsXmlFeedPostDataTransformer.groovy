/**
 * Created by zaro on 1/7/17.
 */

import io.vertx.core.json.JsonObject
import io.vertx.groovy.ext.unit.TestContext
import io.vertx.groovy.ext.unit.TestSuite
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.StringDescription
import org.xmlunit.matchers.CompareMatcher

def suite = TestSuite.create("co.amasel.client.common.MwsXmlFeedPostDataTransformer")


static <T> void assertThat(TestContext context, String reason,
                           T actual, Matcher<? super T> matcher) {
    if (!matcher.matches(actual)) {
        Description description = new StringDescription();
        description.appendText(reason)
                .appendText("\nExpected: ")
                .appendDescriptionOf(matcher)
                .appendText("\n     but: ");
        matcher.describeMismatch(actual, description);
        context.fail(description.toString());
    }
}

suite.test("FeedContent", { context ->
    JsonObject json = new JsonObject('''{
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "Query" : "queryString",
                "QueryContextId" : "All",
                "array": [ {"d" : "2" }, {"t":"3"} ],
                "FeedContent" : {
                    "MessageType" : "Inventory",
                    "messages" : [
                        {
                            "Inventory" : {
                                "SKU": "ASUSVNA1", 
                                "Quantity" : 8,
                                "FulfillmentLatency": 1 
                            }
                        }, {
                            "Inventory" : {
                                "SKU": "ASUS8VM" ,
                                "Quantity" : 6,
                                "FulfillmentLatency": 1 
                            }
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
    println MwsXmlFeedPostDataTransformer.methods*.name.sort().unique()
    def converter = new co.amasel.client.common.MwsXmlFeedPostDataTransformer(json, "M_SELLER_354577");
    assertThat(context, 'XML different' ,converter.getPostData(), CompareMatcher.isSimilarTo(xml).ignoreWhitespace())
});

suite.run([
        reporters: [
                [ to: "console" ]
        ]
]).handler({ ar ->
    System.exit( ar.succeeded() ? 0 : -1)
})