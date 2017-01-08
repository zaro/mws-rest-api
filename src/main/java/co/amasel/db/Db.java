package co.amasel.db;

import co.amasel.misc.RuntimeConfiguration;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.search.SearchHit;

import java.util.Map;
import java.util.Vector;

/**
 * Created by zaro on 6/3/16.
 */
public class Db {
    public static final String RECORD_TYPE = "record";
    static protected Node server;
    static protected Client client;

    public static void start() {
//        final Settings.Builder builder = Settings.settingsBuilder();
//        builder.put("node.name" , "mws-rest-api");
//        builder.put("path.home", RuntimeConfiguration.getAppDir() + "db" );
//        builder.put("http.enabled", true);
//        server = nodeBuilder().settings(builder).local(true).data(true).node();
//        client = server.client();
//        CacheDb.createCacheTemplate();
    }

    public static void stop() {
//        if(server != null){
//            server.close();
//        }
    }

}
