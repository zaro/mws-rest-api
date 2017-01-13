package co.amasel.db;

import io.vertx.core.json.JsonObject;
//import org.elasticsearch.action.admin.indices.alias.Alias;
//import org.elasticsearch.action.admin.indices.template.put.PutIndexTemplateAction;
//import org.elasticsearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder;
//import org.elasticsearch.action.bulk.BulkRequestBuilder;
//import org.elasticsearch.action.bulk.BulkResponse;
//import org.elasticsearch.action.get.GetResponse;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.common.unit.TimeValue;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.elasticsearch.index.IndexNotFoundException;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by zaro on 6/5/16.
 */
public class CacheDb extends Db{

    static final String cachedResultMappings = "{" +
            "\"" + Db.RECORD_TYPE +"\": {" +
            "  \"_all\":    { \"enabled\": false }," +
            "  \"properties\" : {" +
            "    \"expiry\":   { \"type\"   : \"date\"   }, " +
            "    \"content\" : { \"type\"   : \"string\", \"index\"  : \"no\" }," +
            "    \"obj\" :     { \"type\"   : \"object\"}," +
            "    \"tag\" :     { \"type\"   : \"string\", \"index\"  : \"not_analyzed\" }," +
            "    \"tagId\" :     { \"type\"   : \"string\", \"index\"  : \"not_analyzed\" }" +
            "   }," +
            "  \"dynamic_templates\": [{" +
            "          \"noindex\": {" +
            "            \"path_match\":   \"obj.*\"," +
            "            \"mapping\": {" +
            "              \"index\":    \"no\"" +
            "            }" +
            "          }" +
            "        }]" +
            "}," +
            "\"begin\" : {" +
            "  \"_all\":    { \"enabled\": false }," +
            "  \"properties\" : {" +
            "    \"ts\":   { \"type\"   : \"date\"   }, " +
            "    \"expiry\":   { \"type\"   : \"date\"   }, " +
            "    \"tag\"   :     { \"type\"   : \"string\", \"index\"  : \"not_analyzed\" }," +
            "    \"tagId\" :     { \"type\"   : \"string\", \"index\"  : \"not_analyzed\" }" +
            "   }" +
            "}," +
            "\"end\" : {" +
            "  \"_all\":    { \"enabled\": false }," +
            "  \"properties\" : {" +
            "    \"ts\":   { \"type\"   : \"date\"   }, " +
            "    \"expiry\":   { \"type\"   : \"date\"   }, " +
            "    \"numEntries\":   { \"type\"   : \"integer\" , \"index\"  : \"no\"  }, " +
            "    \"tag\" :     { \"type\"   : \"string\", \"index\"  : \"not_analyzed\" }," +
            "    \"tagId\" :     { \"type\"   : \"string\", \"index\"  : \"not_analyzed\" }," +
            "    \"hasError\" :{ \"type\"   : \"boolean\" }," +
            "    \"error\" :   { \"type\"   : \"string\", \"index\"  : \"not_analyzed\" }" +
            "   }" +
            "}" +
            "}";
    static String cachedIndexPrefix = "cached-results";
    static String cacheTagIndexName = cachedIndexPrefix + "-tags";
    static String cacheIndexName = cachedIndexPrefix + "-UNDEFINED";
    static long midnight = 0;

    public static void createCacheTemplate(){
//        PutIndexTemplateRequestBuilder builder = new PutIndexTemplateRequestBuilder(Db.client, PutIndexTemplateAction.INSTANCE, "cached-results-template" );
//
//        builder.setTemplate(cachedIndexPrefix +"-*");
//        builder.addAlias(new Alias(cachedIndexPrefix));
//        JsonObject m = new JsonObject(cachedResultMappings);
//        for(Map.Entry<String, Object> it : m) {
//            builder.addMapping(it.getKey(), ((JsonObject)it.getValue()).getMap() );
//        }
//        builder.get();
    }

    static String getCacheIndexName(){
        long now = System.currentTimeMillis();
        if( now >= midnight ){
            LocalDateTime todayMidnight = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
            LocalDateTime tomorrowMidnight = todayMidnight.plusDays(1);
            cacheIndexName = cachedIndexPrefix + "-" + todayMidnight.format(DateTimeFormatter.ISO_LOCAL_DATE);
            midnight = tomorrowMidnight.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
        }
        return cacheIndexName;
    }

