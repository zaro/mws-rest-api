package co.amasel.codegen

/**
 * Created by zaro on 5/20/16.
 */
class ClientTemplate {
    static String get(String modelName){
        return classTemplates.containsKey(modelName) ? classTemplates[modelName] : classTemplates["*"];
    }
    static def classTemplates=[
            "*": '''\
package <%= packageName %>;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import co.amasel.client.common.MwsApiResponse;
import <%= packageName %>.MethodMap;
import <%= modelPackage %>;



public class <%= className %> extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public static AmaselClient fromVertxInstance(Vertx vertx) {
        AmaselClient c = new AmaselClient();
        c.vertx = vertx;
        return  c;
    }
    public Future<MwsApiResponse> invoke(<%= className %>Request request) throws AmaselClientException {
        return invoke(MethodMap.<%= className %>, request, endPoint, credentials);
    }
}
'''
    ]
}
