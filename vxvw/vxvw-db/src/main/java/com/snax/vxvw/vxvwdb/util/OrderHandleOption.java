package com.snax.vxvw.vxvwdb.util;

public enum  OrderHandleOption {
    CANCEL("order cancel"),  //取消操作
    DELETE("order delete"),  //删除操作
    PAY("order pay"),        //支付状态
    COMMENT("order comment"), //评论状态
    CONFIRM("order confirm"), //确认状态
    REFUND("order has pay but cancel"), //退款状态
    REBUY("order generator again");   //重新生成订单

    private String option;

    OrderHandleOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
