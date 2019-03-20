var selecttableid="";
$(document).ready(function() {

    var currentpagecount="";
    //收藏、下载、建议、废除、复用-触发
    window.operateEvents = {
        'click .del_button': function (e, value, row, index) {
            selecttableid=row.id;
            alert(selecttableid);

            toastr_success(selecttableid)
            // templateUuid=row.template_uuid;
            // getTemplateinfoproposal();
            // templateselectByUuId();
            // uploadFileProposal();
        },

    };


    $("#studentInformationList").bootstrapTable({
        url: '/student_information/list',                      //请求后台的URL（*）
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
                "temp":1,
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
                title: '姓名',
                align: 'center'
            }, {
                field: 'student_phone',
                title: '联系方式',
                align: 'center'
            }, {
                field: 'student_ties',
                title: '系别',
                align: 'center'
            }, {
                field: 'student_major',
                title: '专业',
                align: 'center'
            }, {
                field: 'student_class',
                title: '班级',
                align: 'center'
            }, {
                field: 'student_gender',
                title: '性别',
                align: 'center'
            }, {
                field: 'student_age',
                title: '年龄',
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
                //删除
                '<button   type="button" class="btn btn-primary btn-xs del_button" id="templateDel_button" data-toggle="modal" title="废除" data-target="#templateDel" style="background:#d9534f;border-color:#d9534f" ><i class="fa fa-times" aria-hidden="true"></i></button>'
            ]

    };


})