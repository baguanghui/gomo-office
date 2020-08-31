package com.gmfiot.office.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gmfiot.office.dao"
        ,"com.gmfiot.office.service"
        ,"com.gmfiot.office.web"})
@MapperScan("com.gmfiot.office.dao")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}