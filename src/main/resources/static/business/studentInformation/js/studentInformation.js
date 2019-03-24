var selecttableid="";
var currentpagecount="";

$(document).ready(function() {

    var studentname="";
    //收藏、下载、建议、废除、复用-触发
    //
    window.operateEvents = {
        'click .del_button': function (e, value, row, index) {
            selecttableid=row.id;
        },
        'click .edit_button': function (e, value, row, index) {
            selecttableid=row.id;
            getstudentinfo()
        },

    };


    $("#studentInformationList").bootstrapTable({
        url: '/business/student_information/list',                      //请求后台的URL（*）
        method: 'post', //请求方式（*）
        toolbar: '#toolbar',              //工具按钮用哪个容器
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true, //是否显示分页（*）
        sortable: false, //是否启用排序
        pageNumber: 1, //初始化加载第一页，默认第一页
        pageSize: pagenumber, //每页的记录行数（*）
        buttonsAlign: "right",
        paginationPreText: '上一页',
        paginationNextText: '下一页',
        uniqueId: "row_id",
        showRefresh: true, //是否显示刷新按钮.
        clickToSelect: true,//是否启用点击选中行
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        locale: 'zh-CN',
        showColumns: true,                  //是否显示所有的列
        pageList: [pagenumber],
        //得到查询的参数
        queryParams: function (params) {
            currentpagecount = ((params.offset / params.limit) + 1)
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                "student_name":studentname,
                "currentpagecount": "" + ((params.offset / params.limit) + 1) + "" //页码
            };

            return temp;
        },
        columns: [
            {
                title: '序号',
                field: '',
                align: 'center',
                formatter: function (value, row, index) {
                    return getOrderNumber("studentInformationList", index)
                }
            }, {
                field: 'student_name',
                title: '学生姓名',
                align: 'center'
            }, {
                field: 'student_phone',
                title: '联系方式',
                align: 'center'
            }, {
                field: 'major_id',
                title: '所学专业',
                align: 'center'
            }, {
                field: 'class_name',
                title: '学生班级',
                align: 'center'
            }, {
                field: 'student_gender',
                title: '学生性别',
                align: 'center',
                formatter:function (value, row, index) {
                    if (value==0) {
                        return "男"
                    }else {
                        return "女"
                    }
                }
            }, {
                field: 'dateofbirth',
                title: '出生日期',
                align: 'center'
            }, {
                field: 'teacher_name',
                title: '指导教师',
                align: 'center'
            }, {
                field: 'button',
                title: '操作',
                align: 'center',
                events: operateEvents,
                formatter: operateFormatter
            }
        ]

    });

    function operateFormatter(value, row, index) {
        selecttableid = row.id;

            return [
                //编辑
                '<button   type="button" class="btn btn-primary btn-xs edit_button" id="studentEdit_botton" title="编辑" data-toggle="modal" ><i class="fa fa-pencil"></i></button>'+
                //删除
                '<button   type="button" class="btn btn-primary btn-xs del_button" id="studentDel_button" data-toggle="modal" title="删除" data-target="#studentDel" style="background:#d9534f;border-color:#d9534f" ><i class="fa fa-trash-o"></i></button>'
            ]

    };



    //查询
    $('#studentsearchbutton').bind('click',function(){
        studentname=$("#studentname_search").val();

        $("#studentInformationList").bootstrapTable('refreshOptions',
            {   pageNumber:1,
                student_name:studentname,

            });
    });


});


function getstudentinfo() {
    new AjaxRequest({
        url:   "/business/student_information/info/"+selecttableid,
        type: 'get',
        param: {},
        callBack: function (data) {
            $('#studentEditFrom')[0].reset();
            $('#studentEditFrom').initForm(data);
            $("#studentEditModal").modal("show");
        }
    });
}

//刪除
$('#studentDelButton').bind('click',function() {
    new AjaxRequest({
        url: "/business/student_information/delete/" + selecttableid,
        param: {},
        buttonid: 'studentDelButton',
        tableurl: "/business/student_information/list",
        tableid: 'studentInformationList',
        tableparam: {currentpagecount: currentpagecount},
        modalid: 'studentDel',
        numberpage:true
    });
});

$('#student_EditButton').bind('click',function(){
    $("#studentEditFrom").data('bootstrapValidator').validate();
    if ($("#studentEditFrom").data('bootstrapValidator').isValid()) {
        new AjaxRequest({
            url: "/business/student_information/update",
            param: $('#studentEditFrom').serializeJson(),
            buttonid: 'student_EditButton',
            tableurl:  "/business/student_information/list",
            tableid: "studentInformationList",
            tableparam: {currentpagecount:currentpagecount},
            modalid:'studentEditModal',
            numberpage:true
        });
   }
})


$('#student_AddButton').bind('click',function(){
        $("#studentAddFrom").data('bootstrapValidator').validate();
        if ($("#studentAddFrom").data('bootstrapValidator').isValid()) {
    new AjaxRequest({
        url: "/business/student_information/save",
        param: $('#studentAddFrom').serializeJson(),
        buttonid: 'student_AddButton',
        tableurl:  "/business/student_information/list",
        tableid: "studentInformationList",
        tableparam: {currentpagecount:currentpagecount},
        modalid:'studentAddModal',
        numberpage:true
    });
    }
})

$('#dateofbirth_edit,#dateofbirth_add').datetimepicker({
    autoclose:true,//选中关闭
    language:  'zh-CN',
    todayHighlight:true,
    minView:2, //最精准的时间选择为日期0-分 1-时 2-日 3-月
    format: 'yyyy-mm-dd'      /*此属性是显示顺序，还有显示顺序是mm-dd-yyyy,yyyy-mm-dd hh:ii*/
});




$("#daoru").click(function(){
    var formdata = new FormData($("#form_table")[0]);
    $.ajax({
        url: "/business/student_informations/import",
        type: "POST",
        data:formdata,
        dataType: "json",
        processData: false,  // 告诉jQuery不要去处理发送的数据
        contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
        success: function (res) {
        }
    })
})

function impron() {

}