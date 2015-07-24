var $ = require("jquery");
var _ = require("underscore");
var Backbone = require("backbone");
Backbone.$ = $;

var validation = require("../helpers/validation");

module.exports = Backbone.Model.extend({
    initialize: function () {

    },
    url: function () {
        var ci = this.get('id');
        if (ci) {
            return '/api/afiliaciones/' + ci;
        } 
    },
    validate: function (attrs, options) {
        var errors = [];
        validation.validateRequired(errors, attrs.name, "CI", 'ciGroup');
        return errors.length > 0 ? errors : false;
    }
});