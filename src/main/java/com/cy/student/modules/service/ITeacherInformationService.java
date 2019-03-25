package com.cy.student.modules.service;

import com.cy.student.modules.entity.TeacherInformation;
import com.baomidou.mybatisplus.service.IService;
import com.cy.student.modules.utils.PageUtils;

import java.util.Map;

/**
 * <p>
 * 教师信息表 服务类
 * </p>
 *
 * @author zpf
 * @since 2019-03-24
 */
public interface ITeacherInformationService extends IService<TeacherInformation> {

    PageUtils queryPage(Map<String, Object> params);

}
