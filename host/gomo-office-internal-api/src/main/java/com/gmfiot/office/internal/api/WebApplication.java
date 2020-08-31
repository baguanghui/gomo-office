package com.gmfiot.office.internal.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



/**
 * web 入口启动类
 * @author ThinkPad
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.gmfiot.office.dao",
        "com.gmfiot.office.service",
        "com.gmfiot.office.internal.api",
        "com.gmfiot.data"
})
@MapperScan("com.gmfiot.office.dao")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
