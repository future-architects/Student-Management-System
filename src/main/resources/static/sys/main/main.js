$(document).ready(function() {
        new AjaxRequest({
            url:   "/sys/user/is",
            type: 'get',
            param: {},
            callBack: function (data) {
                toastr_success(data)

            }
        });
})

