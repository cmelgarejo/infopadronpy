var $ = require("jquery");
var _ = require("underscore");
var Backbone = require("backbone");
Backbone.$ = $;

var User = require("../models/user");

module.exports = Backbone.Collection.extend({
    url: '/api/afiliaciones/{ci}',
    model: User
});

