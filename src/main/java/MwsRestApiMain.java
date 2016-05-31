import co.amasel.MwsAsyncHandler;
import co.amasel.misc.RuntimeConfiguration;
import co.amasel.presets.PresetDb;
import co.amasel.presets.PresetsService;
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


        PresetDb.init("presets.db");

        Vertx vertx = Vertx.vertx(options);

        Router mainRouter  = Router.router(vertx);

        Verticle myVerticle = new MwsTest();
        Verticle myAVerticle = new MwsAsyncHandler(mainRouter);
        //vertx.deployVerticle(myVerticle, new DeploymentOptions());
        vertx.deployVerticle(myAVerticle, new DeploymentOptions());
        vertx.deployVerticle(new PresetsService(mainRouter));


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
        serv.requestHandler(mainRouter::accept)
                .listen(port, host);

        logger.info("Listening at http" +
                (httpServOptions.isSsl() ? "s" : "") +
                "://" + host + ":" + String.valueOf(port) + "/"
        );


//        if(true) return;
//        String theString = convertStreamToString(
//                ClassLoader.getSystemResourceAsStream("mock/UpdateReportAcknowledgementsResponse.xml"));
//
//
//
//        ObjectMapper xmlMapper = new XmlMapper();
//        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
//        // if ONLY using JAXB annotations:
//        xmlMapper.setAnnotationIntrospector(introspector);
//
//        long startTime = System.currentTimeMillis();
//        UpdateReportAcknowledgementsResponse r = null;
//        try {
//            r = xmlMapper.readValue(theString, UpdateReportAcknowledgementsResponse.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        long stopTime = System.currentTimeMillis();
//        long elapsedTime = stopTime - startTime;
//        System.out.println(elapsedTime);
//
//        //GetCompetitivePricingForASINResponse r  =Json.decodeValue(theString, GetCompetitivePricingForASINResponse.class);
//        System.out.println(r);
    }
}
