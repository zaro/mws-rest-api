import co.amasel.db.CacheDb
import co.amasel.db.CacheEntryTag
import co.amasel.db.CacheEntry
import co.amasel.db.CacheEntryList
import io.vertx.core.json.JsonObject
import io.vertx.groovy.ext.unit.TestSuite

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.ZonedDateTime

def suite = TestSuite.create("co.amasel.db.DbCache")



suite.before({ context ->
    CacheDb.start();
    context.sleep(1000)
})

suite.after({ context ->
    //context.sleep(1000 *1000)
    CacheDb.stop();

})
suite.test("testValidityString", { context ->
    CacheEntryTag ce;
    ZonedDateTime now = LocalDateTime.now().atZone(ZoneOffset.UTC);

    ce = new CacheEntryTag("testCache", "5s");
    ce.calcExpiry(now);
    context.assertEquals(now.plusSeconds(5).toString(), ce.expiry, "Seconds");

    ce = new CacheEntryTag("testCache", "5m");
    ce.calcExpiry(now);
    context.assertEquals(now.plusMinutes(5).toString(), ce.expiry, "Minutes");

    ce = new CacheEntryTag("testCache", "5h");
    ce.calcExpiry(now);
    context.assertEquals(now.plusHours(5).toString(), ce.expiry, "Hours");

    ce = new CacheEntryTag("testCache", "5d");
    ce.calcExpiry(now);
    context.assertEquals(now.plusDays(5).toString(), ce.expiry, "Days");
});

suite.test("testCacheTag", { context ->
    CacheEntryTag ce;
    ZonedDateTime now = LocalDateTime.now().atZone(ZoneOffset.UTC);

    context.assertEquals(new CacheEntryTag(new JsonObject("{}")).tag, new CacheEntryTag(new JsonObject()).tag)
    context.assertEquals(new CacheEntryTag(new JsonObject("{\"a\":1, \"b\":2}")).tag, new CacheEntryTag(new JsonObject("{\"b\":2, \"a\":1}")).tag)
    context.assertNotEquals(new CacheEntryTag(new JsonObject("{\"a\":2}")).tag, new CacheEntryTag(new JsonObject("{\"a\":\"2\"}")).tag)
});

def makeCacheEntryList (CacheEntryTag ce, int numEntries) {
    Set<String> expected = new HashSet<>();
    List<CacheEntry> e = new Vector<>();
    for(int i=0; i<numEntries; ++i){
        String c = "c" + i;
        expected.add(c);
        e.add( ce.newCacheEntry(c));
    }
    return [e, expected];
}


suite.test("testCacheExpiration", { context ->
    CacheEntryTag ce = new CacheEntryTag("testCache", "5s");

    def (list, expected) = makeCacheEntryList(ce, 200)

    context.assertTrue( CacheDb.storeCacheResult(ce, list) );
    CacheEntryList cacheList = CacheDb.loadCacheResult(ce);

    int timeOut = 10000;
    long now = System.currentTimeMillis();
    while(timeOut >=0 && (cacheList==null || cacheList.hasMore())){
        cacheList = CacheDb.loadCacheResult(ce);
        context.sleep(200)
        timeOut -= 200
    }
    context.println("Loading took: "+(System.currentTimeMillis()-now) + "ms")
    context.assertTrue(timeOut>=0, "Timeout loading from cache");

    context.assertEquals(list.size(),cacheList.size())

    println "---------------------------------------------------"
    for(CacheEntry o: cacheList){
        String c = o.obj.getString("content");
        expected.remove(c);
    }
    context.assertTrue(expected.isEmpty(), "Missing elements in cached set:" + expected)
    context.sleep(5000);
    context.assertEquals(null, CacheDb.loadCacheResult(ce))
});


suite.test("testCacheLargeList", { context ->
    CacheEntryTag ce = new CacheEntryTag("testCache", "5m");

    def (list, expected) = makeCacheEntryList(ce, 200000)

    context.assertTrue( CacheDb.storeCacheResult(ce, list) );
    CacheEntryList cacheList = CacheDb.loadCacheResult(ce);

    int timeOut = 10000;
    long now = System.currentTimeMillis();
    while(timeOut >=0 && (cacheList==null || cacheList.hasMore())){
        cacheList = CacheDb.loadCacheResult(ce);
        context.sleep(200)
        timeOut -= 200
    }
    context.println("Loading took: "+(System.currentTimeMillis()-now) + "ms")
    context.assertTrue(timeOut>=0, "Timeout loading from cache");
    context.assertEquals(list.size(),cacheList.size())

    println "---------------------------------------------------"
    for(CacheEntry o: cacheList){
        String c = o.obj.getString("content");
        expected.remove(c);
    }
    context.assertTrue(expected.isEmpty(), "Missing elements in cached set:" + expected)
});

suite.run([
        reporters: [
                [ to: "console" ]
        ]
]).handler({ ar ->
    System.exit( ar.succeeded() ? 0 : -1)
})