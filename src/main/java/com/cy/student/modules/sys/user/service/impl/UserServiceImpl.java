package com.cy.student.modules.sys.user.service.impl;

import com.cy.student.modules.sys.user.entity.User;
import com.cy.student.modules.sys.user.mapper.UserMapper;
import com.cy.student.modules.sys.user.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
