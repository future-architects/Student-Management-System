package com.cy.student.modules.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.student.modules.entity.Student_information;
import com.cy.student.modules.service.IStudent_informationService;
import com.cy.student.modules.utils.AbstractController;
import com.cy.student.modules.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 *  学生信息
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-19
 */
@RestController
@RequestMapping("/student_information")
public class Student_informationController extends AbstractController {

    @Autowired
    private IStudent_informationService iStudent_informationService;

    @PostMapping("/list")
    public void list(@RequestBody Map<String, Object> params , HttpServletResponse response) throws IOException {
        PageUtils page = iStudent_informationService.queryPage(params);
        this.ajaxRequestTable( response, page );
    }
    @RequestMapping("/info/{id}")
    public Student_information info(@PathVariable("id")Integer id){
        Student_information id1 = iStudent_informationService.selectOne(new EntityWrapper<Student_information>().eq("id", id));
        return id1;
    }

}
