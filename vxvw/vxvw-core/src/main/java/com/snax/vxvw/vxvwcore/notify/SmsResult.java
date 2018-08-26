package com.snax.vxvw.vxvwcore.notify;

import lombok.Data;

/**
 * 发送短信返回的结果
 */
@Data
public class SmsResult {
    private boolean successful;
    private Object result;
}
