var selecttableid="";
var currentpagecount="";

$(document).ready(function() {

    $("#userlist").bootstrapTable({
        url: '/sys/user/list',                      //请求后台的URL（*）
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
                // "student_name":studentname,
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
                    return getOrderNumber("userlist", index)
                }
            }, {
                field: 'username',
                title: '用户名',
                align: 'center'
            }, {
                field: 'person_name',
                title: '人员姓名',
                align: 'center'
            }, {
                field: 'date_of_birth',
                title: '出生年月',
                align: 'center'
            }, {
                field: 'create_date',
                title: '创建时间',
                align: 'center'
            },{
                field: 'button',
                title: '操作',
                align: 'center',
                // events: operateEvents,
                formatter: operateFormatter
            }
        ]

    });


    $('#date_of_birth_add').datetimepicker({
        autoclose:true,//选中关闭
        language:  'zh-CN',
        todayHighlight:true,
        minView:2, //最精准的时间选择为日期0-分 1-时 2-日 3-月
        format: 'yyyy-mm-dd'      /*此属性是显示顺序，还有显示顺序是mm-dd-yyyy,yyyy-mm-dd hh:ii*/
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


    $("#useraddsave").click(function () {
        // $("#systemaddfrom").data('bootstrapValidator').validate();
        // if ($("#systemaddfrom").data('bootstrapValidator').isValid() ) {
            new AjaxRequest({
                url: "/sys/user/save",
                param: $('#useraddfrom').serializeJson(),
                tableurl: "/sys/user/list",
                tableid: 'userlist',
                modalid: 'useradd',
                tableparam: {currentpagecount: currentpagecount},
                buttonid: 'useraddsave',
                numberpage:true
            });
        // }
    });


})