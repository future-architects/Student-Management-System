package com.cy.student.modules.sys.login;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.student.modules.config.WebSecurityConfig;
import com.cy.student.modules.sys.user.entity.User;
import com.cy.student.modules.sys.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

/**
 * Created by huangds on 2017/10/24.
 */
@Controller
//@RequestMapping("sys/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY)String account, Model model){

        return "main.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/main")
    public String main(){
        return "main.html";
    }

    @PostMapping("/loginVerify")
    public String loginVerify(String username,String password, HttpSession session){

        User user1 = userService.selectOne(new EntityWrapper<User>().eq("username", username).eq("password", password));
        if (user1!=null) {
            session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
            return "redirect:/main";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
