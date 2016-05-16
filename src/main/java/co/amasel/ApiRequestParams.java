package co.amasel;

import co.amasel.ApiRequestException;
import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;

import java.util.List;

/**
 * Created by zaro on 11/21/15.
 */
public class ApiRequestParams {
    public boolean xml ;
    public boolean full;
    public boolean meta;
    public boolean pretty;

    boolean getJsonBoolean(JsonObject params, String key, boolean defaultValue) throws ApiRequestException {
        if(params == null || !params.containsKey(key)){
            return defaultValue;
        }
        try {
            return params.getBoolean(key);
        } catch( java.lang.ClassCastException e) {
            throw  new ApiRequestException("Invalid value for parameter '"+key+"' : "+ params.getValue(key).toString() );
        }
    }

    boolean getQueryBoolean(MultiMap params, String key, boolean defaultValue) throws ApiRequestException{
        if(params == null || !params.contains(key)){
            return defaultValue;
        }
        List<String> values  = params.getAll(key);
        String value = values.get(values.size()-1);
        if(value.equals("true")) {
            return true;
        }else if(value.equals("false")) {
            return false;
        } else {
            throw  new ApiRequestException("Invalid value for parameter '"+key+"' : " + value);
        }
    }

    String getJsonString(JsonObject params, String key, String defaultValue) throws ApiRequestException{
        if(params == null || !params.containsKey(key)){
            return defaultValue;
        }
        try {
            return params.getString(key);
        } catch( java.lang.ClassCastException e) {
            throw  new ApiRequestException("Invalid value for parameter '"+key+"' : "+ params.getValue(key).toString() );
        }
    }

    String getQueryString(MultiMap params, String key, String defaultValue) throws ApiRequestException{
        if(params == null || !params.contains(key)){
            return defaultValue;
        }
        List<String> values  = params.getAll(key);
        return values.get(values.size()-1);
    }


    boolean getBoolean(JsonObject params, MultiMap query, String key, boolean defaultValue) throws ApiRequestException {
        return getQueryBoolean(query, key, getJsonBoolean(params, key, defaultValue));
    }

    String getString(JsonObject params, MultiMap query, String key, String defaultValue) throws ApiRequestException {
        return getQueryString(query, key, getJsonString(params, key, defaultValue));
    }

    public ApiRequestParams(MultiMap query, JsonObject params)  throws ApiRequestException {
        xml = getBoolean(params, query,  "xml", false);
        full = getBoolean(params, query,  "full", false);
        meta = getBoolean(params, query,  "meta", false);
        pretty = getBoolean(params, query,  "pretty", false);
    }
}
