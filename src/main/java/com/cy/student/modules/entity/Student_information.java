package com.cy.student.modules.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 学生信息表
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-19
 */
public class Student_information extends Model<Student_information> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String student_name;

    /**
     * 联系方式
     */
    private String student_phone;

    /**
     * 系别
     */
    private String student_ties;

    /**
     * 专业
     */
    private String student_major;

    /**
     * 班级
     */
    private String student_class;

    /**
     * 性别 0：男，1：女
     */
    private String student_gender;

    /**
     * 年龄
     */
    private Integer student_age;

    /**
     * 是否删除 -1：删除
     */
    private Integer del_flag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }
    public String getStudent_ties() {
        return student_ties;
    }

    public void setStudent_ties(String student_ties) {
        this.student_ties = student_ties;
    }
    public String getStudent_major() {
        return student_major;
    }

    public void setStudent_major(String student_major) {
        this.student_major = student_major;
    }
    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }
    public String getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(String student_gender) {
        this.student_gender = student_gender;
    }
    public Integer getStudent_age() {
        return student_age;
    }

    public void setStudent_age(Integer student_age) {
        this.student_age = student_age;
    }
    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "studentInformation{" +
        "id=" + id +
        ", student_name=" + student_name +
        ", student_phone=" + student_phone +
        ", student_ties=" + student_ties +
        ", student_major=" + student_major +
        ", student_class=" + student_class +
        ", student_gender=" + student_gender +
        ", student_age=" + student_age +
        ", del_flag=" + del_flag +
        "}";
    }
}
