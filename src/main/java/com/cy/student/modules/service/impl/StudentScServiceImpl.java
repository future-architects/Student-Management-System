package com.cy.student.modules.service.impl;

import com.cy.student.modules.entity.StudentSc;
import com.cy.student.modules.mapper.StudentScMapper;
import com.cy.student.modules.service.IStudentScService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生成绩表 服务实现类
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-24
 */
@Service
public class StudentScServiceImpl extends ServiceImpl<StudentScMapper, StudentSc> implements IStudentScService {

}
