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
            Future<Boolean> dbRecord = PresetDb.put(r.request().getParam("presetName"), jsonRequest);
            dbRecord.setHandler( preset -> {
                HttpServerResponse response = r.response();
                response.putHeader("Content-Type", "application/json");

                if( preset.succeeded()) {
                    response.end("{\"result\": true}");
                } else {
                    response.end(new JsonObject().put("error", preset.cause().getMessage()).encode());
                }
            });
        });

        restAPI.delete("/:presetName").handler(r->{
            Future<Boolean> dbRecord = PresetDb.delete(r.request().getParam("presetName"));
            dbRecord.setHandler( preset -> {
                HttpServerResponse response = r.response();
                response.putHeader("Content-Type", "application/json");

                if( preset.succeeded()) {
                    response.end("{\"result\": true}");
                } else {
                    response.end(new JsonObject().put("error", preset.cause().getMessage()).encode());
                }
            });
        });

        restAPI.get("/:presetName").handler(r->{
            Future<JsonObject> dbRecord = PresetDb.get(r.request().getParam("presetName"));
            dbRecord.setHandler( preset -> {
                HttpServerResponse response = r.response();
                response.putHeader("Content-Type", "application/json");

                if( preset.succeeded()) {
                    JsonObject responseJson = new JsonObject();
                    responseJson.put("result", preset.result());
                    response.end(responseJson.encode());
                } else {
                    response.end(new JsonObject().put("error", preset.cause().getMessage()).encode());
                }
            });
        });

        restAPI.get("/").handler(r->{
            Future<Set<String>> presetsSet = PresetDb.listPresets();
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

