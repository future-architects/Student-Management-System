package com.cy.student.modules.sys.user.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.student.modules.sys.login.LoginController;
import com.cy.student.modules.sys.user.entity.User;
import com.cy.student.modules.sys.user.service.IUserService;
import com.cy.student.modules.utils.AbstractController;
import com.cy.student.modules.utils.PageUtils;
import com.cy.student.modules.utils.R;
import com.cy.student.modules.utils.md5.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-24
 */
@RestController
@RequestMapping("sys/user")
public class UserController extends AbstractController {

    @Autowired
    private IUserService userService;


    /**
     * 列表
     */
    @PostMapping("/list")
    public void list(@RequestBody Map<String, Object> params , HttpServletResponse response) throws IOException {
        PageUtils page = userService.queryPage(params);
        this.ajaxRequestTable( response, page );
    }

    @RequestMapping("/save")
    public R save(@RequestBody User user){
        user.setPassword(MD5Utils.getMD5Code(user.getPassword()));
        user.setCreate_date(new Date());
        boolean insert = userService.insert(user);
        if (insert==true){
            return R.ok("操作成功");
        }else {
            return R.error("操作失败");
        }
    }


    @PostMapping("/is")
    public R currentUser(@RequestBody Map<String,Object> param){
        Object username = param.get("username");
//        User user1 = userService.selectOne(new EntityWrapper<User>().eq("username", user.getUsername()).eq("password", user.getPassword()));
        if (username!=null){
            return R.ok("登陆成功");
        }
        return R.error("用户名或密码错误");
    }

}
