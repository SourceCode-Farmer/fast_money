package com.fastmoney.fast_money.controller;

import com.fastmoney.fast_money.service.CodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CodeRestController{

    @Autowired
    CodeService codeService;

    @RequestMapping("/code/size")
    public Object getCodeSize(){
        return codeService.getAllCode().size();
    }

    @RequestMapping("/code/list")
    public Object getCodeList(){
        return codeService.getAllCode();
    }


}