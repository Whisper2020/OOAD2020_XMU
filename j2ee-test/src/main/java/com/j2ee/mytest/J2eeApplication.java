package com.j2ee.mytest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.j2ee.mytest.mapper")
@SpringBootApplication
public class J2eeApplication {

    public static void main(String[] args) {
        SpringApplication.run(J2eeApplication.class, args);
    }

}
