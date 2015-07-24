var noty = require("noty");

var that = {};

that.showNotification = function (msg, layout, type, timeout) {
    var n = noty({
        text: msg,
        layout: layout,
        type: type,
        timeout: timeout
    });
};
that.showInfoMsg = function (msg) {
    that.showNotification(msg, "top", "info", 4000);
};

that.showSuccessMsg = function (msg) {
    that.showNotification(msg, 'top', "success", 3500);
};

that.showWarningMsg = function (msg) {
    that.showNotification(msg, 'top', "warning", 5000);
};

that.showInfoRight = function (msg) {
    that.showNotification(msg, 'topRight', 'info', 2000);
};

that.showErrorMsg = function (msg) {
    that.showNotification(msg, 'top', "error", 3500);
};

module.exports = that;