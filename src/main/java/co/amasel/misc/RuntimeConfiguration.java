package co.amasel.misc;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * Created by zaro on 5/27/16.
 */
public class RuntimeConfiguration {

    static String trailingSlash(String path){
        if(path != null && path.charAt(path.length()-1) != '/'){
            return path + "/";
        }
        return path;
    }
    static String getAppDirImpl(){
        String dir = System.getProperty("mwsRestApi.prefix");
        if(dir != null && !dir.equals("MWS_REST_API_HOME")){
            return dir;
        }
        File currentJar = null;
        try {
            currentJar = new File(RuntimeConfiguration.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

        // If we run in IDE
        if( currentJar.getParent().endsWith("classes")){
            return System.getProperty("user.dir");
        }

        return currentJar.getParent();
    }

    static String appDir;
    public static String getAppDir(){
        if(appDir != null){
            return  appDir;
        }
        return appDir = trailingSlash(getAppDirImpl());
    }



    static JsonObject cfg;
    static JsonObject loadConfigImpl(){
        byte fileContents[];
        try {
            fileContents = Files.readAllBytes(Paths.get(getAppDir() + "/cfg/config.json"));
        } catch (IOException e) {
            return  new JsonObject();
        }
        String jsonWithComments = new String( fileContents, StandardCharsets.UTF_8 );
        String json = jsonWithComments.replaceAll("(?m)^\\s*#.*$","\n");
        return new JsonObject(json);
    }

    public static JsonObject loadConfig(){
        if(cfg != null){
            return cfg;
        }
        return cfg = loadConfigImpl();
    }

    public static String appPath(String absOrRel) {
        if( absOrRel ==null) {
            return null;
        }
        if (new File(absOrRel).isAbsolute()) {
           return absOrRel;
        }
        return new File(getAppDir(), absOrRel).getAbsolutePath();
    }

    public static String getSslCertFile(){
        JsonObject cfg = loadConfig();
        if(cfg.containsKey("ssl")){
            JsonObject ssl = cfg.getJsonObject("ssl");
            if( ssl != null && ssl.containsKey("certPath")){
                return appPath( ssl.getString("certPath") );
            }
        }
        return null;
    }

    public static String getSslKeyFile(){
        JsonObject cfg = loadConfig();
        if(cfg.containsKey("ssl")){
            JsonObject ssl = cfg.getJsonObject("ssl");
            if( ssl != null && ssl.containsKey("keyPath")){
                return appPath( ssl.getString("keyPath") );
            }
        }
        return null;
    }

    public static int getPort(){
        JsonObject cfg = loadConfig();
        if(cfg.containsKey("port")){
            Integer port = cfg.getInteger("port");
            if(port != null){
                return port;
            }
            String portStr = cfg.getString("port");
            if(portStr != null){
                return Integer.valueOf(portStr);
            }
        }
        return 8181;
    }

    public static String getHost(){
        JsonObject cfg = loadConfig();
        if(cfg.containsKey("host")){
            String hostStr = cfg.getString("host");
            if(hostStr != null){
                return hostStr;
            }
        }
        return "0.0.0.0";
    }

    public static JsonObject getAdmins() {
        JsonObject cfg = loadConfig();
        if(cfg.containsKey("admins") ){
            try {
                return cfg.getJsonObject("admins");
            } catch (ClassCastException e) {}
        }
        return new JsonObject();
    }

}
