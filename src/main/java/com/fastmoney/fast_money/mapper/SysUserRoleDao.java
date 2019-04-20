package com.fastmoney.fast_money.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserRoleDao {

    /**
     * 通过user Id查找用户的权限
     * @param userId
     * @return
     */
    @Select("SELECT PERMISSION.sys_permission FROM sys_user_role USER_ROLE LEFT JOIN sys_role_permission ROLE_PERMISSION ON USER_ROLE.role_id = ROLE_PERMISSION.role_id LEFT JOIN sys_permission PERMISSION ON ROLE_PERMISSION.permission_id = PERMISSION.id WHERE USER_ROLE.user_id = #{userId}")
    List<String> findUserPermissionByUserId(Long userId);

}
