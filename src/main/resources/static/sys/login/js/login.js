
/*$('#login').bind('click',function(){
    // alert(111)
    $.ajax({
        type: "post",
        url:"/loginVerify",
        dataType:"json",
        data:{"username":$("#username").val(),"password":$("#password").val()},
        onLoadError: function(data) {
            // toastr_success(data)
            window.location.replace("/main.html");
            // window.location.replace("/login");

        },

    })
    // window.location='/'
})*/

/*function onclickss() {
    $.ajax({
        type: "post",
        url:"/sys/user/is",
        dataType:"json",
        data:{username:$("#username").val(),password:$("#password").val()}
    })
}*/

// $('#login').bind('click',function(){
//         new AjaxRequest({
//             url: "/sys/user/is",
//             param: $('#loginId').serializeJson(),
//             buttonid: 'student_EditButton',
//         });
// })