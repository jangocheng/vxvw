package com.snax.vxvw.vxvwcore.express.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "spring.vxvw.express")
@Data
public class ExpressProperties {

    /**
     * 配置是否可用
     */
    private boolean enable;
    private String appId;
    private String appKey;
    /**
     * 商家
     */
    private List<Map<String,String>> vendors=new ArrayList<>();
}
