package com.fastmoney.fast_money.service.Impl;

import com.fastmoney.fast_money.entity.SysUserEntity;
import com.fastmoney.fast_money.mapper.SysUserDao;
import com.fastmoney.fast_money.mapper.SysUserRoleDao;
import com.fastmoney.fast_money.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    SysUserRoleDao sysUserRoleDao;

    @Override
    public SysUserEntity findUserByName(String name) {
        return sysUserDao.findUserByName(name);
    }

    @Override
    public List<String> findUserPermissionByUserId(Long id) {
        return sysUserRoleDao.findUserPermissionByUserId(id);
    }

    @Override
    public void addSysUser(SysUserEntity sysUserEntity) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        sysUserEntity.setPassword(encoder.encode(sysUserEntity.getPassword()));
        sysUserDao.addUser(sysUserEntity);
    }

}
