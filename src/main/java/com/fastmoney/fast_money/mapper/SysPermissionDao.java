package com.fastmoney.fast_money.mapper;

import com.fastmoney.fast_money.entity.SysPermissionEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SysPermissionDao {
    /**
     * 查找所有权限
     *
     * @return
     */
    @Select("SELECT * FROM sys_permission WHERE url == null")
    List<SysPermissionEntity> findAllPermission();


    /**
     * 查找所有路径的权限
     * @return
     */
    @Select("SELECT * FROM sys_permission WHERE type = 1")
    List<SysPermissionEntity> findPathPermission();

}
