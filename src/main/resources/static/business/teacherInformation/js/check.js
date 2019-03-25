function teacherAddValidator() {
    $('#teacherAddFrom').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        excluded: [''],
        fields: {
            teacher_name: {
                trigger:'blur',
                validators: {
                    notEmpty: {
                        message: '教师姓名不能为空'
                    }
                }
            },
            teacher_id: {
                trigger:'blur',
                validators: {
                    notEmpty: {
                        message: '工号不能为空'
                    }
                }
            }, teacher_address: {
                trigger:'blur',
                validators: {
                    notEmpty: {
                        message: '地址不能为空'
                    }
                }
            },
            teacher_phone: {
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
                        message: '所授专业不能为空'
                    }
                }
            },
            class_id: {
                validators: {
                    notEmpty: {
                        message: '所属班级不能为空'
                    }
                }
            },
            teacher_sex: {
                validators: {
                    notEmpty: {
                        message: '性别不能为空'
                    }
                }
            },
            // dateofbirth: {
            //     trigger:'change',
            //     validators: {
            //         notEmpty: {
            //             message: '出生日期不能为空'
            //         }
            //     }
            // },
        }
    });

    $("#teacherAddModal").on('hidden.bs.modal',function(e){
        $('#teacherAddFrom').bootstrapValidator('resetForm', true);
        $('#teacherAddFrom')[0].reset();
    });
}

function teacherEditValidator() {
    $('#teacherEditFrom').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        excluded: [''],
        fields: {
            teacher_name: {
                trigger:'blur',
                validators: {
                    notEmpty: {
                        message: '教师姓名不能为空'
                    }
                }
            },
            teacher_id: {
                trigger:'blur',
                validators: {
                    notEmpty: {
                        message: '工号不能为空'
                    }
                }
            }, teacher_address: {
                trigger:'blur',
                validators: {
                    notEmpty: {
                        message: '地址不能为空'
                    }
                }
            },
            teacher_phone: {
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
                        message: '所授专业不能为空'
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
            teacher_sex: {
                validators: {
                    notEmpty: {
                        message: '性别不能为空'
                    }
                }
            },
            // dateofbirth: {
            //     trigger:'change',
            //     validators: {
            //         notEmpty: {
            //             message: '出生日期不能为空'
            //         }
            //     }
            // },
        }
    });

    $("#teacherEditModal").on('hidden.bs.modal',function(e){
        $('#teacherEditFrom').bootstrapValidator('resetForm', true);
        $('#teacherEditFrom')[0].reset();
    });
}


teacherAddValidator();
teacherEditValidator();