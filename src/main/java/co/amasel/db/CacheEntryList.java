package co.amasel.db;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.search.SearchHit;

import java.util.Map;
import java.util.Vector;

/**
 * Created by zaro on 6/5/16.
 */
public class CacheEntryList extends Vector<CacheEntry> {
    boolean hasError = false;
    CacheEntryTag ceTag;
    String tsBegin;
    String tsEnd;

    public boolean hasMore() {
        return size() < ceTag.numEntries;
    }

    public String expiry() {
        return ceTag.expiry;
    }

    public String tagId() {
        return ceTag.tagId;
    }

    public CacheEntryList(CacheEntryTag ceTag) {
        this.ceTag = ceTag;
    }

    public void addGetResponse(GetResponse response) {
        if (response == null) {
        } else if (response.getType().equals("begin")) {
            addBeginRecord(response.getSource());
        } else if (response.getType().equals("end")) {
            addEndRecord(response.getSource());
        } else if (response.getType().equals(Db.RECORD_TYPE)) {
            add(new CacheEntry(ceTag, response.getSource()));
        } else {
            throw new RuntimeException("Unknown cache record type: " + response.getType());
        }
    }

    public void addSearchHit(SearchHit response) {
        if (response == null) {
        } else if (response.getType().equals("begin")) {
            addBeginRecord(response.getSource());
        } else if (response.getType().equals("end")) {
            addEndRecord(response.getSource());
        } else if (response.getType().equals(Db.RECORD_TYPE)) {
            add(new CacheEntry(ceTag, response.getSource()));
        } else {
            throw new RuntimeException("Unknown cache record type: " + response.getType());
        }
    }

    private void addBeginRecord(Map<String, Object> doc) {
        ceTag.expiry = (String) doc.get("expiry");
        tsBegin = (String) doc.get("ts");
        ceTag.tagId = (String) doc.get("tagId");
    }

    private void addEndRecord(Map<String, Object> doc) {
        tsEnd = (String) doc.get("ts");
        ceTag.expiry = (String) doc.get("expiry");
        ceTag.error = (String) doc.get("error");
        ceTag.numEntries = (int) doc.get("numEntries");
        hasError = (boolean) doc.getOrDefault("hasError", false);
    }


}
