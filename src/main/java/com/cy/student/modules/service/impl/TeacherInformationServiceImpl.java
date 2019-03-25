package com.cy.student.modules.service.impl;

import com.cy.student.modules.entity.StudentInformation;
import com.cy.student.modules.entity.TeacherInformation;
import com.cy.student.modules.mapper.TeacherInformationMapper;
import com.cy.student.modules.service.ITeacherInformationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.student.modules.utils.PageUtils;
import com.cy.student.modules.utils.check.CheckUtils;
import com.cy.student.modules.utils.dao.DaoUtils;
import com.cy.student.modules.utils.factory.PageUtilsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 教师信息表 服务实现类
 * </p>
 *
 * @author zpf
 * @since 2019-03-24
 */
@Service
public class TeacherInformationServiceImpl extends ServiceImpl<TeacherInformationMapper, TeacherInformation> implements ITeacherInformationService {

    @Autowired
    private DaoUtils<TeacherInformation> dateUtils;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String sql  ="select t.* ,c.class_name\n" +
                "from teacher_information as t LEFT join class_table as c on t.teacher_class = c.class_number\n" +
                "where t.delete_flag = 0";
        Object tname = params.get("teacher_name");
        Object tid = params.get("teacher_id");
        if (CheckUtils.isNotNull(tname)){
            sql+= "and t.teacher_name like '%"+tname+"%'";
        }
        if (CheckUtils.isNotNull(tid)){
            sql+= "and t.teacher_id = "+tid+"";
        }
        return dateUtils.findBySql(sql, PageUtilsFactory.getInstance(params));
    }
}
