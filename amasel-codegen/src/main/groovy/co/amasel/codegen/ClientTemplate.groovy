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

import co.amasel.client.common.AmaselClientException;
import co.amasel.client.common.AmaselClientBase;
import co.amasel.client.common.MwsApiResponse;
import <%= packageName %>.MethodMap;
import <%= modelPackage %>;



public class <%= className %> {
    protected AmaselClientBase client;
    
    public <%= className %>(AmaselClientBase client) {
        this.client = client;
    }
    
    public Future<MwsApiResponse> invoke(<%= className %>Request request) throws AmaselClientException {
        return client.invoke(MethodMap.<%= className %>, request);
    }
}
'''
    ]
}
