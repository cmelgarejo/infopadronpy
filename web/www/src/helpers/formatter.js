var moment = require("moment");

var pkg = {};

var dateFormat = "DD/MM/YYYY";
var dateTimeFormat = "DD/MM/YYYY HH:mm A";

pkg.formatDate = function (iso8601DateStr) {
    return moment(iso8601DateStr).format("DD/MM/YYYY");
};

pkg.formatDateTime = function (iso8601DateStr) {
    return moment(iso8601DateStr).format("DD/MM/YYYY HH:mm:ss");
};

pkg.formatDateTimeGeneral = function (iso8601DateStr) {
    return moment(iso8601DateStr).format("YYYY/MM/DD HH:mm:ss");
};

pkg.isoDatetimeFromFormattedDateGeneral = function (isoDate) {
    return pkg.isoDateFromFormattedDate(isoDate, "YYYY/MM/DD HH:mm:ss");
};

pkg.formattedDateToISODate = function (formattedDateStr, format) {
    if (!format) {
        format = dateFormat;
    }
    var valueTrimmed = formattedDateStr.trim();
    return moment(valueTrimmed, format).format();
};

pkg.formattedDatetimeToISODate = function (formattedDatetimeStr) {
    return pkg.formattedDateToISODate(formattedDatetimeStr, dateTimeFormat);
};

pkg.isoDateFromFormattedDate = function (isoDate, format) {
    if (!format) {
        format = dateFormat;
    }
    var valueTrimmed = isoDate.trim();
    return moment(valueTrimmed).format(format);
};

pkg.isoDatetimeFromFormattedDate = function (isoDate) {
    return pkg.isoDateFromFormattedDate(isoDate, dateTimeFormat);
};

pkg.statusMap = {
    'ACTIVE': 'Activo',
    'NEW': 'Nuevo',
    'COMPLETED': 'Concretado',
    'EXPIRED': 'Expirado',
    'CANCELLED': 'Cancelado',
    'TO_CONFIRM': 'A confirmar',
    'NO_WINNER': 'Sin ganador',
    'SUSPENDED_BY_ADMIN': 'Suspendida'
};

module.exports = pkg;