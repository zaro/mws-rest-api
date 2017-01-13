package co.amasel.auth;

import co.amasel.misc.RuntimeConfiguration;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.auth.AuthProvider;
import io.vertx.ext.auth.User;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * Created by zaro on 1/13/17.
 */
public class ConfigAuthProvider implements AuthProvider {
    //private final Logger logger = LoggerFactory.getLogger("ConfigAuthProvider");

    @Override
    public void authenticate(JsonObject authInfo, Handler<AsyncResult<User>> resultHandler) {
        JsonObject admins = RuntimeConfiguration.getAdmins();
        String user = authInfo.getString("username");
        String pass = authInfo.getString("password");

        String passSha256 = DigestUtils.sha256Hex(pass);

        Object adminPass = admins.getValue(user);
        if (adminPass instanceof String && passSha256.equals((String)adminPass)) {
            resultHandler.handle(Future.succeededFuture(new co.amasel.auth.User(user, pass)));
            return;
        }
        if (adminPass instanceof Boolean && ((Boolean) adminPass)) {
            resultHandler.handle(Future.succeededFuture(new co.amasel.auth.User(user, "")));
            return;
        }

        resultHandler.handle(Future.failedFuture("Invalid user/pass."));
    }
}
