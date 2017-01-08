import co.amasel.model.common.MwsJsonObjectWriter
import co.amasel.model.products.GetMatchingProductForIdResponse
import com.amazonservices.mws.client.MwsJsonWriter
import com.amazonservices.mws.client.MwsObject
import com.amazonservices.mws.client.MwsXmlReader
import io.vertx.core.json.JsonObject
import io.vertx.groovy.ext.unit.TestSuite

def suite = TestSuite.create("co.amasel.model")

def classes =[
//        'feeds': [
//                    'CancelFeedSubmissionsResponse',
//                    'ErrorResponse',
//                    'GetFeedSubmissionCountResponse',
//                    'GetFeedSubmissionListByNextTokenResponse',
//                    'GetFeedSubmissionListResponse',
//                    'GetFeedSubmissionResultResponse',
//                    'SubmitFeedResponse',
//                ],
//        'reports': [
//                'CancelReportRequestsResponse',
//                'ErrorResponse',
//                'GetReportCountResponse',
//                'GetReportListByNextTokenResponse',
//                'GetReportListResponse',
//                'GetReportRequestCountResponse',
//                'GetReportRequestListByNextTokenResponse',
//                'GetReportRequestListResponse',
//                'GetReportResponse',
//                'GetReportScheduleCountResponse',
//                'GetReportScheduleListByNextTokenResponse',
//                'GetReportScheduleListResponse',
//                'ManageReportScheduleResponse',
//                'RequestReportResponse',
//                'UpdateReportAcknowledgementsResponse',
//        ],
        'products': [
                //'ErrorResponse',
//                'GetCompetitivePricingForASINResponse',
//                'GetCompetitivePricingForSKUResponse',
//                'GetLowestOfferListingsForASINResponse',
//                'GetLowestOfferListingsForSKUResponse',
//                'GetLowestPricedOffersForASINResponse',
//                'GetLowestPricedOffersForSKUResponse',
                'GetMatchingProductForIdResponse',
//                'GetMatchingProductResponse',
//                'GetMyPriceForASINResponse',
//                'GetMyPriceForSKUResponse',
//                'GetProductCategoriesForASINResponse',
//                'GetProductCategoriesForSKUResponse',
//                'GetServiceStatusResponse',
//                'ListMatchingProductsResponse',
        ]
]

