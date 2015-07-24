var $ = require("jquery");
var _ = require("underscore");

var misc = require("./helpers/misc");
var noty = require("noty");
var jqueryui = require("jqueryui");
var constants = require("./helpers/constants");

var showDialogModalMessage = function (title, message, options) {
    $("#modalErrorTitle").text(title);
    $("#modalErrorMsg").html(message);

    if (options) {
        if (options.blockModal) {
            $('#modalErrorDiv').modal({
                backdrop: "static",
                keyboard: "false"
            });
        }

        if (options.type == "error") {
            $("#modalErrorHeader").addClass("alert alert-danger");
        } else if (options.type == "warning") {
            $("#modalErrorHeader").addClass("alert alert-warning");
        }

        if (options.errorButton) {
            var modalErrorGoToLoginButton = $("#modalErrorGoToLoginButton");
            modalErrorGoToLoginButton.click(options.errorButton);
            modalErrorGoToLoginButton.show();
        }

        if (options.closeButton) {
            var modalErrorCloseButton = $("#modalErrorCloseButton");
            modalErrorCloseButton.click(options.closeButton);
            modalErrorCloseButton.show();
        }
    }

    $('#modalErrorDiv').modal('show');
};

module.exports = {
    setupErrorHandling: function () {
        var pathname = window.location.pathname;

        var defaultUrl = misc.getBaseContextFrom(pathname);
        var loginUrl = defaultUrl + "/login.html";

        $(document).ajaxError(function (event, jqxhr, settings, exception) {
            var status = jqxhr.status;
            if (status === 0) {
                var msg = "Error al tratar de conectarse al servidor. Por favor verifique su conexion a Internet.";
                var n = noty({
                    text: msg,
                    layout: 'top',
                    type: 'error',
                    dismissQueue: true,
                    maxVisible: 1
                });

            } else if (status === 401) {
                var title = "Sesión expirada";
                var msg = "Haga click en el boton de aceptar para ir a la página de login";
                showDialogModalMessage(title, msg, {
                    blockModal: true,
                    type: "warning",
                    closeButton: function () {
                        
                        window.location = loginUrl;
                    }
                });

            } else if (status === 403) {
                var title = "Error de usuario";
                var msg = "Por favor contacte al administrador de Agriket: soporte@agriket.com";
                showDialogModalMessage(title, msg, {
                    blockModal: true,
                    type: "warning",
                    closeButton: function () {
                        
                        window.location = loginUrl;
                    }
                });

            } else if (status >= 500 && status < 600) {
                var title = 'Ha ocurrido un error inesperado';
                var msg = "<div> Info: " + (jqxhr.statusText ? jqxhr.statusText : '') + "</div>" +
                    "<div>Para soporte contactar a soporte@agriket.com</div>";
                showDialogModalMessage(title, msg, {
                    blockModal: true,
                    type: "error",
                    errorButton: function () {
                        window.location = loginUrl;
                    }
                });
            }
        });
    }
};