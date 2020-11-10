package com.j2ee.mytest;

import org.mybatis.spring.annotation.MapperScan;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.j2ee.mytest.mapper")
class J2eeApplicationTests {

    @Test
    void contextLoads() {
    }

}