def testXml = """<?xml version="1.0"?>
<GetMatchingProductForIdResponse
  xmlns="http://mws.amazonservices.com/schema/Products/2011-10-01">
  <GetMatchingProductForIdResult Id="ak 950" IdType="SellerSKU" status="Success">
    <Products
      xmlns="http://mws.amazonservices.com/schema/Products/2011-10-01"
      xmlns:ns2="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd">
      <Product>
        <Identifiers>
          <MarketplaceASIN>
            <MarketplaceId>A1PA6795UKMFR9</MarketplaceId>
            <ASIN>B016QRC4UE</ASIN>
          </MarketplaceASIN>
        </Identifiers>
        <AttributeSets>
          <ns2:ItemAttributes xml:lang="de-DE">
            <ns2:Binding>Haushaltswaren</ns2:Binding>
            <ns2:Brand>Lucky Patches</ns2:Brand>
            <ns2:Feature>Durchmesser 9 cm</ns2:Feature>
            <ns2:Feature>aufwendig gestickter Qualitäts Aufnäher</ns2:Feature>
            <ns2:Feature>zum Aufnähen oder einfach Aufbügeln</ns2:Feature>
            <ns2:Feature>eine Gebrauchsanweisung</ns2:Feature>
            <ns2:Feature>schicken wir Ihnen natürlich mit.</ns2:Feature>
            <ns2:Model>ak 950</ns2:Model>
            <ns2:PackageQuantity>1</ns2:PackageQuantity>
            <ns2:PartNumber>ak 950</ns2:PartNumber>
            <ns2:ProductGroup>Küche &amp; Haushalt</ns2:ProductGroup>
            <ns2:ProductTypeName>HOME</ns2:ProductTypeName>
            <ns2:SmallImage>
              <ns2:URL>http://ecx.images-amazon.com/images/I/61H%2BqitF0wL._SL75_.jpg</ns2:URL>
              <ns2:Height Units="pixels">75</ns2:Height>
              <ns2:Width Units="pixels">75</ns2:Width>
            </ns2:SmallImage>
            <ns2:Title>Aufnäher / Iron on Patch " LIVE FREE RIDE FREE "</ns2:Title>
          </ns2:ItemAttributes>
        </AttributeSets>
        <Relationships/>
        <SalesRankings>
          <SalesRank>
            <ProductCategoryId>kitchen_display_on_website</ProductCategoryId>
            <Rank>1573658</Rank>
          </SalesRank>
          <SalesRank>
            <ProductCategoryId>2993282031</ProductCategoryId>
            <Rank>7203</Rank>
          </SalesRank>
        </SalesRankings>
      </Product>
    </Products>
  </GetMatchingProductForIdResult>
  <ResponseMetadata>
    <RequestId>f8959d8a-a0c2-4a47-9342-a379d2915a62</RequestId>
  </ResponseMetadata>
</GetMatchingProductForIdResponse>
"""
def testJson = """
<GetMatchingProductForIdResponse
  xmlns="http://mws.amazonservices.com/schema/Products/2011-10-01">
  <GetMatchingProductForIdResult Id="ak 950" IdType="SellerSKU" status="Success">
    <Products
      xmlns="http://mws.amazonservices.com/schema/Products/2011-10-01"
      xmlns:ns2="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd">
      <Product>
        <Identifiers>
          <MarketplaceASIN>
            <MarketplaceId>A1PA6795UKMFR9</MarketplaceId>
            <ASIN>B016QRC4UE</ASIN>
          </MarketplaceASIN>
        </Identifiers>
        <AttributeSets>
          <ns2:ItemAttributes xml:lang="de-DE">
            <ns2:Binding>Haushaltswaren</ns2:Binding>
            <ns2:Brand>Lucky Patches</ns2:Brand>
            <ns2:Feature>Durchmesser 9 cm</ns2:Feature>
            <ns2:Feature>aufwendig gestickter Qualitäts Aufnäher</ns2:Feature>
            <ns2:Feature>zum Aufnähen oder einfach Aufbügeln</ns2:Feature>
            <ns2:Feature>eine Gebrauchsanweisung</ns2:Feature>
            <ns2:Feature>schicken wir Ihnen natürlich mit.</ns2:Feature>
            <ns2:Model>ak 950</ns2:Model>
            <ns2:PackageQuantity>1</ns2:PackageQuantity>
            <ns2:PartNumber>ak 950</ns2:PartNumber>
            <ns2:ProductGroup>Küche &amp; Haushalt</ns2:ProductGroup>
            <ns2:ProductTypeName>HOME</ns2:ProductTypeName>
            <ns2:SmallImage>
              <ns2:URL>http://ecx.images-amazon.com/images/I/61H%2BqitF0wL._SL75_.jpg</ns2:URL>
              <ns2:Height Units="pixels">75</ns2:Height>
              <ns2:Width Units="pixels">75</ns2:Width>
            </ns2:SmallImage>
            <ns2:Title>Aufnäher / Iron on Patch " LIVE FREE RIDE FREE "</ns2:Title>
          </ns2:ItemAttributes>
        </AttributeSets>
        <Relationships/>
        <SalesRankings>
          <SalesRank>
            <ProductCategoryId>kitchen_display_on_website</ProductCategoryId>
            <Rank>1573658</Rank>
          </SalesRank>
          <SalesRank>
            <ProductCategoryId>2993282031</ProductCategoryId>
            <Rank>7203</Rank>
          </SalesRank>
        </SalesRankings>
      </Product>
    </Products>
  </GetMatchingProductForIdResult>
  <ResponseMetadata>
    <RequestId>f8959d8a-a0c2-4a47-9342-a379d2915a62</RequestId>
  </ResponseMetadata>
</GetMatchingProductForIdResponse>
"""


//classes.each { pkgName , clsList ->
//    clsList.each { clsName ->
//        suite.test(clsName, { context ->
//            def xmlFileResourse = "/co/amasel/model/${pkgName}/mock/${clsName}.xml";
//            def cls = Class.forName("co.amasel.model.${pkgName}.${clsName}")
//            def stream = Class.getResourceAsStream(xmlFileResourse)
//            MwsXmlReader reader = new MwsXmlReader(stream)
//            MwsObject o = cls.newInstance()
//            o.readFragmentFrom(reader)
//            def or = new OutputStreamWriter(System.out)
//            MwsJsonObjectWriter writer = new MwsJsonObjectWriter()
//            o.writeTo(writer)
//            or.flush()
//            print writer.getJsonObject().encodePrettily()
//            context.assertTrue(true)
//        });
//    }
//}

suite.test("GetMatchingProductForIdResponse", { context ->
    InputStream stream = new ByteArrayInputStream( testXml.getBytes( "UTF-8" ) );
    MwsXmlReader reader = new MwsXmlReader(stream)
    MwsObject o = new GetMatchingProductForIdResponse();
    o.readFragmentFrom(reader)
    def or = new OutputStreamWriter(System.out)
    MwsJsonObjectWriter writer = new MwsJsonObjectWriter()
    o.writeFragmentTo(writer)
    or.flush()
    print writer.getJsonObject().encodePrettily()
    context.assertTrue(true)
});

suite.run([
 reporters: [
         [ to: "console" ]
 ]
]).handler({ ar ->
    System.exit( ar.succeeded() ? 0 : -1)
})