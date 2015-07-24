var $ = require("jquery");
var _ = require("underscore");
var Backbone = require("backbone");
Backbone.$ = $;
//var jqueryui = require("jqueryui");

var Tooltip = require("tooltip");

var QualityTemplate = require("../templates/tooltips/quality.html");
var PaymentTemplate = require("../templates/tooltips/payment.html");
var PriceTemplate = require("../templates/tooltips/price.html");
var ObservationTemplate = require("../templates/tooltips/observation.html");
var AutomaticOfferTemplate = require("../templates/tooltips/automaticoffer.html");
module.exports = {
    initialPriceTooltip: function (tooltipElement) {

        var content = "El precio que el comprador esta dispuesto a pagar en destino";

        tooltipElement.tooltip({
            content: content
        });
    },
    qualityTooltipForId: function (qualityId, tooltipElement,perDamageId) {
        var html = QualityTemplate({});

        var content = "None";
        if (qualityId == 1) {
            var quality1 = $(html).find("#grado1");
            content = quality1.html();
        } else if (qualityId == 2) {
            var quality2 = $(html).find("#grado2");
            content = quality2.html();
        } else {
        	
            var maizSegunda = $(html).find("#maizSegunda");
            maizSegunda.find("#perDamageId").text("Dañados: "+perDamageId+"%");
            content = maizSegunda.html();
        }

        // Setup quality tooltip

        tooltipElement.tooltip({
            text : content,
            position: 'r',
            cls: 'custom-tooltip'
            
        });

    },
    paymentTooltipForId: function (paymentId, tooltipElement,paymentDetail) {
        var html = PaymentTemplate({});

        var content = "Ninguno";
        if (paymentId == 1) {
            var quality1 = $(html).find("#payment1");
            quality1.find("#paymentDet").text(paymentDetail)
            content = quality1.html();
        } else if (paymentId == 2) {
            var quality2 = $(html).find("#payment2");
            quality2.find("#paymentDet").text(paymentDetail)
            content = quality2.html();
        } else if (paymentId == 3) {
            var quality3 = $(html).find("#payment3");
            quality3.find("#paymentDet").text(paymentDetail)
            content = quality3.html();
        } else if (paymentId == 4) {
            var quality4 = $(html).find("#payment4");
            quality4.find("#paymentDet").text(paymentDetail)
            content = quality4.html();
        } else if (paymentId == 5) {
            var quality5 = $(html).find("#payment5");
            quality5.find("#paymentDet").text(paymentDetail)
            content = quality5.html();
        } 

        // Setup payment tooltip

        tooltipElement.tooltip({
            text : content,
            position: 'r',
            cls: 'custom-tooltip'
        });

    },
    priceTooltipForId: function (currentLowestPrice,priceFormatted, tooltipElement) {
        var html = PriceTemplate({});
       
        var content = "None";
        if (currentLowestPrice!=null) {
        	var quality1 = $(html).find("#initialPriceId");
        	quality1.find("#initialPrice").text(""+priceFormatted)
            content = quality1.html();
        } else{
        	content="";
        }

        // Setup payment tooltip

        tooltipElement.tooltip({
            text : content,
            position: 'r',
            cls: 'custom-tooltip'
        });

    },
    observationTooltip: function (tooltipElement,observation) {
        var html = ObservationTemplate({});
        

       
        var content = "None";
        if (observation!=null) {
        	var obs1 = $(html).find("#obs").text("Obs: ");
//        	obs1.find("#obs").text("Obs: "+observation.substring(0,50));
        	
            var cut=observation.split(" ");
            //console.log("cut length "+cut.length);
            var line=parseInt(cut.length/20);
            //console.log("lines: "+line);
        	var matriz=new Array();
        	var c=0;
        	var text="";
        		for(i=0;i<cut.length;i++){
        			c++;
        			//console.log("cut[i]; "+cut[i]);
        			text=text+cut[i]+' ';
        			if(c==20){
        				c=0;
        				text=text+'<br>';
        			}
        		}
 
        	//console.log('texto: '+text);
        	obs1.append(text);
//        	obs1.append(observation.substring(0,50)+"<br>");
//        	obs1.append(observation.substring(50,100)+"<br>");
//        	obs1.append(observation.substring(100,150)+"<br>");
            content = obs1.html();
        } else{
        	content="Ninguna";
        }

        // Setup payment tooltip

        tooltipElement.tooltip({
            text : content,
            position: 'r',
            cls: 'custom-tooltip',
            dontHideOnTooltipHover: true
        });

    },
    
    automaticOfferTooltip: function (tooltipElement) {
        var html = AutomaticOfferTemplate({});

        var content = "None";
        	var obs1 = $(html).find("#obs");
            content = obs1.html();

        // Setup automatic offer tooltip

        tooltipElement.tooltip({
            text : content,
            position: 't',
            cls: 'autOffer-tooltip',
            dontHideOnTooltipHover: true
        });

    },
    
    // Receives a string and a jquery object (a div) that is used to create
    // a Expand/collapse functionality for the text
    setupObservations: function (completeText, sectionObject) {
        var maxLength = 120;

        if (!completeText) {
            // Well, nothing to do because observations is not defined
            return;
        }

        var length = completeText.length;
        var text = completeText;
        var textShouldExpand = length > maxLength;
        if (textShouldExpand) {
            text = completeText.substring(0, maxLength) + "...";
        }

        var paragraph = $("<p></p>");
        paragraph.text(text);
        sectionObject.append(paragraph);

        if (textShouldExpand) {
            var link = $("<a>Ver mas</a>");
            var state = "collapsed";
            link.on('click', function (evt) {
                evt.stopPropagation();
                if (state == "collapsed") {
                    paragraph.text(completeText);
                    link.text("Ver menos");
                    state = "expanded";
                } else {
                    paragraph.text(text);
                    link.text("Ver mas");
                    state = "collapsed";
                }
            });
            sectionObject.append(link);
        }

    }
};