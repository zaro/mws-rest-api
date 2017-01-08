import co.amasel.MwsAsyncHandler;
import co.amasel.client.common.AmaselCachedClient;
import co.amasel.client.common.AmaselClient;
import co.amasel.db.Db;
import co.amasel.misc.RuntimeConfiguration;
import co.amasel.presets.PresetDb;
import co.amasel.presets.PresetsService;
import co.amasel.server.PluginShared;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.net.PemKeyCertOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.LoggerHandler;
import io.vertx.ext.web.handler.ResponseTimeHandler;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zaro on 11/21/15.
 */
public class MwsRestApiMain {
    static final Logger logger = LoggerFactory.getLogger("MwsRestApiMain");

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static void main(String[] args){
        System.out.println(RuntimeConfiguration.getAppDir());
        VertxOptions options = new VertxOptions();
        options.setBlockedThreadCheckInterval(1000*60*60);

        Vertx vertx = Vertx.vertx(options);

        Db.start();
        PresetDb.init(vertx, "presets.db");

        PluginShared.setMainRouter( Router.router(vertx) );
        DeploymentOptions deploymentOptions = new DeploymentOptions();

        //vertx.deployVerticle(new MwsTest(), new DeploymentOptions());
        vertx.deployVerticle(new MwsAsyncHandler<>("/mws"), deploymentOptions);
        vertx.deployVerticle(new MwsAsyncHandler<AmaselCachedClient>("/mws.cached"), deploymentOptions);
        vertx.deployVerticle(new PresetsService(), deploymentOptions);

        File pluginsDir = new File(RuntimeConfiguration.getAppDir(), "plugins");
        logger.info("Loading plugins in: " + pluginsDir.getPath());
        File[] pluginList = pluginsDir.listFiles();
        if( pluginList != null) {
            for (File file : pluginList) {
                if (FilenameUtils.isExtension(file.getName(), new String[]{"js", "rb", "groovy"})) {
                    logger.info("Starting : " + file.getAbsolutePath());
                    vertx.deployVerticle(file.getAbsolutePath(), deploymentOptions);
                }
            }
        }

        logger.debug("Config:" + RuntimeConfiguration.loadConfig().encodePrettily());

        HttpServerOptions httpServOptions = new HttpServerOptions();

        String sslCertFile = RuntimeConfiguration.getSslCertFile();
        String sslKeyFile  = RuntimeConfiguration.getSslKeyFile();
        if( sslCertFile != null && !sslCertFile.isEmpty() && sslKeyFile != null && !sslKeyFile.isEmpty()){
            logger.info("Using ssl.");
            httpServOptions.setSsl(true).setPemKeyCertOptions(
                    new PemKeyCertOptions().
                            setKeyPath(sslKeyFile).
                            setCertPath(sslCertFile)
            );
        }


        HttpServer serv = vertx.createHttpServer(httpServOptions);

        int port = RuntimeConfiguration.getPort();
        String host = RuntimeConfiguration.getHost();
        serv.requestHandler(PluginShared.getMainRouter()::accept)
                .listen(port, host);

        logger.info("Listening at http" +
                (httpServOptions.isSsl() ? "s" : "") +
                "://" + host + ":" + String.valueOf(port) + "/"
        );


    }
}
