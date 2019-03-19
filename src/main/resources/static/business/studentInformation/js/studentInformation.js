var selecttableid="";
$(document).ready(function() {

    var currentpagecount="";
    //收藏、下载、建议、废除、复用-触发
    window.operateEvents = {
        'click .templatesuggestproposal_button': function (e, value, row, index) {
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
        pageSize: 10, //每页的记录行数（*）
        buttonsAlign: "right",
        paginationPreText: '上一页',
        paginationNextText: '下一页',
        uniqueId: "row_id",
        showRefresh: true, //是否显示刷新按钮.
        clickToSelect: true,//是否启用点击选中行
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        locale: 'zh-CN',
        showColumns: true,                  //是否显示所有的列
        pageList: 10,
        //得到查询的参数
        queryParams: function (params) {
            currentpagecount = ((params.offset / params.limit) + 1)
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
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
                    return getOrderNumber("templatecountlist", index)
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

        if (row.del_flag == -2) {
            return [
                //下载
                '<button   type="button" class="btn btn-primary btn-xs download_button" id="download" data-toggle="modal" title="下载附件" ><i class="fa fa-cloud-download" aria-hidden="true"></i></button>' +
                //收藏
                '<button  type="button" class="btn btn-primary btn-xs templateadd_button" id="templateaddButton" data-toggle="modal" data-target="#templatecollection" style="background:#B8860B;border-color:#B8860B" title="收藏" ><i class="fa fa-bookmark" aria-hidden="true"></i></button>' +
                //建议
                '<button   type="button" class="btn btn-primary btn-xs templatesuggestproposal_button" id="templatesuggestproposalsButton" data-toggle="modal" title="使用建议" ><i class="fa fa-envelope" aria-hidden="true"></i></button>' +
                //历史
                '<button   type="button" class="btn btn-primary btn-xs templatehistorytproposal_button" id="templateHistoryButton" data-toggle="modal" title="查看历史" style="background:#B8860B;border-color:#B8860B" ><i class="fa fa-clock-o" aria-hidden="true"></i></button>' +
                //恢复使用
                '<button   type="button" class="btn btn-primary btn-xs templateDelCancel_button" id="templateDelCancel_button" data-toggle="modal" data-target="#templateCancelDel" title="恢复使用" ><i class="fa fa-check" aria-hidden="true"></i></button>'
            ]
        }

    };


})