package com.cy.student.modules.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 班级信息表
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-24
 */
@TableName("class_table")
public class ClassTable extends Model<ClassTable> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 班级uuid
     */
    private String class_uuid;

    /**
     * 班级名称
     */
    private String class_name;

    /**
     * 班级人数
     */
    private Integer class_number;

    /**
     * 开班时间
     */
    private Date class_start_time;

    /**
     * 班级结束时间
     */
    private Date class_end_time;

    /**
     * 班级负责人id
     */
    private Integer tercher_Headmaster_id;

    /**
     * 讲师id
     */
    private Integer tercher_lecturer_id;

    /**
     * 班级专业id
     */
    private String class_major;

    /**
     * 创建人
     */
    private String create_user_uuid;

    /**
     * 创建时间
     */
    private Date create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getClass_uuid() {
        return class_uuid;
    }

    public void setClass_uuid(String class_uuid) {
        this.class_uuid = class_uuid;
    }
    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    public Integer getClass_number() {
        return class_number;
    }

    public void setClass_number(Integer class_number) {
        this.class_number = class_number;
    }
    public Date getClass_start_time() {
        return class_start_time;
    }

    public void setClass_start_time(Date class_start_time) {
        this.class_start_time = class_start_time;
    }
    public Date getClass_end_time() {
        return class_end_time;
    }

    public void setClass_end_time(Date class_end_time) {
        this.class_end_time = class_end_time;
    }
    public Integer getTercher_Headmaster_id() {
        return tercher_Headmaster_id;
    }

    public void setTercher_Headmaster_id(Integer tercher_Headmaster_id) {
        this.tercher_Headmaster_id = tercher_Headmaster_id;
    }
    public Integer getTercher_lecturer_id() {
        return tercher_lecturer_id;
    }

    public void setTercher_lecturer_id(Integer tercher_lecturer_id) {
        this.tercher_lecturer_id = tercher_lecturer_id;
    }
    public String getClass_major() {
        return class_major;
    }

    public void setClass_major(String class_major) {
        this.class_major = class_major;
    }
    public String getCreate_user_uuid() {
        return create_user_uuid;
    }

    public void setCreate_user_uuid(String create_user_uuid) {
        this.create_user_uuid = create_user_uuid;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ClassTable{" +
        "id=" + id +
        ", class_uuid=" + class_uuid +
        ", class_name=" + class_name +
        ", class_number=" + class_number +
        ", class_start_time=" + class_start_time +
        ", class_end_time=" + class_end_time +
        ", tercher_Headmaster_id=" + tercher_Headmaster_id +
        ", tercher_lecturer_id=" + tercher_lecturer_id +
        ", class_major=" + class_major +
        ", create_user_uuid=" + create_user_uuid +
        ", create_time=" + create_time +
        "}";
    }
}
