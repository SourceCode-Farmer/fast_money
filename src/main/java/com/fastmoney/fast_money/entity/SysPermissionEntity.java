package com.fastmoney.fast_money.entity;

/**
 * @author 10990866
 */
public class SysPermissionEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 类型
     */
    private int type;

    /**
     * 权限名称
     */
    private String name;
    /**
     * 路径
     */
    private String url;
    /**
     * 权限
     */
    private String sys_permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSys_permission() {
        return sys_permission;
    }

    public void setSys_permission(String sys_permission) {
        this.sys_permission = sys_permission;
    }
}
