package com.fastmoney.fast_money.service.Impl;

import java.util.List;

import com.fastmoney.fast_money.entity.CodeEntity;
import com.fastmoney.fast_money.service.CodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("CodeService")
public class CodeServiceImpl implements CodeService{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<CodeEntity> getAllCode(){
        return mongoTemplate.findAll(CodeEntity.class);
    }

}