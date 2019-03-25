package com.cy.student.modules.sys.user.service;

import com.cy.student.modules.sys.user.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.cy.student.modules.utils.PageUtils;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-24
 */
public interface IUserService extends IService<User> {

    PageUtils queryPage(Map<String, Object> params);

}
