package com.fastmoney.fast_money.mapper;

import com.fastmoney.fast_money.entity.SysUserEntity;
import com.fastmoney.fast_money.service.SysUserService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface SysUserDao {

    @Select("SELECT * FROM sys_user WHERE name =#{name}")
    SysUserEntity findUserByName(String name);

    @Insert("INSERT INTO sys_user(name,password,mobile,state,using_time,email,create_time) VALUES (#{name},#{password},#{mobile},#{state},#{using_time},#{email},#{create_time})")
    void addUser(SysUserEntity entity);
}
