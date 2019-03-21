function studentAddValidator() {
    $('#studentAddFrom').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        excluded: [''],
        fields: {
            contractualCapacity: {
                validators: {
                    notEmpty: {
                        message: '履约能力评分不能为空'
                    },greaterThan: {
                        value : 0,
                        message: '最小输入0'
                    },lessThan: {
                        value : 50,
                        message : '最大输入50'
                    },

                }
            },
            creditStanding: {
                validators: {
                    notEmpty: {
                        message: '信誉情况评分不能为空'
                    },greaterThan: {
                        value : 0,
                        message: '最小输入0'
                    },lessThan: {
                        value : 25,
                        message : '最大输入25'
                    },

                }
            },
            serviceAttitude: {
                validators: {
                    notEmpty: {
                        message: '服务态度评分不能为空'
                    },greaterThan: {
                        value : 0,
                        message: '最小输入0'
                    },lessThan: {
                        value : 25,
                        message : '最大输入25'
                    },

                }
            },
        }
    });

    $("#contractmodel").on('hidden.bs.modal',function(e){
        $('#contractscorefrom').bootstrapValidator('resetForm', true);
        $('#contractscorefrom')[0].reset();
    });
}