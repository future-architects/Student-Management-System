package com.cy.student.modules.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 * 学生信息表
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-21
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
     * 专业id
     */
    private String major_id;

    /**
     * 班级id
     */
    private String class_id;

    /**
     * 性别 0：男，1：女
     */
    private String student_gender;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateofbirth;

    /**
     * 是否删除 -1：删除
     */
    private Integer del_flag;

    /**
     * 指导教师id
     */
    private Integer guidanceteacher_id;

    /**
     * 备注
     */
    private String remark;

    /**
     * 入学时间
     */
    private Date entrancetime;

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
    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }
    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }
    public String getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(String student_gender) {
        this.student_gender = student_gender;
    }
    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }
    public Integer getGuidanceteacher_id() {
        return guidanceteacher_id;
    }

    public void setGuidanceteacher_id(Integer guidanceteacher_id) {
        this.guidanceteacher_id = guidanceteacher_id;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Date getEntrancetime() {
        return entrancetime;
    }

    public void setEntrancetime(Date entrancetime) {
        this.entrancetime = entrancetime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Student_information{" +
        "id=" + id +
        ", student_name=" + student_name +
        ", student_phone=" + student_phone +
        ", major_id=" + major_id +
        ", class_id=" + class_id +
        ", student_gender=" + student_gender +
        ", dateofbirth=" + dateofbirth +
        ", del_flag=" + del_flag +
        ", guidanceteacher_id=" + guidanceteacher_id +
        ", remark=" + remark +
        ", entrancetime=" + entrancetime +
        "}";
    }
}
