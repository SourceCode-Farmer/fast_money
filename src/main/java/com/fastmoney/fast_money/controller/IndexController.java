package com.fastmoney.fast_money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wujintao
 * @Date: 2018/11/14 22:40
 * @Version: 1.0
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String indexPage(){
        return "index";
    }
}
