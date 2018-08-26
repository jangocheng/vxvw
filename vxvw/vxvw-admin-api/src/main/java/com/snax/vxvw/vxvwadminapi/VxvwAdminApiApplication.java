package com.snax.vxvw.vxvwadminapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.snax.vxvw.vxvwcore","com.snax.vxvw.vxvwadminapi","com.snax.vxvw.vxvwdb"})
@MapperScan(value = "com.snax.vxvw.vxvwdb.dao")
public class VxvwAdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VxvwAdminApiApplication.class, args);
    }
}
