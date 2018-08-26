package com.snax.vxvw.vxvwcore;

import com.snax.vxvw.vxvwcore.config.TaskThreadPoolConfig;
import com.snax.vxvw.vxvwcore.config.WxProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"com.snax.vxvw.vxvwdb","com.snax.vxvw.vxvwcore"})
@MapperScan("com.snax.vxvw.vxvwdb.dao")
//开启配置属性支持
@EnableConfigurationProperties({TaskThreadPoolConfig.class,WxProperties.class})
public class VxvwCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(VxvwCoreApplication.class, args);
    }
}
