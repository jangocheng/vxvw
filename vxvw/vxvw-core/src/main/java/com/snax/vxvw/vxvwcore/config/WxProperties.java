package com.snax.vxvw.vxvwcore.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 微信配置
 */
@ConfigurationProperties(prefix = "spring.vxvm.wx")
@Data
public class WxProperties {

    private String appId;
    private String appSecret;
    private String mchId;
    private String mchKey;
    private String notifyUrl;

}
