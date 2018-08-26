package com.snax.vxvw.vxvwcore.notify;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 腾讯云短信服务
 */
@Slf4j
public class TencentSmsSender implements SmsSender{

    private SmsSingleSender smsSingleSender;

    public SmsSingleSender getSmsSingleSender() {
        return smsSingleSender;
    }

    public void setSmsSingleSender(SmsSingleSender smsSingleSender) {
        this.smsSingleSender = smsSingleSender;
    }

    @Override
    public SmsResult send(String phone, String content) {
        try {
            SmsSingleSenderResult result=smsSingleSender.send(0,"86",phone,content,"","");
            log.debug(result.toString());
            SmsResult smsResult=new SmsResult();
            smsResult.setSuccessful(true);
            smsResult.setResult(result);
            return smsResult;
        }catch (HTTPException | IOException e){
            log.error(e.getMessage(),e);
        }
        return null;
    }

    @Override
    public SmsResult sendWithTemplate(String phone, int templateId, String[] params) {
        try {
            SmsSingleSenderResult result=smsSingleSender
                    .sendWithParam("86",phone,templateId,params,"","","");
            log.debug(result.toString());
            SmsResult smsResult=new SmsResult();
            smsResult.setResult(result);
            smsResult.setSuccessful(true);
            return smsResult;
        }catch (HTTPException | IOException e){
            log.error(e.getMessage(),e);
        }
        return null;
    }
}
