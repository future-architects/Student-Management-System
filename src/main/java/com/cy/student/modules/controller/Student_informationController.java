package com.cy.student.modules.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.student.modules.entity.Student_information;
import com.cy.student.modules.service.IStudent_informationService;
import com.cy.student.modules.utils.AbstractController;
import com.cy.student.modules.utils.PageUtils;
import com.cy.student.modules.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 学生信息表 前端控制器
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-21
 */
@RestController
@RequestMapping("business/student_information")
public class Student_informationController extends AbstractController {

    @Autowired
    private IStudent_informationService student_informationService;

    /**
     * 列表
     */
    @PostMapping("/list")
    public void list(@RequestBody Map<String, Object> params , HttpServletResponse response) throws IOException {
        PageUtils page = student_informationService.queryPage(params);
        this.ajaxRequestTable( response, page );
    }

    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") Integer id){
        Student_information selectOne = student_informationService.selectOne(new EntityWrapper<Student_information>().eq("id", id));
        selectOne.setDel_flag(-1);
        boolean b = student_informationService.updateById(selectOne);
        if (b==true){
            return R.ok("操作成功");
        }else {
            return R.error("操作失败");
        }
    }

    @RequestMapping("/info/{id}")
    public Student_information info(@PathVariable("id") Integer id){
        Student_information selectOne = student_informationService.selectOne(new EntityWrapper<Student_information>().eq("id", id));
        return selectOne;
    }

    @RequestMapping("/update")
    public R update(@RequestBody Student_information student_information){
        student_information.setDel_flag(0);
        boolean insert = student_informationService.updateById(student_information);
        if (insert==true){
            return R.ok("操作成功");
        }else {
            return R.error("操作失败");
        }
    }

    @RequestMapping("/save")
    public R save(@RequestBody Student_information student_information){
        student_information.setDel_flag(0);
        boolean insert = student_informationService.insert(student_information);
        if (insert==true){
            return R.ok("操作成功");
        }else {
            return R.error("操作失败");
        }
    }




}
