import co.amasel.client.misc.JsonObjectToBean
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

def suite = TestSuite.create("co.amasel.MwsJsonObjectReader")

suite.test("ListMatchingProducts", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "Query" : "queryString",
                "QueryContextId" : "All"
            }
    ''');
    def req = JsonObjectToBean.toBean(json, ListMatchingProductsRequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals("queryString", req.getQuery())
    context.assertEquals("All", req.getQueryContextId())
});

suite.test("GetMatchingProduct", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "ASINList" : [ "id1", "id2", "id3" ]
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetMatchingProductRequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals(Arrays.asList("id1", "id2", "id3"), req.getASINList().getASIN());
});

suite.test("GetMatchingProductForIdRequest", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "IdType" : "ASIN",
                "IdList" : [ "id1", "id2", "id3" ]
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetMatchingProductForIdRequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals("ASIN", req.getIdType())
    context.assertEquals(Arrays.asList("id1", "id2", "id3"), req.getIdList().getId())
});

suite.test("GetCompetitivePricingForSKU", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "SellerSKUList" : [ "id1", "id2", "id3" ]
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetCompetitivePricingForSKURequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals(Arrays.asList("id1", "id2", "id3"), req.getSellerSKUList().getSellerSKU())
});

suite.test("GetCompetitivePricingForASIN", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "ASINList" : [ "id1", "id2", "id3" ]
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetCompetitivePricingForASINRequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals(Arrays.asList("id1", "id2", "id3"), req.getASINList().getASIN())
});

suite.test("GetLowestOfferListingsForSKU", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "SellerSKUList" : [ "id1", "id2", "id3" ],
                "ItemCondition" : "Any",
                "ExcludeMe" : true
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetLowestOfferListingsForSKURequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals(Arrays.asList("id1", "id2", "id3"), req.getSellerSKUList().getSellerSKU())
    context.assertEquals("Any", req.getItemCondition())
});

suite.test("GetLowestOfferListingsForASIN", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "ASINList" : [ "id1", "id2", "id3" ],
                "ItemCondition" : "Any",
                "ExcludeMe" : true
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetLowestOfferListingsForASINRequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals(Arrays.asList("id1", "id2", "id3"), req.getASINList().getASIN())
    context.assertEquals("Any", req.getItemCondition())
});

suite.test("GetLowestPricedOffersForSKU", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "SellerSKU" :  "id1",
                "ItemCondition" : "Any"
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetLowestPricedOffersForSKURequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals("id1", req.getSellerSKU())
    context.assertEquals("Any", req.getItemCondition())
});

suite.test("GetLowestPricedOffersForASIN", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "ASIN" :  "id1",
                "ItemCondition" : "Any"
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetLowestPricedOffersForASINRequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals("id1", req.getASIN())
    context.assertEquals("Any", req.getItemCondition())
});

suite.test("GetMyPriceForSKU", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "SellerSKUList" : [ "id1", "id2", "id3" ]
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetMyPriceForSKURequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals(Arrays.asList("id1", "id2", "id3"), req.getSellerSKUList().getSellerSKU())
});

suite.test("GetMyPriceForASIN", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "ASINList" : [ "id1", "id2", "id3" ]
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetMyPriceForASINRequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals(Arrays.asList("id1", "id2", "id3"), req.getASINList().getASIN())
});

suite.test("GetProductCategoriesForSKU", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "SellerSKU" :  "id1"
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetProductCategoriesForSKURequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals("id1", req.getSellerSKU())
});

suite.test("GetProductCategoriesForASIN", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken",
                "MarketplaceId" : "marketPlaceId",
                "ASIN" :  "id1"
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetProductCategoriesForASINRequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
    context.assertEquals("marketPlaceId", req.getMarketplaceId())
    context.assertEquals("id1", req.getASIN())
});

suite.test("GetServiceStatusRequest", { context ->
    JsonObject json = new JsonObject('''
            {
                "SellerId" : "sellerid",
                "MWSAuthToken" : "authToken"
            }
    ''');
    def req = JsonObjectToBean.toBean(json, GetServiceStatusRequest.class)
    context.assertEquals("sellerid", req.getSellerId())
    context.assertEquals("authToken", req.getMWSAuthToken())
})



suite.run([
 reporters: [
         [ to: "console" ]
 ]
]).handler({ ar ->
    System.exit( ar.succeeded() ? 0 : -1)
})