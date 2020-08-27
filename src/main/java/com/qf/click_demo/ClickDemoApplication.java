package com.qf.click_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * hello
 */
@SpringBootApplication(scanBasePackages = "com.qf")
@MapperScan("com.qf.dao")
public class ClickDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClickDemoApplication.class, args);
    }

}
