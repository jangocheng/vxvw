package com.snax.vxvw.vxvwcore.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信配置
 */
@Configuration
public class WxConfig {

    @Autowired
    private WxProperties properties;

    /**
     * 本机权限token
     * @return
     */
    @Bean
    public WxMaConfig wxMaConfig(){
        WxMaInMemoryConfig config=new WxMaInMemoryConfig();
        config.setAppid(properties.getAppId());
        config.setSecret(properties.getAppSecret());
        return config;
    }

    /**
     * 微信服务接口配置
     * @param config
     * @return
     */
    @Bean
    public WxMaService wxMaService(WxMaConfig config){
        WxMaService service=new WxMaServiceImpl();
        service.setWxMaConfig(config);
        return service;
    }

    /**
     * 微信支付配置
     * @return
     */
    @Bean
    public WxPayConfig wxPayConfig(){
        WxPayConfig wxPayConfig=new WxPayConfig();
        wxPayConfig.setAppId(properties.getAppId());
        wxPayConfig.setMchId(properties.getMchId());
        wxPayConfig.setMchKey(properties.getMchKey());
        wxPayConfig.setNotifyUrl(properties.getNotifyUrl());
        wxPayConfig.setTradeType("JSAPI");
        wxPayConfig.setSignType("MD5");
        return wxPayConfig;
    }

    /**
     * 微信支付接口
     * @param config
     * @return
     */
    @Bean
    public WxPayService wxPayService(WxPayConfig config){
        WxPayService service=new WxPayServiceImpl();
        service.setConfig(config);
        return service;
    }
}
