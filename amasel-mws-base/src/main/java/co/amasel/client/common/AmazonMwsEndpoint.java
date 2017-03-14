package co.amasel.client.common;

import com.amazonservices.mws.client.MwsEndpoints;

import java.net.URI;
import java.util.HashMap;

/**
 * Created by zaro on 5/27/16.
 */
public class AmazonMwsEndpoint extends MwsEndpoints {
    static HashMap<String, URI> tagMap= new HashMap();
    static {
        tagMap.put("de", DE_PROD);
        tagMap.put("es", ES_PROD);
        tagMap.put("eu", EU_PROD);
        tagMap.put("fr", FR_PROD);
        tagMap.put("it", IT_PROD);
        tagMap.put("uk", UK_PROD);

        tagMap.put("cn", CN_PROD);
        tagMap.put("jp", JP_PROD);
        tagMap.put("in", IN_PROD);

        tagMap.put("na", NA_PROD);
        tagMap.put("us", NA_PROD);
        tagMap.put("mx", NA_PROD);
        tagMap.put("ca", NA_PROD);

    }
    public static String get(String tagOrURL){
        URI u = tagMap.get(tagOrURL.toLowerCase());
        if (u != null){
            return u.toString();
        }
        return tagOrURL;
    }

    public static String getEndpointEncoding(String tagOrURL){
        URI u = tagMap.get(tagOrURL.toLowerCase());
        if (u != null){
            tagOrURL = u.toString();
        }
        if(tagOrURL.endsWith(".com.cn")) {
            return "utf-8";
        }
        if(tagOrURL.endsWith(".jp")) {
            return "Shift_JIS";
        }
        return "iso-8859-1";
    }

}
