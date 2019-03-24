package com.cy.student.modules.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 学生成绩表
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-24
 */
@TableName("student_sc")
public class StudentSc extends Model<StudentSc> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生id
     */
    private Integer student_id;

    /**
     * 班级id
     */
    private Integer class_id;

    /**
     * 专业id
     */
    private Integer major_id;

    /**
     * 成绩
     */
    private String score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }
    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }
    public Integer getMajor_id() {
        return major_id;
    }

    public void setMajor_id(Integer major_id) {
        this.major_id = major_id;
    }
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StudentSc{" +
        "id=" + id +
        ", student_id=" + student_id +
        ", class_id=" + class_id +
        ", major_id=" + major_id +
        ", score=" + score +
        "}";
    }
}
