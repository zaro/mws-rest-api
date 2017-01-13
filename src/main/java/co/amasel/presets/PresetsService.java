package co.amasel.presets;

import co.amasel.server.PluginShared;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.LoggerHandler;
import io.vertx.ext.web.handler.ResponseTimeHandler;

import java.util.Set;

/**
 * Created by zaro on 5/23/16.
 */
public class PresetsService extends AbstractVerticle {
    private final Logger logger = LoggerFactory.getLogger("PresetService");

    public PresetsService() {
    }

    @Override
    public void start(Future<Void> fut) {

        Router restAPI = Router.router(vertx);

        restAPI.route().handler(LoggerHandler.create());
        restAPI.route().handler(ResponseTimeHandler.create());

        restAPI.route().handler(BodyHandler.create());
        restAPI.post("/:presetName").handler(r->{
            JsonObject jsonRequest = r.getBodyAsJson();
            String preset = r.request().getParam("presetName");
            Future<Boolean> dbRecord = PresetDb.put(r.user(), preset, jsonRequest);
            dbRecord.setHandler( result -> {
                HttpServerResponse response = r.response();
                response.putHeader("Content-Type", "application/json");

                if( result.succeeded()) {
                    response.end("{\"result\": true}");
                } else {
                    response.end(new JsonObject().put("error", result.cause().getMessage()).encode());
                }
            });
        });

        restAPI.delete("/:presetName").handler(r->{
            String preset = r.request().getParam("presetName");

            Future<Boolean> dbRecord = PresetDb.delete(r.user(), preset);
            dbRecord.setHandler( result -> {
                HttpServerResponse response = r.response();
                response.putHeader("Content-Type", "application/json");

                if( result.succeeded()) {
                    response.end("{\"result\": true}");
                } else {
                    response.end(new JsonObject().put("error", result.cause().getMessage()).encode());
                }
            });
        });

        restAPI.get("/:presetName").handler(r->{
            String preset = r.request().getParam("presetName");

            Future<JsonObject> dbRecord = PresetDb.get(r.user(), preset);
            dbRecord.setHandler( result -> {
                HttpServerResponse response = r.response();
                response.putHeader("Content-Type", "application/json");

                if( result.succeeded()) {
                    JsonObject responseJson = new JsonObject();
                    responseJson.put("result", result.result());
                    response.end(responseJson.encode());
                } else {
                    response.end(new JsonObject().put("error", result.cause().getMessage()).encode());
                }
            });
        });

        restAPI.get("/").handler(r->{
            Future<Set<String>> presetsSet = PresetDb.listPresets(r.user());
            presetsSet.setHandler( presets -> {
                HttpServerResponse response = r.response();
                response.putHeader("Content-Type", "application/json");
                if(presets.succeeded()) {
                    JsonObject responseJson = new JsonObject();
                    JsonArray a = new JsonArray();
                    for (String k : presets.result()) {
                        a.add(k);
                    }
                    responseJson.put("result", a);
                    response.end(responseJson.encode());
                } else {
                    response.end(new JsonObject().put("error", presets.cause().getMessage()).encode());
                }
            });
        });


        PluginShared.getMainRouter().mountSubRouter("/presets", restAPI);

        logger.info("Start /presets/* service");

    }
}

