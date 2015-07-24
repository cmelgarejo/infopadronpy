var $ = require("jquery");
var _ = require("underscore");
var Backbone = require("backbone");
Backbone.$ = $;

var ModelBinder = require("ModelBinder");

var formatter = require("../../helpers/formatter");
var viewUtils = require("../../helpers/view_utils");
var moment = require("moment");
var Router = require("../../router");

var Datetimepicker = require("datetimepicker");
var DatetimepickerEs = require("datetimepicker_es");

var Tooltip = require("tooltip");

var AuctionFormTemplate = require("../../templates/rauction/new_auction.html");
var QualityTemplate = require("../../templates/tooltips/quality.html");

module.exports = Backbone.View.extend({
    initialize: function (options) {       
        this._modelBinder = new Backbone.ModelBinder();
    },
    events: {
        'click #acceptButton': 'acceptAction',
        'click #backButton': 'backAction'
    },
    render: function () {
        
        
        return this;
    }
});
