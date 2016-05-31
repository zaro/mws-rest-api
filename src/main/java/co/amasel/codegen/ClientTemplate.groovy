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

import co.amasel.ApiRequestException;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmaselClient;
import co.amasel.client.common.AmazonCredentials;
import <%= packageName %>.MethodMap;
import <%= modelPackage %>;



public class <%= className %> extends AmaselClient {
    String endPoint;
    AmazonCredentials credentials;
    public <%= className %>(Vertx vertx, String endPoint, AmazonCredentials credentials) {
        super(vertx);
        this.endPoint = endPoint;
        this.credentials = credentials;
    }
    public Future<Response> invoke(<%= className %>Request request) throws ApiRequestException {
        return invoke(MethodMap.<%= className %>, request, endPoint, credentials);
    }
}
'''
    ]
}
