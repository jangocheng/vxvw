package com.snax.vxvw.vxvwcore.notify;

public enum NotifyType {
    PAY_SUCCEED("paysucceed"),
    SHIP("ship"),
    REFUND("refund"),
    CAPTCHA("captcha");

    private String type;

    NotifyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
