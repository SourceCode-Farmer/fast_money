package com.fastmoney.fast_money.service;

import com.fastmoney.fast_money.entity.SysPermissionEntity;

import java.util.List;

public interface SysPermissionService {
    /**
     * 查找所有权限
     * @return
     */
    List<SysPermissionEntity> findAllPermission();

    /**
     *  查找所有的权限
     * @return
     */
    List<SysPermissionEntity> findPathPermission();
}
