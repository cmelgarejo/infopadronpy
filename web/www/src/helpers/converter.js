var $ = require("jquery");
var _ = require("underscore");

var pkg = {};

pkg.stringToInteger = function (direction, value) {
    // direction is either ModelToView or ViewToModel
    // Return either a formatted value for the view or an un-formatted value for the model
    // FIXME: Reevaluate this "defensive programming" technique
    if (direction == 'ViewToModel') {
        //ViewToModel
        if (value) {
            var valueTrimmed = value.trim();
            if (valueTrimmed != "") {
                var number = parseInt(valueTrimmed);
                if (isNaN(number)) {
                    return "";
                } else {
                    return number;
                }
            }
        }
        return value;
    } else {
        //ModelToView
        if (value != undefined) {
            return value;
        }
    }
};

module.exports = pkg;