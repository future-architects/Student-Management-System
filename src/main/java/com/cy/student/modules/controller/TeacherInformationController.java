package com.cy.student.modules.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.student.modules.entity.StudentInformation;
import com.cy.student.modules.entity.TeacherInformation;
import com.cy.student.modules.service.impl.TeacherInformationServiceImpl;
import com.cy.student.modules.utils.AbstractController;
import com.cy.student.modules.utils.PageUtils;
import com.cy.student.modules.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * 教师信息表 前端控制器
 * </p>
 *
 * @author zpf
 * @since 2019-03-24
 */
@RestController
@RequestMapping("business/teacher_information")
public class TeacherInformationController extends AbstractController {

    @Autowired
    TeacherInformationServiceImpl teacherInformationService;
    @RequestMapping( value = "/list",method = RequestMethod.POST)
    public void list (@RequestBody Map<String,Object> params, HttpServletResponse response) throws IOException {
        PageUtils page = teacherInformationService.queryPage(params);
        this.ajaxRequestTable(response,page);
    }

    @RequestMapping("/add")
    public R addTeacher(@RequestBody TeacherInformation teacherInformation){
        boolean ifAdd = teacherInformationService.insert(teacherInformation);
        teacherInformation.setDelete_flag(0);
        if (ifAdd==true){
          return   R.ok("成功");
        }
        else {
          return   R.error("失败");
        }
    }
    @RequestMapping("/delete")
    public R deleteTeacher(@PathVariable Integer id){
        TeacherInformation teacherInformation = teacherInformationService.selectOne(new EntityWrapper<TeacherInformation>().eq("id",id));
        teacherInformation.setDelete_flag(-1);
        boolean ifDelete = teacherInformationService.updateById(teacherInformation);
        if (ifDelete==true){
            return R.ok("成功");
        }
        else {
            return R.error("失败");
        }
    }
    @RequestMapping("/update")
    public R update(@RequestBody TeacherInformation teacherInformation){
        teacherInformation.setDelete_flag(0);
        boolean update = teacherInformationService.updateById(teacherInformation);
        if (update==true){
            return R.ok("成功");
        }else {
            return R.error("失败");
        }
    }

    @RequestMapping("/info/{id}")
    public TeacherInformation info(@PathVariable("id") Integer id){
        TeacherInformation selectOne = teacherInformationService.selectOne(new EntityWrapper<TeacherInformation>().eq("id", id));
        return selectOne;
    }
}
