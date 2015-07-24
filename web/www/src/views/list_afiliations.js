var Constants = require("../../helpers/constants");
var $ = require("jquery");
var _ = require("underscore");
var Backbone = require("backbone");
Backbone.$ = $;

var Core = require("../../core");

var Router = require("../../router");
var PaginationBuilder = require("../../helpers/paginatorBuilder");

var DetailBuyAuctionView = require("./list_afiliations_row");
var ListBuyAuctionsTemplate = require('../../templates/list_afiliations.html');

var icheck = require("icheck");

var currentTraderId;



module.exports = Backbone.View
		.extend({
			filterApplied : false,

			initialize : function(options) {
				this.state = "LOADING";
				// This is the default
				
				this.initViewWithParams();

				this.triggerFetchAuctionCollection();

				this.filterApplied = false;

			}
		});
