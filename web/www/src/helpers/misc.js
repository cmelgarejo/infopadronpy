module.exports = {
    getBaseContextFrom: function (pathname) {

        // If it /dev then use it
        if (pathname && pathname.length > 0) {
            var parts = pathname.split("/");
            if (parts.length > 1) {
                var context = parts[1];
                if (context == "dev") {
                    return "/dev";
                }
            }
        }

        return "/app";
    }
}