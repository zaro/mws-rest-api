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
        tagMap.put("cn", CN_PROD);
        tagMap.put("de", DE_PROD);
        tagMap.put("es", ES_PROD);
        tagMap.put("eu", EU_PROD);
        tagMap.put("fr", FR_PROD);
        tagMap.put("in", IN_PROD);
        tagMap.put("it", IT_PROD);
        tagMap.put("jp", JP_PROD);
        tagMap.put("na", NA_PROD);
        tagMap.put("uk", UK_PROD);
    }
    public static String get(String tagOrURL){
        URI u = tagMap.get(tagOrURL.toLowerCase());
        if (u != null){
            return u.toString();
        }
        return tagOrURL;
    }

}
