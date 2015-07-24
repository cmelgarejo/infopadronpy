//router.router : An object that can be used to change the main view. For example: router.router.pageSaleOffers();

var $ = require("jquery");
var _ = require("underscore");
var Backbone = require("backbone");
Backbone.$ = $;
var Marionette = require("marionette");
//var Noty = require("noty");
var Constants = require("./helpers/constants");
var Core = require("./core");

//Extend the View of backbone by creating a default close operations
//Views that have specifics bounded itself to event should implement the "onClose" method
//and remove itself from the listening events
Backbone.View.prototype.close = function () {
    this.remove();
    this.unbind();
    this.stopListening();
    if (this.onClose) {
        this.onClose();
    }
};

// FIXME: Put this code somewhere else
//Modifies the default Marionnet behaviour to add a class that expands the whole screen
//This way templates for pages can be created directly without taking in account a container
Marionette.Region.prototype.open = function (view) {
    view.$el.addClass("col-md-12");
    this.$el.empty().append(view.el);
}

//A page loader is a singletone that will keep track of the state of the main container
var pageLoader = (function () {
    'use strict';
    var that = {};
    var mainRegion = new Marionette.Region({
        el: '#main-region'
    });
    var currentView;

    that.showView = function (view) {
        if (currentView) {
            currentView.close();
        }
        currentView = view;
        mainRegion.show(view);
    };
    if(Constants.devmode){
    	console.log('open pageLoader');
    }
    return that;
})();

// FIXME: Somewhere else
// and the function that parses the query string can be something like :
var parseQueryString = function (queryString) {
    var params = {};
    if (queryString) {
        _.each(
            _.map(decodeURI(queryString).split(/&/g), function (el, i) {
                var aux = el.split('='), o = {};
                if (aux.length >= 1) {
                    var val = undefined;
                    if (aux.length == 2)
                        val = aux[1];
                    o[aux[0]] = val;
                }
                return o;
            }),
            function (o) {
                _.extend(params, o);
            }
        );
    }
    return params;
};

//Object of this class will not be exposed directly
//This class manage the router concept of backbone.
//URLs are mapped to actions and only some of these actions are exposed through the navigator
var AppRouter = Backbone.Router.extend({
    routes: {
        // Reverse auctions
        "afiliaciones/partido": "_listAfiliations",
        "rcp/registro": "_listRCP",
        "*actions": "index"

    },
    index: function () {

    },
    _listMyAuctionHistory: function (history) {


    },
    _listAfiliatons: function (queryString, history) {
        var params = parseQueryString(queryString);
        
        
        
        var self = this;
        //var currentraderId=Core.getTraderId();
        
        var ListAfiliationView = require("./views/list_afiliations");
        var AfiliationsCollection = require("./collections/afiliations");

        var afiliationsCollection = new ReverseAuctionCollection({params: params});
        var view = new ListBuyAuctionView({model: afiliationsCollection});
        pageLoader.showView(view);
        if (history) {
            self.navigate(history + "?" + queryString);
        }
    },
    _changeHistory: function (newHistory) {
        this.navigate(newHistory);
    }
    
});

var appRouter = new AppRouter();

//This is an object that expose only the methods that can be invoked from the API. This way the router remains encapsulated within the utilities modules
//Note
var navigator = {

    justChangeHistory: function (newHistory) {
        appRouter._changeHistory(newHistory);
    },
    listAfiliations: function () {
        var maxPages = Constants.maxPages;
        appRouter._listAfiliations(Constants.defaultAuctionParams(), 'afilitations');
    }
};

module.exports = {
    navigator: navigator,
    start: function () {
        Backbone.history.start();
    }
};

