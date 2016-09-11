package co.amasel.db;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zaro on 6/5/16.
 */
public class CacheEntryTag {
    public String tag;
    public String tagId;
    public String ttl;
    public String expiry;
    public String error;
    public int numEntries = 0;

    protected static byte[] bool0= {'b','o','o', 0};
    protected static byte[] bool1= {'b','o','o', 1};
    protected static void digestObject(MessageDigest digest, Object object){
        if (object == null) {
        } else if( object instanceof JsonObject) {
            SortedSet<String> keys = new TreeSet<>(((JsonObject)object).getMap().keySet());
            for(String key: keys){
                digest.update(key.getBytes());
                digestObject(digest, ((JsonObject)object).getValue(key) );
            }
        } else if(object instanceof Map<?,?>) {
            SortedSet<String> keys = new TreeSet<>( ((Map)object).keySet() );
            for(String key: keys){
                digest.update(key.getBytes());
                digestObject(digest, ((Map)object).get(key) );
            }
        } else if(object instanceof JsonArray) {
            for(Object element: ((JsonArray)object)){
                digestObject(digest, element);
            }
        } else if(object instanceof List<?>) {
            for(Object element: ((List)object)){
                digestObject(digest, element);
            }
        } else if(object instanceof Boolean){
            digest.update( ((Boolean)object) ? bool1 : bool0 );
        } else if(object instanceof Number){
            double d = ((Number)object).doubleValue();
            byte[] ba = new byte[8];
            long lng = Double.doubleToLongBits(d);
            for(int i = 0; i < 8; i++) ba[i] = (byte)((lng >> ((7 - i) * 8)) & 0xff);
            digest.update( ba );
        } else if(object instanceof String){
            digest.update( ((String)object).getBytes() );
        } else if(object instanceof byte[]){
            digest.update( (byte[])object );
        } else{
            digest.update( object.toString().getBytes() );
        }
    }
    public static String jsonObjectHash(JsonObject obj){
        MessageDigest md5Calc = null;
        try {
            md5Calc = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return  "WTF[NO MD5]";
        }
        digestObject(md5Calc, obj);
        return Base64.getEncoder().encodeToString(md5Calc.digest());
    }



    public CacheEntryTag(JsonObject obj, String ttl){
        this(jsonObjectHash(obj), ttl);
    }
    public CacheEntryTag(JsonObject obj){
        this(jsonObjectHash(obj), null);
    }

    public CacheEntryTag(String tag, String ttl) {
        this.tag = tag;
        this.ttl = ttl;
        calcExpiry(LocalDateTime.now().atZone(ZoneOffset.UTC));
    }

    public CacheEntryTag copy() {
        CacheEntryTag t = new CacheEntryTag(tag, ttl);
        t.tagId = tagId;
        t.expiry = expiry;
        t.error = error;
        t.numEntries = numEntries;
        return t;
    }

    public String getTagId() {
        if (tagId != null) {
            return tagId;
        }
        return tagId = RandomStringUtils.randomAscii(6);
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public void setNumEntries(int numEntries) {
        this.numEntries = numEntries;
    }

    public void addNumEntries(int numEntries) {
        this.numEntries += numEntries;
    }

    static Pattern pattern = Pattern.compile("^\\s*(\\d+)(ms|s|m|h|d|w|M|y)\\s*$");

    public void calcExpiry(ZonedDateTime now) {
        Duration d = Duration.ofMillis(0);
        if (ttl == null) {
            ttl = "30m";
        }
        Matcher m = pattern.matcher(ttl);
        while (m.find()) {
            int val = Integer.valueOf(m.group(1));
            switch (m.group(2).toLowerCase().charAt(0)) {
                case 'd':
                    d = d.plusDays(val);
                    break;
                case 'h':
                    d = d.plusHours(val);
                    break;
                case 'm':
                    d = d.plusMinutes(val);
                    break;
                case 's':
                    d = d.plusSeconds(val);
                    break;
                default:
                    break;
            }
        }
        if (d.isZero()) {
            d = Duration.ofMinutes(30);
        }
        expiry = now.plus(d).toString();
    }

    Map<String, Object> toBeginRecord() {
        JsonObject r = new JsonObject();
        r.put("tag", tag);
        r.put("tagId", getTagId());
        r.put("expiry", expiry);
        r.put("ts", LocalDateTime.now().atZone(ZoneOffset.UTC).toString());
        return r.getMap();
    }

    Map<String, Object> toEndRecord() {
        JsonObject r = new JsonObject();
        r.put("tag", tag);
        r.put("tagId", getTagId());
        r.put("expiry", expiry);
        r.put("numEntries", numEntries);
        r.put("ts", LocalDateTime.now().atZone(ZoneOffset.UTC).toString());
        r.put("hasError", error != null);
        if (error != null) {
            r.put("error", error);
        }
        return r.getMap();
    }

    CacheEntry newCacheEntry(JsonObject obj) {
        return new CacheEntry(this, obj);
    }

    CacheEntry newCacheEntry(String content) {
        return new CacheEntry(this, content);
    }

    JsonObject newRecord() {
        JsonObject r = new JsonObject();
        r.put("tag", tag);
        r.put("tagId", getTagId());
        r.put("expiry", expiry);
        return r;
    }
}
