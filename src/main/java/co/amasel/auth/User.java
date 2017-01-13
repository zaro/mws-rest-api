package co.amasel.auth;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.AuthProvider;
import io.vertx.ext.web.handler.JWTAuthHandler;

/**
 * Created by zaro on 1/13/17.
 */
public class User implements io.vertx.ext.auth.User {
    String user;
    String pass;

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUsername(){
        return this.user;
    }

    @Override
    public io.vertx.ext.auth.User isAuthorised(String authority, Handler<AsyncResult<Boolean>> resultHandler) {
        resultHandler.handle(Future.succeededFuture(true));
        return this;
    }

    @Override
    public io.vertx.ext.auth.User clearCache() {
        return this;
    }

    @Override
    public JsonObject principal() {
        return new JsonObject().put("user", user).put("password", pass);
    }

    @Override
    public void setAuthProvider(AuthProvider authProvider) {
    }
}
