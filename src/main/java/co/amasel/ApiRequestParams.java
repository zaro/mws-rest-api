package co.amasel;

import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;

import java.util.List;

/**
 * Created by zaro on 11/21/15.
 */
public class ApiRequestParams {
    public boolean xml ;
    public boolean full;
    public boolean raw;
    public boolean meta;
    public boolean pretty;
    public boolean numbers;
    public String preset;
    public String awsAccessKey;
    public String awsSecretKey;
    public String endPoint;
    public String userAgent;

    public static boolean getJsonBoolean(JsonObject params, String key, boolean defaultValue) throws ApiRequestException {
        if(params == null || !params.containsKey(key)){
            return defaultValue;
        }
        try {
            return params.getBoolean(key);
        } catch( java.lang.ClassCastException e) {
            throw  new ApiRequestException("Invalid value for parameter '"+key+"' : "+ params.getValue(key).toString() );
        }
    }

    public static boolean getQueryBoolean(MultiMap params, String key, boolean defaultValue) throws ApiRequestException{
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
            return true;
        }
    }

    public static String getJsonString(JsonObject params, String key, String defaultValue) throws ApiRequestException{
        if(params == null || !params.containsKey(key)){
            return defaultValue;
        }
        try {
            return params.getString(key);
        } catch( java.lang.ClassCastException e) {
            throw  new ApiRequestException("Invalid value for parameter '"+key+"' : "+ params.getValue(key).toString() );
        }
    }

    public static String getQueryString(MultiMap params, String key, String defaultValue) throws ApiRequestException{
        if(params == null || !params.contains(key)){
            return defaultValue;
        }
        List<String> values  = params.getAll(key);
        return values.get(values.size()-1);
    }


    public static boolean getBoolean(JsonObject params, MultiMap query, String key, boolean defaultValue) throws ApiRequestException {
        return getQueryBoolean(query, key, getJsonBoolean(params, "_" + key, defaultValue));
    }

    public static String getString(JsonObject params, MultiMap query, String key, String defaultValue) throws ApiRequestException {
        return getQueryString(query, key, getJsonString(params, "_" + key, defaultValue));
    }

    public ApiRequestParams(MultiMap query, JsonObject params)  throws ApiRequestException {
        xml = getBoolean(params, query,  "xml", false);
        full = getBoolean(params, query,  "full", false);
        raw = getBoolean(params, query,  "raw", false);
        meta = getBoolean(params, query,  "meta", false);
        pretty = getBoolean(params, query,  "pretty", false);
        numbers = getBoolean(params, query,  "numbers", true);
        preset = getString(params, query, "preset", "default");
        awsAccessKey = getString(params, query, "awsAccessKey", null);
        awsSecretKey = getString(params, query, "awsSecretKey", null);
        endPoint = getString(params, query, "endPoint", "uk");
        userAgent = getString(params, query, "userAgent", null);
    }

}
