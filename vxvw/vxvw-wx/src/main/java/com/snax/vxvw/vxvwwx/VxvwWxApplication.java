package com.snax.vxvw.vxvwwx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.snax.vxvw"})
@MapperScan("com.snax.vxvw.vxvwdb")
public class VxvwWxApplication {

    public static void main(String[] args) {
        SpringApplication.run(VxvwWxApplication.class, args);
    }
}
