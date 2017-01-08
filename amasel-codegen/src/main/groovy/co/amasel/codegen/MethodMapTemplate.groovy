package co.amasel.codegen

/**
 * Created by zaro on 5/20/16.
 */
class MethodMapTemplate {
    static String get(String modelName){
        return classTemplates.containsKey(modelName) ? classTemplates[modelName] : classTemplates["*"];
    }
    static def classTemplates=[
            "*": '''\
package <%= packageName %>;

import java.util.HashMap;
import co.amasel.client.common.*;
import <%=  modelPackage %>;

public class MethodMap implements AmaselMethodMap {
    static HashMap<String, MwsApiCall> methodMap = new HashMap<>();

    <%  apiMethods.each { p -> 
        if (p.postDataTransformer) {
    %>
    public static MwsApiCall <%= p.methodName %> = new MwsApiCall("<%= p.methodName %>", <%= p.methodName %>Request.class, <%= p.methodName %>Response.class, "<%= servicePath %>", "<%= serviceVersion %>", <%= p.postDataTransformer %>.class);
    <%  } else {%>
    public static MwsApiCall <%= p.methodName %> = new MwsApiCall("<%= p.methodName %>", <%= p.methodName %>Request.class, <%= p.methodName %>Response.class, "<%= servicePath %>", "<%= serviceVersion %>");
    <% 
        } 
     }
    %>

    static public void init(String prefix, HashMap<String, MwsApiCall> map) {
        if(prefix == null){
            prefix = "";
        } else if(prefix.length() > 0 && '.' != prefix.charAt(prefix.length() - 1)) {
            prefix = prefix + ".";
        }
        <%  apiMethods.each { p -> %>
        map.put(prefix + "<%= p.methodName %>", MethodMap.<%= p.methodName %>);
        <% } %>
    }

    static {
        init(null, methodMap);
    }

    @Override
    public MwsApiCall get(String name) {
        return methodMap.get(name);
    }

}
    ''']
}
