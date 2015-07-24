var $ = require("jquery");
var _ = require("underscore");

module.exports = function (initialPage, maxResults, totalElements) {
    var that = {};
    var currentPage = initialPage;

    that.hasPreviousPage = function () {
//                var totalPages = Math.floor(totalElements / maxResults);
//                var rest = totalElements % maxResults;

        if (currentPage == 0) {
            // no page before the first page
            return false;
        } else {
            return true;
        }
    };

    that.hasNextPage = function () {
        var totalPages = Math.floor(totalElements / maxResults);
        var rest = totalElements % maxResults;

        if (rest > 0) {
            totalPages += 1;
        }

        if (totalPages - 1 <= currentPage) {
            return false;
        } else {
            if (rest != 0) {
                // There is a reminder
                return true;
            } else {
                // No more pages
                return false;
            }
        }
    };

    that.getCurrentPage = function () {
        return currentPage;
    }

    return that;
};