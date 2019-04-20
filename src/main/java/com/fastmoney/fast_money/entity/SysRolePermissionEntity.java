package com.fastmoney.fast_money.entity;

/**
 * @author 10990866
 */
public class SysRolePermissionEntity {
    /**
     * 主键
     */
    private Long id;
    /**
     * 角色
     */
    private Long role_id;
    /**
     * 权限表ID
     */
    private Long permission_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Long permission_id) {
        this.permission_id = permission_id;
    }
}
