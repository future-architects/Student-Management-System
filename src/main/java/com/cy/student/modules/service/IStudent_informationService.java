package com.cy.student.modules.service;

import com.cy.student.modules.entity.Student_information;
import com.baomidou.mybatisplus.service.IService;
import com.cy.student.modules.utils.PageUtils;

import java.util.Map;

/**
 * <p>
 * 学生信息表 服务类
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-21
 */
public interface IStudent_informationService extends IService<Student_information> {

    PageUtils queryPage(Map<String, Object> params);

}
