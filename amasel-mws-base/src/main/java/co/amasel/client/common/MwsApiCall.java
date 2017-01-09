package co.amasel.client.common;

import co.amasel.model.common.AmaselMwsObject;

/**
 * Created by zaro on 5/20/16.
 */
public class MwsApiCall {
    private final String operationName;
    private final Class<? extends AmaselMwsObject> requestClass;
    private final Class<? extends AmaselMwsObject> responseClass;
    private final String servicePath;
    private final String serviceVersion;
    private final Class<? extends MwsPostDataTransformer> postDataTransformerClass;


    public MwsApiCall(String operationName, Class<? extends AmaselMwsObject> requestClass, Class<? extends AmaselMwsObject> responseClass, String servicePath, String serviceVersion) {
        this.operationName = operationName;
        this.requestClass = requestClass;
        this.responseClass = responseClass;
        this.servicePath = servicePath;
        this.serviceVersion = serviceVersion;
        this.postDataTransformerClass = MwsPostDataTransformer.class;
    }

    public MwsApiCall(String operationName, Class<? extends AmaselMwsObject> requestClass, Class<? extends AmaselMwsObject> responseClass, String servicePath, String serviceVersion, Class<? extends MwsPostDataTransformer> postDataTransformerClass) {
        this.operationName = operationName;
        this.requestClass = requestClass;
        this.responseClass = responseClass;
        this.servicePath = servicePath;
        this.serviceVersion = serviceVersion;
        this.postDataTransformerClass = postDataTransformerClass;
    }

    public String getServicePath() {
        return this.servicePath;
    }

    public String getServiceVersion() {
        return this.serviceVersion;
    }

    public String getOperationName() {
        return this.operationName;
    }

    public Class<? extends AmaselMwsObject> getResponseClass() {
        return this.responseClass;
    }
    public Class<? extends AmaselMwsObject> getRequestClass() {
        return this.requestClass;
    }

    public MwsPostDataTransformer makePostDataTransformer() {
        try {
            return postDataTransformerClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}