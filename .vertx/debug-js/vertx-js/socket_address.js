/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

/** @module vertx-js/socket_address */
var utils = require('vertx-js/util/utils');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JSocketAddress = io.vertx.core.net.SocketAddress;

/**
 The address of a socket

 @class
*/
var SocketAddress = function(j_val) {

  var j_socketAddress = j_val;
  var that = this;

  /**

   @public

   @return {string}
   */
  this.host = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_socketAddress["host()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {number}
   */
  this.port = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_socketAddress["port()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_socketAddress;
};

// We export the Constructor function
module.exports = SocketAddress;