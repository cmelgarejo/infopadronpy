var $ = require("jquery");
var moment = require("moment");

module.exports = {
    validateRequired: function (errors, attr, name, group) {
        if (attr === undefined || $.trim(attr) == "") {
            errors.push({name: name, attrGroup: group, message: name + ' no especificado.'});
            return true;
        } else {
            return false;
        }
    },
    validateRequiredStrictPositiveInt: function (errors, attr, name, group) {
        // attr: Required a positive non zero number
        if (!this.validateRequired(errors, attr, name, group)) {
            if (!$.isNumeric(attr)) {
                errors.push({name: name, attrGroup: group, message: name + ' no es un numero entero.'});
                return true;
            } else {
                var number = parseInt(attr);
                if (number < 0) {
                    errors.push({name: name, attrGroup: group, message: name + ' negativa.'});
                    return true;
                } else if (number == 0) {
                    errors.push({name: name, attrGroup: group, message: name + ' no puede ser cero.'});
                    return true;
                }
            }
            // No errors
            return false;
        } else {
            // Error
            return true;
        }
    },
    validateDeliveryInterval: function (errors, from, to, group) {
        if (!this.validateRequired(errors, from, 'Fecha desde', group)) {
            if (!this.validateRequired(errors, to, 'Fecha hasta', group)) {
                // The fields exist. Check if from is >= now
                // which will set the time to 00:00:00 in the local time zone.
                var now = new moment().startOf('day');
                if (from.diff(now) < 0) {
                    errors.push({name: 'Desde',
                        attrGroup: 'deliveryGroup',
                        message: "'Fecha desde' es anterior a la fecha actual"
                    });
                    return true;
                } else {
                    // Date is >= now. Check that range is correct: from <= to
                    if (to.diff(from) < 0) {
                        errors.push({
                            name: 'Rango',
                            attrGroup: 'deliveryGroup',
                            message: "Rango invalido. 'Fecha desde' es posterior a 'Fecha hasta'"
                        });
                        return true;
                    }
                    // No errors.
                    return false;
                }
            } else {
                // Error: to not specified
                return true;
            }
        } else {
            // Error: from not specified
            return true;
        }
    },
    validateRequiredLatitude: function (errors, latitude, name, group) {
        if (!this.validateRequired(errors, latitude, name, group)) {
            if (!$.isNumeric(latitude)) {
                errors.push({name: name, attrGroup: group, message: name + ' no es un numero.'});
                return true;
            }
            var latitudeFloat = parseFloat(latitude);
            if (latitudeFloat < 91 && latitude > -91) {
                return true;
            } else {
                errors.push({name: 'Latitud',
                    attrGroup: group,
                    message: "'La Latitud cargada no es válida"
                });
                return true;
            }
        } else {
            // Error
            return true;
        }
    },
    validateRequiredLongitude: function (errors, longitude, name, group) {
        if (!this.validateRequired(errors, longitude, name, group)) {
            if (!$.isNumeric(longitude)) {
                errors.push({name: name, attrGroup: group, message: name + ' no es un numero.'});
                return true;
            }
            var longitudeFloat = parseFloat(longitude);
            if (longitudeFloat < 91 && longitudeFloat > -91) {
                return true;
            } else {
                // Error
                return true;
            }
        }
    },
    validateFloat: function (errors, value, name, group) {
        if (parseFloat(value) && value.match('^[0-9]*\.[0-9]*$')) {
            return false;
        } else {
            errors.push({name: name, attrGroup: group, message: name + ' no es un número entero o con parte decimal válido.'});
            return true;
        }
    },
    validateEmail: function (errors, value, name, group) {
        var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (regex.test(value)) {
            return false;
        } else {
            errors.push({name: name, attrGroup: group, message: name + ' no es un correo electrónico válido.'});
            return true;
        }
    },
    validatePhonenumber: function (errors, value, name, group) {
        var regex = /\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/;
        if (regex.test(value)) {
            return false;
        } else {
            errors.push({name: name, attrGroup: group, message: name + ' no es un número de teléfono válido.'});
            return true;
        }
    },
    validateEquals: function (errors, value1, value2, group, msg) {
        if (value1 === value2) {
            return false;
        } else {
            errors.push({name: "", attrGroup: group, message: msg || "Los valores no coinciden"});
            return true;
        }
    }
};

