package com.snax.vxvw.vxvwcore.notify;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 商城服务通知类
 */
public class NotifyService {

    private MailSender mailSender;
    private String sendForm;
    private String sendTo;

    private SmsSender smsSender;
    private List<Map<String,String>> smsTemplate=new ArrayList<>();

    private WxTemplateSender wxTemplateSender;
    private List<Map<String,String>> wxTemplate=new ArrayList<>();

    /**
     * 短信消息通知
     * @param phoneNumber 接收的电话号码
     * @param message 短消息内容
     */
    @Async
    public void notifySms(String phoneNumber,String message){
        if (mailSender==null){
            return;
        }
        smsSender.send(phoneNumber,message);
    }

    /**
     * 短信消息通知
     * @param phoneNumber
     * @param type
     * @param params 模板
     */
    @Async
    public void notifySmsTemplate(String phoneNumber,NotifyType type,String[] params){
        if (mailSender==null){
            return;
        }
        int templateId=Integer.parseInt(getTemplateId(type,smsTemplate));
        smsSender.sendWithTemplate(phoneNumber,templateId,params);
    }

    /**
     * 以同步的方式发送短信模版消息通知
     *
     * @param phoneNumber 接收通知的电话号码
     * @param notifyType  通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params      通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     * @return
     */
    public SmsResult notifySmsTemplateSync(String phoneNumber,NotifyType notifyType,String[] params){
        if (smsSender==null){
            return null;
        }
        int templateId=Integer.parseInt(getTemplateId(notifyType,smsTemplate));
        return smsSender.sendWithTemplate(phoneNumber,templateId,params);
    }

    /**
     * 微信模版消息通知,不跳转
     * <p>
     * 该方法会尝试从数据库获取缓存的FormId去发送消息
     *
     * @param toUser     接收者openId
     * @param notifyType 通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params     通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     */
    @Async
    public void notifyWxTemplate(String toUser,NotifyType notifyType,String[] params){
        if (wxTemplateSender==null){
            return;
        }
        String tamplateId=getTemplateId(notifyType,wxTemplate);
        wxTemplateSender.sendWechatMsg(toUser,tamplateId,params);
    }

    /**
     * 微信模版消息通知，带跳转
     * <p>
     * 该方法会尝试从数据库获取缓存的FormId去发送消息
     *
     * @param toUser     接收者openId
     * @param type 通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params     通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     * @param page       点击消息跳转的页面
     */
    @Async
    public void notifyWxTemplate(String toUser,NotifyType type,String[] params,String page){
        if (wxTemplateSender==null){
            return;
        }
        String tamplateId=getTemplateId(type,wxTemplate);
        wxTemplateSender.sendWechatMsg(toUser,tamplateId,params,page);
    }


    /**
     * 邮件消息通知,
     * 接收者在spring.mail.sendto中指定
     *
     * @param subject 邮件标题
     * @param content 邮件内容
     */
    @Async
    public void notifyMail(String subject,String content){
        if (mailSender==null){
            return;
        }
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(sendForm);
        message.setTo(sendTo);
        message.setText(content);
        message.setSubject(subject);
        mailSender.send(message);
    }

    private String getTemplateId(NotifyType type, List<Map<String,String>> smsTemplate) {
        for (Map<String,String> item:smsTemplate){
            String notifyTypeStr=type.getType();
            if (item.get("name").equals(notifyTypeStr)){
                return item.get("templateId");
            }
        }
        return null;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setSendForm(String sendForm) {
        this.sendForm = sendForm;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public void setSmsSender(SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void setSmsTemplate(List<Map<String, String>> smsTemplate) {
        this.smsTemplate = smsTemplate;
    }

    public void setWxTemplateSender(WxTemplateSender wxTemplateSender) {
        this.wxTemplateSender = wxTemplateSender;
    }

    public void setWxTemplate(List<Map<String, String>> wxTemplate) {
        this.wxTemplate = wxTemplate;
    }
}
