package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;
import org.junit.Assert;
import org.junit.Test;

public class PaymentPatternEnumTest {
    @Test
    public void should_return_POS_PAY_given_POS机消费() {
        String desc = "POS机消费";
        PaymentPatternEnum paymentPatternEnum = PaymentPatternEnum.form(desc);
        Assert.assertEquals(PaymentPatternEnum.POS_PAY, paymentPatternEnum);
    }

    @Test
    public void should_return_WECHAT_PAY_given_微信支付消费() {
        String desc = "微信支付消费";
        PaymentPatternEnum paymentPatternEnum = PaymentPatternEnum.form(desc);
        Assert.assertEquals(PaymentPatternEnum.WECHAT_PAY, paymentPatternEnum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_return_POS_PAY_given_other消费() {
        String desc = "other消费";
        PaymentPatternEnum.form(desc);
    }
}
