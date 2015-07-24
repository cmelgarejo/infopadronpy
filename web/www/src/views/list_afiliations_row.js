//Willynx
var $ = require("jquery");
var _ = require("underscore");
var Backbone = require("backbone");
Backbone.$ = $;
var Core = require("../../core");
var jqueryui = require("jqueryui");


var ModelBinder = require("ModelBinder");
var noty = require("noty");
var moment = require("moment");

var Router = require("../../router");

var FreightRequest = require("../../models/freight_request");
var Favorite = require("../../models/favorite");
var BidModel = require("../../models/bid");
var converter = require("../../helpers/converter");
var Router = require("../../router");
var viewUtils = require("../../helpers/view_utils");
var formatter = require("../../helpers/formatter");
var Constants = require("../../helpers/constants");
var numeral = require("numeral");

var notifier = require("../../notifier");
var bootbox = require("bootbox");
var countdown = require("countdown");

var DetailBuyAuctionTemplate = require("../../templates/list_afiliations_row.html");
var rauctions = [];
var currentTraderId;

var auctionOwner;
var ban = true;


function actualizaSubastas() {
	model.fetch().done(function() {
		if (Constants.devmode)
			console.info("refresh> refreshing the model");
	});
}

module.exports = Backbone.View
		.extend({
			initialize : function(options) {



			}
		});
