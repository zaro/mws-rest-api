import co.amasel.MwsAsyncHandler;
import com.amazonaws.mws.model.UpdateReportAcknowledgementsResponse;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.io.IOException;

/**
 * Created by zaro on 11/21/15.
 */
public class Main {
    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    public static void main(String[] args){
        VertxOptions options = new VertxOptions();
        options.setBlockedThreadCheckInterval(1000*60*60);

        Vertx vertx = Vertx.vertx(options);

        Verticle myVerticle = new MwsTest();
        Verticle myAVerticle = new MwsAsyncHandler();
        //vertx.deployVerticle(myVerticle, new DeploymentOptions());
        vertx.deployVerticle(myAVerticle, new DeploymentOptions());

        if(true) return;
        String theString = convertStreamToString(
                ClassLoader.getSystemResourceAsStream("mock/UpdateReportAcknowledgementsResponse.xml"));



        ObjectMapper xmlMapper = new XmlMapper();
        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
        // if ONLY using JAXB annotations:
        xmlMapper.setAnnotationIntrospector(introspector);

        long startTime = System.currentTimeMillis();
        UpdateReportAcknowledgementsResponse r = null;
        try {
            r = xmlMapper.readValue(theString, UpdateReportAcknowledgementsResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);

        //GetCompetitivePricingForASINResponse r  =Json.decodeValue(theString, GetCompetitivePricingForASINResponse.class);
        System.out.println(r);
    }
}
