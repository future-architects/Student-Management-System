var selecttableid="";


$(document).ready(function() {


    $("#zhuce").click(function () {
        $("#useradd").modal('show');
    })

    $("#useraddsave").click(function () {
        // $("#systemaddfrom").data('bootstrapValidator').validate();
        // if ($("#systemaddfrom").data('bootstrapValidator').isValid() ) {
            new AjaxRequest({
                url: "/sys/user/save",
                param: $('#useraddfrom').serializeJson(),
                modalid: 'useradd',
                buttonid: 'useraddsave',
            });
        // }
    });


})