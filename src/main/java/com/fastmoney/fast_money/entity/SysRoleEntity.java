package com.fastmoney.fast_money.entity;

import java.util.Date;

/**
 * @author 10990866
 */
public class SysRoleEntity {
    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 备注
     *
     */
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
