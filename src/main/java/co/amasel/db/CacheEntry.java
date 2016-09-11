package co.amasel.db;

import io.vertx.core.json.JsonObject;

import java.util.Map;

/**
 * Created by zaro on 6/5/16.
 */
public class CacheEntry {
    public JsonObject obj;
    public String content;
    public CacheEntryTag ce;

    public CacheEntry(CacheEntryTag ce, JsonObject obj) {
        this.ce = ce;
        this.obj = obj;
    }

    public CacheEntry(CacheEntryTag ce, String content) {
        this.ce = ce;
        this.content = content;
    }

    public CacheEntry(CacheEntryTag ce, Map<String, Object> obj) {
        this.ce = ce;
        this.obj = new JsonObject(obj);
    }

    public JsonObject toJsonObject() {
        JsonObject r = ce.newRecord();
        if (obj != null) {
            r.put("obj", obj);
        }
        if (content != null) {
            r.put("content", content);
        }
        return r;
    }

    public Map<String, Object> toRecord() {
        return toJsonObject().getMap();
    }
}
