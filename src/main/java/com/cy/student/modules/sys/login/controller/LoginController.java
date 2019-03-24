package com.cy.student.modules.sys.login.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.student.modules.sys.user.entity.User;
import com.cy.student.modules.sys.user.service.IUserService;
import com.cy.student.modules.utils.R;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/login")
public class LoginController {

    @Autowired
    private IUserService iUserService;

    public R login(@RequestBody User user){
        User user1 = iUserService.selectOne(new EntityWrapper<User>().eq("username", user.getUsername()).eq("del_flag", 0));
        if (user1==null){
            return R.error("用户名不存在!");
        }else if (!user.getUsername().equals(user1.getUsername())&&!user.getPassword().equals(user1.getPassword())){
            return R.error("用户名或密码错误!");
        }else {

        }
        return null;

    }


}
