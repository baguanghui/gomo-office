package com.gmfiot.office.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * web 入口启动类
 * @author ThinkPad
 */
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.gmfiot.office.scheduler"
})
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
