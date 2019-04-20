package com.fastmoney.fast_money.service;

import java.util.List;

import com.fastmoney.fast_money.entity.CodeEntity;

public interface CodeService {

    /**
     * 查询股票代码
     * @return
     */
    List<CodeEntity> getAllCode();
}