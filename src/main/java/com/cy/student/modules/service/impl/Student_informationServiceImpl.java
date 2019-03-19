package com.cy.student.modules.service.impl;

import com.cy.student.modules.entity.Student_information;
import com.cy.student.modules.mapper.Student_informationMapper;
import com.cy.student.modules.service.IStudent_informationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.student.modules.utils.PageUtils;
import com.cy.student.modules.utils.dao.DaoUtils;
import com.cy.student.modules.utils.factory.PageUtilsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  学生信息服务实现类
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-19
 */
@Service
public class Student_informationServiceImpl extends ServiceImpl<Student_informationMapper, Student_information> implements IStudent_informationService {
    @Autowired
    private DaoUtils<Student_information> daoUtils;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String sql ="select * from student_information";

        sql+=" order by id desc";
        return this.daoUtils.findBySql(sql, PageUtilsFactory.getInstance(params) );
    }
}
