package com.fastmoney.fast_money.service.Impl;

import com.fastmoney.fast_money.entity.CodeEntity;
import com.fastmoney.fast_money.entity.CompanyCodeEntity;
import com.fastmoney.fast_money.mapper.CompanyCodeDao;
import com.fastmoney.fast_money.service.CompanyCodeServie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CompanyCodeServie")
public class CompanyCodeServiceImpl implements CompanyCodeServie {

    @Autowired
    CompanyCodeDao companyCodeDao;

    @Override
    public void addCode(CompanyCodeEntity entity) {
        companyCodeDao.addCode(entity);
	}

}