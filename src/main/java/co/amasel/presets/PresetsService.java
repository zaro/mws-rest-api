package co.amasel.presets;

import co.amasel.server.PluginShared;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
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
        EventBus eb = vertx.eventBus();

        eb.consumer("preset.new", message -> {
            Object omsg = message.body();
            logger.info("Received: " + omsg.toString());

            if( omsg instanceof JsonObject) {
                JsonObject msg = (JsonObject)omsg;
                String key  = (String) msg.remove("$preset.name$");
                PresetDb.put(key, msg);
            }
        });

        Router restAPI = Router.router(vertx);

        restAPI.route().handler(LoggerHandler.create());
        restAPI.route().handler(ResponseTimeHandler.create());

        restAPI.route().handler(BodyHandler.create());
        restAPI.post("/:presetName").handler(r->{
            JsonObject jsonRequest = r.getBodyAsJson();
            jsonRequest.put("$preset.name$", r.request().getParam("presetName"));
            eb.publish("preset.new", jsonRequest);
            r.response()
                    .putHeader("Content-Type", "application/json")
                    .end("{\"result\": true}");
        });

        restAPI.get("/:presetName").handler(r->{
            JsonObject dbRecord = PresetDb.get(r.request().getParam("presetName"));
            JsonObject response = new JsonObject();
            response.put("result", dbRecord);
            r.response()
                    .putHeader("Content-Type", "application/json")
                    .end(response.encode());
        });

        restAPI.get("/").handler(r->{
            Set<String> presets = PresetDb.listPresets();
            JsonObject response = new JsonObject();
            JsonArray a = new JsonArray();
            for( String k : presets){
                a.add(k);
            }
            response.put("result", a);
            r.response()
                    .putHeader("Content-Type", "application/json")
                    .end(response.encode());
        });


        PluginShared.getMainRouter().mountSubRouter("/presets", restAPI);

        logger.info("Start /presets/* service");

    }
}

