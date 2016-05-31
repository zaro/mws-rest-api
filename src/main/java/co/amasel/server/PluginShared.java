package co.amasel.server;

import io.vertx.ext.web.Router;

/**
 * Created by zaro on 5/31/16.
 */
public class PluginShared {

    static PluginShared instance = new PluginShared();

    Router mainRouter;
    public static void setMainRouter(Router mainRouter){
        instance.mainRouter = mainRouter;
    }
    public static Router getMainRouter(){
        return instance.mainRouter;
    }
}
