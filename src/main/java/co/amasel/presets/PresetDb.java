package co.amasel.presets;

import io.vertx.ext.auth.User;
import co.amasel.misc.RuntimeConfiguration;
//import com.google.common.util.concurrent.FutureFallback;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLConnection;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by zaro on 5/23/16.
 */
public class PresetDb {
    static private final Logger logger = LoggerFactory.getLogger("PresetDb");

    static JDBCClient client;

    static ConcurrentMap<String, String> map = null;

    static public Future<Boolean> init(Vertx vertx, String path) {
        final Future<Boolean> result =  Future.future();
        String jdbcUrl = "jdbc:h2:"  + RuntimeConfiguration.getAppDir() + "db/" + path;
        client = JDBCClient.createShared(vertx,
                new JsonObject()
                .put("url", jdbcUrl)
                .put("driver_class", "org.h2.Driver")
                .put("max_pool_size", 30),
                "Presets");
        client.getConnection(conn -> {
            if (conn.failed()) {
                logger.error(conn.cause().getMessage());
                result.fail(conn.cause().getMessage());
                return;
            }
            final SQLConnection connection = conn.result();
            final List<String> statements = Arrays.asList(
                    "CREATE TABLE IF NOT EXISTS preset_config(user VARCHAR(255), key VARCHAR(255), value CLOB,  PRIMARY KEY(user, key));"
            );
            connection.batch(statements, res -> {
                if (res.failed()) {
                    logger.error(res.cause().getMessage());
                    result.fail(res.cause().getMessage());
                    return;
                }
                result.complete(true);
             });
        });
        return result;
    }

    static public String username(User user) {
        return user.principal().getString("user");
    }

    static public Future<JsonObject> get(User user, String key){
        if( user == null ){
            return Future.failedFuture("Invalid user");
        }
        String username = username(user);
        final Future<JsonObject> result =  Future.future();
        client.getConnection(conn -> {
            if (conn.failed()) {
                logger.error(conn.cause().getMessage());
                result.fail(conn.cause().getMessage());
                return;
            }
            final SQLConnection connection = conn.result();
            logger.info("get('" + key + "')");
            connection.queryWithParams("SELECT value FROM preset_config WHERE key = ? AND user = ?", new JsonArray().add(key).add(username), rs -> {
                if (rs.failed()) {
                    logger.error("Cannot retrieve the data from the database: " + rs.cause().getMessage());
                    result.fail(rs.cause().getMessage());
                    return;
                }

                if(rs.result().getResults().size() > 0) {
                    result.complete(new JsonObject(rs.result().getResults().get(0).getString(0)));
                } else {
                    result.complete();
                }
                // and close the connection
                connection.close(done -> {
                    if (done.failed()) {
                        logger.error("Cannot close connection to the database: " + rs.cause().getMessage());
                    }
                });
            });
        });

        return result;
    }


    static public Future<JsonObject> getAsDefaults(User user, String key, JsonObject value){
        final Future<JsonObject> result =  Future.future();
        Future<JsonObject> presetFuture = get(user, key);
        presetFuture.setHandler(preset ->{
            if(preset.succeeded()){
                if(value == null){
                    result.complete(preset.result());
                    return;
                }
                JsonObject presetObject = preset.result();
                if (presetObject == null) {
                    result.fail("Preset '" + key + "' now found!");
                    return;
                }
                Iterator it = presetObject.iterator();
                while(it.hasNext()){
                    Map.Entry<String, Object> kv = (Map.Entry<String, Object>) it.next();
                    if(!value.containsKey(kv.getKey())){
                        value.put(kv.getKey(), kv.getValue());
                    }
                }
                result.complete(value);
            } else {
                result.fail(preset.cause().getMessage());
            }
        });
        return result;
    }

    static public Future<Boolean> put(User user, String key, JsonObject value){
        if( user == null ){
            return Future.failedFuture("Invalid user");
        }
        String username = username(user);

        final Future<Boolean> result =  Future.future();
        client.getConnection(conn -> {
            if (conn.failed()) {
                logger.error(conn.cause().getMessage());
                result.fail(conn.cause().getMessage());
                return;
            }
            final SQLConnection connection = conn.result();
            JsonArray params = new JsonArray();
            params.add(username);
            params.add(key);
            params.add(value.encode());
            connection.updateWithParams("MERGE INTO preset_config VALUES (?,?,?)", params, rs -> {
                if (rs.failed()) {
                    logger.error("Cannot retrieve the data from the database: " + rs.cause().getMessage());
                    result.fail(rs.cause().getMessage());
                    return;
                }

                result.complete(true);
                // and close the connection
                connection.close(done -> {
                    if (done.failed()) {
                        logger.error("Cannot close connection to the database: " + rs.cause().getMessage());
                    }
                });
            });
        });

        return result;
    }

    static public Future<Boolean> delete(User user, String key){
        if( user == null ){
            return Future.failedFuture("Invalid user");
        }
        String username = username(user);

        final Future<Boolean> result =  Future.future();
        client.getConnection(conn -> {
            if (conn.failed()) {
                logger.error(conn.cause().getMessage());
                result.fail(conn.cause().getMessage());
                return;
            }
            final SQLConnection connection = conn.result();
            connection.updateWithParams("DELETE FROM preset_config WHERE user = ? AND key = ?", new JsonArray().add(username).add(key), rs -> {
                if (rs.failed()) {
                    logger.error("Cannot delete the data from the database: " + rs.cause().getMessage());
                    result.fail(rs.cause().getMessage());
                    return;
                }

                result.complete(true);
                // and close the connection
                connection.close(done -> {
                    if (done.failed()) {
                        logger.error("Cannot close connection to the database: " + rs.cause().getMessage());
                    }
                });
            });
        });

        return result;

    }

    static public Future<Set<String>> listPresets(User user) {
        if( user == null ){
            return Future.failedFuture("Invalid user");
        }
        String username = username(user);

        final Future<Set<String>> result = Future.future();
        client.getConnection(conn -> {
            if (conn.failed()) {
                logger.error(conn.cause().getMessage());
                result.fail(conn.cause().getMessage());
                return;
            }
            final SQLConnection connection = conn.result();
            connection.queryWithParams("SELECT key FROM preset_config WHERE user = ?", new JsonArray().add(username), rs -> {
                if (rs.failed()) {
                    logger.error("Cannot retrieve the data from the database: " + rs.cause().getMessage());
                    result.fail(rs.cause().getMessage());
                    return;
                }
                Set<String> keys = new HashSet<String>();
                for (JsonArray line : rs.result().getResults()) {
                    keys.add(line.getString(0));
                }
                result.complete(keys);
                // and close the connection
                connection.close(done -> {
                    if (done.failed()) {
                        logger.error("Cannot close connection to the database: " + rs.cause().getMessage());
                    }
                });
            });
        });

        return result;
    }
}
