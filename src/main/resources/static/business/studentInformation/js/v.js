function studentAddValidator() {
    $('#studentAddFrom').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        excluded: [''],
        fields: {
            student_name: {
                trigger:'blur',
                validators: {
                    notEmpty: {
                        message: '学生姓名不能为空'
                    }
                }
            },
            student_phone: {
                trigger:'blur',
                validators: {
                    notEmpty: {
                        message: '联系方式不能为空'
                    },
                    regexp: {
                        regexp: /^[1][3,4,5,7,8][0-9]{9}$/,
                        message: '请输入正确手机号码'
                    },
                }
            },
            major_id: {
                validators: {
                    notEmpty: {
                        message: '专业不能为空'
                    }
                }
            },
            class_id: {
                validators: {
                    notEmpty: {
                        message: '班级不能为空'
                    }
                }
            },
            student_gender: {
                validators: {
                    notEmpty: {
                        message: '性别不能为空'
                    }
                }
            },
            dateofbirth: {
                trigger:'change',
                validators: {
                    notEmpty: {
                        message: '出生日期不能为空'
                    }
                }
            },
        }
    });

    $("#studentAddModal").on('hidden.bs.modal',function(e){
        $('#studentAddFrom').bootstrapValidator('resetForm', true);
        $('#studentAddFrom')[0].reset();
    });
}

function studentEditValidator() {
    $('#studentEditFrom').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        excluded: [''],
        fields: {
            student_name: {
                trigger:'blur',
                validators: {
                    notEmpty: {
                        message: '学生姓名不能为空'
                    }
                }
            },
            student_phone: {
                trigger:'blur',
                validators: {
                    notEmpty: {
                        message: '联系方式不能为空'
                    },
                    regexp: {
                        regexp: /^[1][3,4,5,7,8][0-9]{9}$/,
                        message: '请输入正确手机号码'
                    },
                }
            },
            major_id: {
                validators: {
                    notEmpty: {
                        message: '专业不能为空'
                    }
                }
            },
            class_id: {
                validators: {
                    notEmpty: {
                        message: '班级不能为空'
                    }
                }
            },
            student_gender: {
                validators: {
                    notEmpty: {
                        message: '性别不能为空'
                    }
                }
            },
            dateofbirth: {
                trigger:'change',
                validators: {
                    notEmpty: {
                        message: '出生日期不能为空'
                    }
                }
            },
        }
    });

    $("#studentEditModal").on('hidden.bs.modal',function(e){
        $('#studentEditFrom').bootstrapValidator('resetForm', true);
        $('#studentEditFrom')[0].reset();
    });
}


studentAddValidator();
studentEditValidator();