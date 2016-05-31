package co.amasel.presets;

import io.vertx.core.json.JsonObject;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by zaro on 5/23/16.
 */
public class PresetDb {

    static ConcurrentMap<String, String> map = null;
    static DB db = null;

    static public void init(String path) {
        db = DBMaker.fileDB(path).make();
        map = db.hashMap("presets", Serializer.STRING, Serializer.STRING).make();
    }


    static public JsonObject get(String key){
        String value = map.get(key);
        if( value == null){
            return null;
        }
        return new JsonObject(value);
    }


    static public JsonObject getAsDefaults(String key, JsonObject value){
        JsonObject preset = get(key);
        if(preset != null){
            if(value == null){
                return preset;
            }
            Iterator it = preset.iterator();
            while(it.hasNext()){
                Map.Entry<String, Object> kv = (Map.Entry<String, Object>) it.next();
                if(!value.containsKey(kv.getKey())){
                    value.put(kv.getKey(), kv.getValue());
                }
            }
        }
        return value;
    }

    static public void put(String key, JsonObject value){
        map.put(key, value.encode());
        db.commit();
    }

    static public Set<String> listPresets(){
        return map.keySet();
    }
}
