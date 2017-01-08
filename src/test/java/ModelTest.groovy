import com.amazonservices.mws.client.MwsJsonWriter
import com.amazonservices.mws.client.MwsObject
import com.amazonservices.mws.client.MwsXmlReader
//import com.amazonservices.mws.products.model.GetCompetitivePricingForASINRequest
//import com.amazonservices.mws.products.model.GetCompetitivePricingForSKURequest
//import com.amazonservices.mws.products.model.GetLowestOfferListingsForASINRequest
//import com.amazonservices.mws.products.model.GetLowestOfferListingsForSKURequest
//import com.amazonservices.mws.products.model.GetLowestPricedOffersForASINRequest
//import com.amazonservices.mws.products.model.GetLowestPricedOffersForSKURequest
//import com.amazonservices.mws.products.model.GetMatchingProductForIdRequest
//import com.amazonservices.mws.products.model.GetMatchingProductRequest
//import com.amazonservices.mws.products.model.GetMyPriceForASINRequest
//import com.amazonservices.mws.products.model.GetMyPriceForSKURequest
//import com.amazonservices.mws.products.model.GetProductCategoriesForASINRequest
//import com.amazonservices.mws.products.model.GetProductCategoriesForSKURequest
//import com.amazonservices.mws.products.model.GetServiceStatusRequest
//import com.amazonservices.mws.products.model.ListMatchingProductsRequest
import io.vertx.core.json.JsonObject
import io.vertx.groovy.ext.unit.TestSuite

def suite = TestSuite.create("co.amasel.model")

def classes =[
        'maws': [
                    'CancelFeedSubmissionsResponse',
                    'CancelReportRequestsResponse',
                    'ErrorResponse',
                    'GetFeedSubmissionCountResponse',
                    'GetFeedSubmissionListByNextTokenResponse',
                    'GetFeedSubmissionListResponse',
                    'GetFeedSubmissionResultResponse',
                    'GetReportCountResponse',
                    'GetReportListByNextTokenResponse',
                    'GetReportListResponse',
                    'GetReportRequestCountResponse',
                    'GetReportRequestListByNextTokenResponse',
                    'GetReportRequestListResponse',
                    'GetReportResponse',
                    'GetReportScheduleCountResponse',
                    'GetReportScheduleListByNextTokenResponse',
                    'GetReportScheduleListResponse',
                    'ManageReportScheduleResponse',
                    'RequestReportResponse',
                    'SubmitFeedResponse',
                    'UpdateReportAcknowledgementsResponse',
                ],
        'products': [
                //'ErrorResponse',
                'GetCompetitivePricingForASINResponse',
                'GetCompetitivePricingForSKUResponse',
                'GetLowestOfferListingsForASINResponse',
                'GetLowestOfferListingsForSKUResponse',
                'GetLowestPricedOffersForASINResponse',
                'GetLowestPricedOffersForSKUResponse',
                'GetMatchingProductForIdResponse',
                'GetMatchingProductResponse',
                'GetMyPriceForASINResponse',
                'GetMyPriceForSKUResponse',
                'GetProductCategoriesForASINResponse',
                'GetProductCategoriesForSKUResponse',
                'GetServiceStatusResponse',
                'ListMatchingProductsResponse',
        ]
]

classes.each { pkgName , clsList ->
    clsList.each { clsName ->
        suite.test(clsName, { context ->
            def xmlFileResourse = "/co/amasel/model/${pkgName}/mock/${clsName}.xml";
            def cls = Class.forName("co.amasel.model.${pkgName}.${clsName}")
            def stream = Class.getResourceAsStream(xmlFileResourse)
            MwsXmlReader reader = new MwsXmlReader(stream)
            MwsObject o = cls.newInstance()
            o.readFragmentFrom(reader)
            def or = new OutputStreamWriter(System.out)
            MwsJsonWriter writer = new MwsJsonWriter(or)
            o.writeTo(writer)
            or.flush()
            print "\n"
            context.assertTrue(true)
        });
    }
}

suite.run([
 reporters: [
         [ to: "console" ]
 ]
]).handler({ ar ->
    System.exit( ar.succeeded() ? 0 : -1)
})