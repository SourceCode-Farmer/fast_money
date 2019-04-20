package com.fastmoney.fast_money.mapper;

import com.fastmoney.fast_money.entity.CompanyCodeEntity;

import org.apache.ibatis.annotations.Select;

public interface CompanyCodeDao{

    @Select("INSERT INTO company_code (name,symbol,status) VALUES(#{name},#{symbol},#{status})")
    void addCode(CompanyCodeEntity entity);
}