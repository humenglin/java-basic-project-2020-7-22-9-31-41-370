package com.thoughtworks.basic.credit.card.enumertion;

public enum PaymentPatternEnum {
    POS_PAY("POS机消费"),
    WECHAT_PAY("微信支付消费"),
    QUICK_PAY("快捷支付消费"),
    INSTALLMENT_PAY("信用卡分期购物消费");

    private String desc;

    PaymentPatternEnum(String desc) {
        this.desc = desc;
    }

    public static PaymentPatternEnum form(String desc) {
        for (PaymentPatternEnum paymentPattern : PaymentPatternEnum.values()) {
            if (desc.equals(paymentPattern.desc)) {
                return paymentPattern;
            }
        }

        throw new IllegalArgumentException("未知的消费类型：" + desc);
    }
}
