package com.cy.student.modules.sys.user.controller;


import com.cy.student.modules.sys.user.entity.User;
import com.cy.student.modules.sys.user.service.IUserService;
import com.cy.student.modules.utils.R;
import com.cy.student.modules.utils.md5.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-24
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping("/save")
    public R save(@RequestBody User user){
//        user.setPassword(MD5Utils.getMD5Code());
        boolean insert = userService.insert(user);
        if (insert==true){
            return R.ok("操作成功");
        }else {
            return R.error("操作失败");
        }
    }


}