    static String getCacheTagIndexName() {
        return  cacheTagIndexName;
    }

//    protected static void beginCacheResult(BulkRequestBuilder bulkRequest, CacheEntryTag ce) {
//        bulkRequest.add( Db.client.prepareIndex(getCacheTagIndexName(), "begin").setId(ce.tag).setTTL(ce.ttl).setSource(ce.toBeginRecord(), XContentType.JSON));
//    }
//
//    protected static void endCacheResult(BulkRequestBuilder bulkRequest, CacheEntryTag ce) {
//        bulkRequest.add( Db.client.prepareIndex(getCacheIndexName(), "end").setSource(ce.toEndRecord(), XContentType.JSON));
//    }
//
//    protected static boolean addCacheResult(BulkRequestBuilder bulkRequest, List<CacheEntry> records, boolean hasMore){
//        if(records != null){
//            for(CacheEntry doc: records){
//                bulkRequest.add(Db.client.prepareIndex(getCacheIndexName(), Db.RECORD_TYPE).setSource(doc.toRecord(), XContentType.JSON));
//            }
//        }
//        if(hasMore){
//            return  true;
//        }
//        BulkResponse responses = bulkRequest.get();
//        if(responses.hasFailures()){
//            System.out.println(responses.buildFailureMessage());
//        }
//        return !responses.hasFailures();
//    }

    static boolean beginCacheResult(CacheEntryTag ce, List<CacheEntry> records){
//        BulkRequestBuilder bulkRequest = Db.client.prepareBulk();
//        beginCacheResult(bulkRequest, ce);
//        return addCacheResult(bulkRequest, records, false);
        return false;
    }

    public static boolean addCacheResult(CacheEntryTag ce, List<CacheEntry> records){
//        BulkRequestBuilder bulkRequest = Db.client.prepareBulk();
//        ce.addNumEntries(records != null ? records.size() : 0);
//        return addCacheResult(bulkRequest, records, false);
        return false;
    }

    static boolean endCacheResult(CacheEntryTag ce){
//        BulkRequestBuilder bulkRequest = Db.client.prepareBulk();
//        endCacheResult(bulkRequest, ce);
//        return addCacheResult(bulkRequest, null, false);
        return false;
    }

    static boolean storeCacheResult(CacheEntryTag ce, List<CacheEntry> records){
//        BulkRequestBuilder bulkRequest = Db.client.prepareBulk();
//        beginCacheResult(bulkRequest, ce);
//        addCacheResult(bulkRequest, records, true);
//        ce.setNumEntries(records != null ? records.size(): 0);
//        endCacheResult(bulkRequest, ce);
//        return addCacheResult(bulkRequest, null, false);
        return false;
    }

    public static CacheEntryList loadCacheResult(CacheEntryTag ce){
//        String now = LocalDateTime.now().atZone(ZoneOffset.UTC).toString();
//        GetResponse response = Db.client.prepareGet(getCacheTagIndexName(), "begin", ce.tag).get();
//        CacheEntryList result = new CacheEntryList(ce);
//        if(!response.isExists()){
//            System.out.println("NO EXIST");
//            return null;
//        }
//        result.addGetResponse(response);
//        if(result.expiry().compareTo(now) < 0) {
//            System.out.println("EXPIRED");
//            return null;
//        }
//
//        QueryBuilder q =
//                QueryBuilders.boolQuery()
//                        .must(QueryBuilders.termQuery("tag", ce.tag ))
//                        .must(QueryBuilders.termQuery("tagId", result.tagId() ))
//                        .filter(QueryBuilders.rangeQuery("expiry").gte(now) );
//        //System.out.println(q);
//        try {
//            SearchResponse sr = Db.client.prepareSearch(cachedIndexPrefix)
//                    .setScroll(new TimeValue(60000))
//                    .setQuery(q).setSize(10000)
//                    .execute().actionGet();
//            Vector<JsonObject> r = new Vector<>();
//            while (true) {
//                System.out.println("Search took: " + sr.getTookInMillis() + "ms numHits:" + sr.getHits().getHits().length);
//                for (SearchHit hit : sr.getHits().hits()) {
//                    result.addSearchHit(hit);
//                }
//                sr = Db.client.prepareSearchScroll(sr.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
//                if (sr.getHits().getHits().length == 0) {
//                    break;
//                }
//            }
//            System.out.println("result entries: " +  result.size() + "  hasMore:"+ result.hasMore());
//            return result;
//        } catch(IndexNotFoundException e){
//            return null;
//        }
        return null;
    }
}
