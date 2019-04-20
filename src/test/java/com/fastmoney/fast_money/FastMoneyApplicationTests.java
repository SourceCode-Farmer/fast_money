package com.fastmoney.fast_money;

import com.fastmoney.fast_money.entity.SysUserEntity;
import com.fastmoney.fast_money.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastMoneyApplicationTests {
    @Autowired
    SysUserService sysUserService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

    @Test
    public void contextLoads() {
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setName("15916998930");
        sysUserEntity.setPassword("123456");
        sysUserEntity.setCreate_time(new Date());
        sysUserEntity.setEmail("jintao.wu@outlook.com");
        sysUserEntity.setMobile("15916998930");
        try {
            sysUserEntity.setUsing_time(simpleDateFormat.parse("2022-12-12"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sysUserEntity.setState(true);
        sysUserService.addSysUser(sysUserEntity);
    }

}
