module.exports = {
    enableButton: function ($button, enable) {
        if (enable) {
            $button.removeClass('disabled');
        } else {
            $button.addClass('disabled');
        }
        $button.prop('disabled', !enable);
    }
};