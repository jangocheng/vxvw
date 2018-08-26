package com.snax.vxvw.vxvwdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.snax.vxvw.vxvwdb.dao")
public class VxvwDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(VxvwDbApplication.class, args);
    }
}
