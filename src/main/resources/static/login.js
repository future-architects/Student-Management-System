
$("#login").click(function () {
    alert(22)
    $.ajax({
        url: "/sys/login/loginVerify",
        type:"POST",
        data:{username:$("#username").val(),password:$("#password").val()},
    })

})