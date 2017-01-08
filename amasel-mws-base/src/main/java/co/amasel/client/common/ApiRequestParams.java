package co.amasel.client.common;

import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;

import java.util.List;

/**
 * Created by zaro on 11/21/15.
 */
public class ApiRequestParams {
    final JsonObject postedParams;
    final MultiMap queryParams;

    public boolean xml ;
    public boolean full;
    public boolean raw;
    public boolean meta;
    public boolean pretty;
    public boolean numbers;
    public boolean asDict;
    public String preset;
    public String awsAccessKey;
    public String awsSecretKey;
    public String endPoint;
    public String userAgent;

    public boolean getJsonBoolean(String key, boolean defaultValue) throws AmaselClientException {
        if(postedParams == null || !postedParams.containsKey(key)){
            return defaultValue;
        }
        try {
            return postedParams.getBoolean(key);
        } catch( ClassCastException e) {
            throw  new AmaselClientException("Invalid value for parameter '"+key+"' : "+ postedParams.getValue(key).toString() );
        }
    }

    public boolean getQueryBoolean(String key, boolean defaultValue) throws AmaselClientException{
        if(queryParams == null || !queryParams.contains(key)){
            return defaultValue;
        }
        List<String> values  = queryParams.getAll(key);
        String value = values.get(values.size()-1);
        if(value.equals("true")) {
            return true;
        }else if(value.equals("false")) {
            return false;
        } else {
            return true;
        }
    }

    public String getJsonString(String key, String defaultValue) throws AmaselClientException{
        if(postedParams == null || !postedParams.containsKey(key)){
            return defaultValue;
        }
        try {
            return postedParams.getString(key);
        } catch( ClassCastException e) {
            throw  new AmaselClientException("Invalid value for parameter '"+key+"' : "+ postedParams.getValue(key).toString() );
        }
    }

    public String getQueryString(String key, String defaultValue) throws AmaselClientException{
        if(queryParams == null || !queryParams.contains(key)){
            return defaultValue;
        }
        List<String> values  = queryParams.getAll(key);
        return values.get(values.size()-1);
    }

    public static String getQueryString(MultiMap queryParams, String key, String defaultValue) throws AmaselClientException{
        if(queryParams == null || !queryParams.contains(key)){
            return defaultValue;
        }
        List<String> values  = queryParams.getAll(key);
        return values.get(values.size()-1);
    }


    public boolean getBoolean(String key, boolean defaultValue) throws AmaselClientException {
        return getQueryBoolean(key, getJsonBoolean("_" + key, defaultValue));
    }

    public String getString(String key, String defaultValue) throws AmaselClientException {
        return getQueryString(key, getJsonString("_" + key, defaultValue));
    }

    public ApiRequestParams(MultiMap query, JsonObject params)  throws AmaselClientException {
        queryParams = query;
        postedParams = params;
        xml = getBoolean("xml", false);
        full = getBoolean("full", false);
        raw = getBoolean("raw", false);
        meta = getBoolean("meta", false);
        pretty = getBoolean("pretty", false);
        numbers = getBoolean("numbers", true);
        asDict = getBoolean("asDict", true);
        preset = getString("preset", "default");
        awsAccessKey = getString("awsAccessKey", null);
        awsSecretKey = getString("awsSecretKey", null);
        endPoint = getString("endPoint", "uk");
        userAgent = getString("userAgent", null);
    }

}
