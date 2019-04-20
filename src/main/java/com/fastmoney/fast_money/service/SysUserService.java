package com.fastmoney.fast_money.service;

import com.fastmoney.fast_money.entity.SysUserEntity;

import java.util.List;

public interface SysUserService {
    /**
     * 通过用户名查找用户
     * @param name
     * @return
     */
    SysUserEntity findUserByName(String name);

    /**
     *  通过用户ID查找其拥有的权限
     * @param id
     * @return
     */
    List<String> findUserPermissionByUserId(Long id);

    /**
     * 添加一个用户
     * @param sysUserEntity
     */
    void addSysUser(SysUserEntity sysUserEntity);
}
