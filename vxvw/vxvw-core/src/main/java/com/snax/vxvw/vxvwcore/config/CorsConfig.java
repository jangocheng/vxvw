package com.snax.vxvw.vxvwcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
/**
 * 配置跨域支持
 */
public class CorsConfig {

    private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        /**
         * 1、设置允许访问的源地址
         */
        corsConfiguration.addAllowedOrigin("*");
        /**
         * 2、设置允许访问的源请求头
         */
        corsConfiguration.addAllowedHeader("*");
        /**
         * 3、设置允许访问的请求方法
         * get put post delete option
         */
        corsConfiguration.addAllowedMethod("*");

        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        /**
         * 4、对访问的restful api接口配置跨域设置
         */
        source.registerCorsConfiguration("/**",buildConfig());
        return new CorsFilter(source);

    }
}
