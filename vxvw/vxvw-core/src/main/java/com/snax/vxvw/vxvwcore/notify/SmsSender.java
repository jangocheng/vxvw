package com.snax.vxvw.vxvwcore.notify;

public interface SmsSender {

    /**
     * 发送短信
     * @param phone 接收的手机号码
     * @param content 发送的内容
     * @return
     */
    SmsResult send(String phone,String content);

    /***
     * 通过短信模板发送短消息
     * @param phone 接收手机号码
     * @param templateId 模板id
     * @param params 通知模板里面的参数
     * @return
     */
    SmsResult sendWithTemplate(String phone,int templateId,String[] params);
}
