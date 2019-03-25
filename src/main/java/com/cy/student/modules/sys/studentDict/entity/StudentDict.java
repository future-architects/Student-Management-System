package com.cy.student.modules.sys.studentDict.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 字典管理
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-25
 */
@TableName("student_dict")
public class StudentDict extends Model<StudentDict> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 字典表id
     */
    private String dict_id;

    /**
     * 父级ID
     */
    private String parent_id;

    /**
     * 菜单名称
     */
    private String dict_name;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    private Integer del_flag;

    /**
     * 排序
     */
    private Long order_num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDict_id() {
        return dict_id;
    }

    public void setDict_id(String dict_id) {
        this.dict_id = dict_id;
    }
    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }
    public String getDict_name() {
        return dict_name;
    }

    public void setDict_name(String dict_name) {
        this.dict_name = dict_name;
    }
    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }
    public Long getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Long order_num) {
        this.order_num = order_num;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StudentDict{" +
        "id=" + id +
        ", dict_id=" + dict_id +
        ", parent_id=" + parent_id +
        ", dict_name=" + dict_name +
        ", del_flag=" + del_flag +
        ", order_num=" + order_num +
        "}";
    }
}
