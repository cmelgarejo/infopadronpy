var Core = function () {
    var userId, username,  userEmail, root, admin;
    var that = {};

    that.init = function (options) {
        userId = options.userId;
        username = options.username;
        userEmail = options.userEmail;
        root = options.root;
        admin = options.admin;
    };

    that.getUserId = function () {
        return userId;
    };



    that.getCurrentUsername = function () {
        return username;
    };

    that.getCurrentUserEmail = function () {
        return userEmail;
    };


    that.isRoot = function () {
        return root;
    };
    
    that.isAdmin = function () {
        return admin;
    };
    
    //TODO: There's got to be a better way to do this. Porky code
    that.temporalSpace = {};

    that.listingSilosByTrader = function () {
        return typeof that.temporalSpace.traderModel !== 'undefined';
    };

    return that;
};

module.exports = Core();
