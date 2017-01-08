/**
 * Created by zaro on 6/1/16.
 */

import co.amasel.client.common.AmaselJsonToXml
import co.amasel.client.common.AmaselXmlToJson
import io.vertx.core.json.JsonObject
import io.vertx.groovy.ext.unit.TestSuite
import org.xmlunit.builder.DiffBuilder
import org.xmlunit.diff.Diff
import org.xmlunit.diff.Difference
import org.xmlunit.matchers.CompareMatcher

def suite = TestSuite.create("co.amasel.XmlJsonConvert")

def testXmlFiles = [
        'productfeed.xml'
]


suite.test("jsonToXml", { context ->
    JsonObject json = new JsonObject('''
            {"root" :{
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "Query" : "queryString",
                "QueryContextId" : "All",
                "array": [ {"d" : "2" }, {"t":"3"} ]
            }}
    ''');
    def xml = AmaselJsonToXml.convert(json)
    def jsonConverted = AmaselXmlToJson.convert(xml)
    context.assertEquals(json, jsonConverted)
});

def CompareMatcher isXmlIdenticalTo(String xml) {
    return CompareMatcher.isIdenticalTo(xml)
            .normalizeWhitespace()
            .withNamespaceContext()
            .ignoreComments();
}

suite.test("xmlFiles", { context ->
    for( xmlFile in testXmlFiles){
        def xmlFileResourse = "/co/amasel/convert/" + xmlFile;
        def stream = Class.getResourceAsStream(xmlFileResourse)
        def xml = String.join("", stream.readLines())

        def json = AmaselXmlToJson.convert(xml)
        def convertedXml = AmaselJsonToXml.convert(json)



        if(!isXmlIdenticalTo(xml).matches(convertedXml)){
            String desc = ""
            Diff myDiff = DiffBuilder.compare(xml).withTest(convertedXml).ignoreWhitespace().ignoreComments().build();
            for(Difference it : myDiff.getDifferences()) {
                desc += it.getComparison().toString();
            }
            context.fail(desc)
        }
    }
});

suite.test("models", { context ->
    for(pkgName in ["maws", "products"]){
        def resourceDir = "co/amasel/model/${pkgName}/mock/"
        def fileList = TestsCommon.listResourceDir( resourceDir )
        fileList.each { fileName ->
            def xmlFileResourse = "/" + resourceDir + fileName
            println xmlFileResourse
            def stream = Class.getResourceAsStream(xmlFileResourse)
            def xml = String.join("", stream.readLines())

            def json = AmaselXmlToJson.convert(xml)
            def convertedXml = AmaselJsonToXml.convert(json)
            println json.encodePrettily()


            if (!isXmlIdenticalTo(xml).matches(convertedXml)) {
                String desc = ""
                Diff myDiff = DiffBuilder.compare(xml).withTest(convertedXml).ignoreWhitespace().ignoreComments().build();
                for (Difference it : myDiff.getDifferences()) {
                    desc += it.getComparison().toString();
                }
                context.fail(desc)
            }
        }
    }
});


suite.run([
        reporters: [
                [ to: "console" ]
        ]
]).handler({ ar ->
    System.exit( ar.succeeded() ? 0 : -1)
})