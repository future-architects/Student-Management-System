package com.cy.student.modules.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 教师信息表
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-24
 */
@TableName("teacher_information")
public class TeacherInformation extends Model<TeacherInformation> {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 教师姓名
     */
    private String teacher_name;

    /**
     * 教师性别
     */
    private Integer teacher_sex;

    /**
     * 教师工号
     */
    private Integer teacher_id;

    /**
     * 教师电话
     */
    private String teacher_phone;

    /**
     * 所属班级
     */
    private Integer teacher_class;

    /**
     * 地址
     */
    private String teacher_address;

    /**
     * 教师状态
     */
    private Integer delete_flag;

    /**
     * 入职时间
     */
    private Date teacher_entrytime;

    /**
     * 薪水
     */
    private BigDecimal teacher_salary;

    /**
     * 教师级别
     */
    private Integer teacher_level;

    private Date create_time;

    private Date update_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }
    public String getTeacher_phone() {
        return teacher_phone;
    }

    public void setTeacher_phone(String teacher_phone) {
        this.teacher_phone = teacher_phone;
    }
    public Integer getTeacher_class() {
        return teacher_class;
    }

    public void setTeacher_class(Integer teacher_class) {
        this.teacher_class = teacher_class;
    }
    public String getTeacher_address() {
        return teacher_address;
    }

    public void setTeacher_address(String teacher_address) {
        this.teacher_address = teacher_address;
    }
    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }
    public Date getTeacher_entrytime() {
        return teacher_entrytime;
    }

    public void setTeacher_entrytime(Date teacher_entrytime) {
        this.teacher_entrytime = teacher_entrytime;
    }
    public BigDecimal getTeacher_salary() {
        return teacher_salary;
    }

    public void setTeacher_salary(BigDecimal teacher_salary) {
        this.teacher_salary = teacher_salary;
    }
    public Integer getTeacher_level() {
        return teacher_level;
    }

    public void setTeacher_level(Integer teacher_level) {
        this.teacher_level = teacher_level;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getTeacher_sex() {
        return teacher_sex;
    }

    public void setTeacher_sex(Integer teacher_sex) {
        this.teacher_sex = teacher_sex;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TeacherInformation{" +
                "id=" + id +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_sex=" + teacher_sex +
                ", teacher_id=" + teacher_id +
                ", teacher_phone='" + teacher_phone + '\'' +
                ", teacher_class=" + teacher_class +
                ", teacher_address='" + teacher_address + '\'' +
                ", delete_flag=" + delete_flag +
                ", teacher_entrytime=" + teacher_entrytime +
                ", teacher_salary=" + teacher_salary +
                ", teacher_level=" + teacher_level +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
