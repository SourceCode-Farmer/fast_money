package com.fastmoney.fast_money;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableScheduling
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=86400*30)
@MapperScan("com.fastmoney.fast_money.mapper")
public class FastMoneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastMoneyApplication.class, args);
        }
        }
