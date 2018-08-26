package com.snax.vxvw.vxvwcore.express.config;

import com.snax.vxvw.vxvwcore.express.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ExpressProperties.class)
public class ExpressAutoConfiguration {

    private ExpressProperties properties;

    public ExpressAutoConfiguration(ExpressProperties properties) {
        this.properties = properties;
    }

    @Bean
    public ExpressService expressService(){
        ExpressService service=new ExpressService();
        service.setProperties(properties);
        return service;
    }
}
