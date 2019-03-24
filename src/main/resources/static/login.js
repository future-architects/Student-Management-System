$.ajax({
    url:"/user/user",
    type: 'get',
    param: {},
    callBack: function (data) {
        alert(data)
        $("#person").html(getMyName())
    }
})

function getMyName(){
    var myName = '<%=session.getAttribute("personName")%>';
    alert(myName);
}