

exports.vertxStart = function() {
  console.log("This is a test and it is STARTing...");

  var Router = require("vertx-web-js/router");
  var restAPI = Router.router(vertx);

  restAPI.get('/js').handler(function (rc){
    rc.response().end('OK');
  });

  var PluginShared = Java.type("co.amasel.server.PluginShared");
  new Router(PluginShared.getMainRouter()).mountSubRouter('/test',restAPI);
}

exports.vertxStop = function() {
 console.log("This is a test and it is STOPing...");
}
