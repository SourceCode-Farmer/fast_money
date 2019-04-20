package com.fastmoney.fast_money.service.Impl;

import com.fastmoney.fast_money.entity.SysPermissionEntity;
import com.fastmoney.fast_money.mapper.SysPermissionDao;
import com.fastmoney.fast_money.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    SysPermissionDao sysPermissionDao;

    @Override
    public List<SysPermissionEntity> findAllPermission() {
        return sysPermissionDao.findAllPermission();
    }

    @Override
    public List<SysPermissionEntity> findPathPermission() {
        return sysPermissionDao.findPathPermission();
    }
}
