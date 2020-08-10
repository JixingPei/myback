package com.oldpei.myback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot Application class.
 *
 * @author jixing.pei
 * @version 1.0
 */
@SpringBootApplication
@MapperScan("com.oldpei.myback.dao")
public class MybackApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybackApplication.class, args);
    }
}
