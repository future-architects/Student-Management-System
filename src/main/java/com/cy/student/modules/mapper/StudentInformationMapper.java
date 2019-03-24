package com.cy.student.modules.mapper;

import com.cy.student.modules.entity.StudentInformation;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学生信息表 Mapper 接口
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-21
 */
@Mapper
public interface StudentInformationMapper extends BaseMapper<StudentInformation> {

}
