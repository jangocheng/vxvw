package com.snax.vxvw.vxvwcore.notify.config;

import com.snax.vxvw.vxvwcore.notify.NotifyService;
import com.snax.vxvw.vxvwcore.notify.TencentSmsSender;
import com.snax.vxvw.vxvwcore.notify.WxTemplateSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@EnableConfigurationProperties(NotifyProperties.class)
public class NotifyAutoConfiguration {

    private final NotifyProperties properties;

    public NotifyAutoConfiguration(NotifyProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public JavaMailSender mailSender(){
        NotifyProperties.Mail mail=properties.getMail();
        JavaMailSender mailSender=new JavaMailSenderImpl();
        ((JavaMailSenderImpl) mailSender).setHost(mail.getHost());
        ((JavaMailSenderImpl) mailSender).setUsername(mail.getUsername());
        ((JavaMailSenderImpl) mailSender).setPassword(mail.getPassword());
        return mailSender;
    }

    @Bean
    @ConditionalOnMissingBean
    public WxTemplateSender wxTemplateSender(){
        WxTemplateSender wxTemplateSender=new WxTemplateSender();
        return wxTemplateSender;
    }

    @Bean
    @ConditionalOnMissingBean
    public TencentSmsSender tencentSmsSender(){
        return new TencentSmsSender();
    }

    @Bean
    @ConditionalOnMissingBean
    public NotifyService notifyService(){
        NotifyService service=new NotifyService();
        NotifyProperties.Mail mail=properties.getMail();
        if (mail.isEnable()){
            service.setMailSender(mailSender());
            service.setSendForm(mail.getSendfrom());
            /**
             * 该值可以修改，必须被修改
             */
            service.setSendTo(mail.getSendto());
        }
        NotifyProperties.Sms smsConfig = properties.getSms();
        if(smsConfig.isEnable()){
            service.setSmsSender(tencentSmsSender());
            service.setSmsTemplate(smsConfig.getTemplate());
        }

        NotifyProperties.Wx wxConfig = properties.getWx();
        if(wxConfig.isEnable()){
            service.setWxTemplateSender(wxTemplateSender());
            service.setWxTemplate(wxConfig.getTemplate());
        }
        return service;
    }
}
