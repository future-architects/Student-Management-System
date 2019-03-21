package com.cy.student.modules.service.impl;

import com.cy.student.modules.entity.Student_information;
import com.cy.student.modules.mapper.Student_informationMapper;
import com.cy.student.modules.service.IStudent_informationService;
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
 * 学生信息表 服务实现类
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-21
 */
@Service
public class Student_informationServiceImpl extends ServiceImpl<Student_informationMapper, Student_information> implements IStudent_informationService {

    @Autowired
    private DaoUtils<Student_information> dateUtils;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        Object studentname=params.get("student_name");

        String sql = "select sti.*,class.class_name,teacher.teacher_name\n" +
                "from student_information as sti\n" +
                "left join class_table as class on sti.class_id=class.id\n" +
                "left join teacher_information as teacher on sti.guidanceteacher_id=teacher.id where sti.del_flag=0";

        if (CheckUtils.isNotNull(studentname)){
            sql+=" and sti.student_name  like '%"+studentname+"%' ";
        }

        sql += " order by sti.id desc";
        return this.dateUtils.findBySql(sql, PageUtilsFactory.getInstance(params) );
    }

}
