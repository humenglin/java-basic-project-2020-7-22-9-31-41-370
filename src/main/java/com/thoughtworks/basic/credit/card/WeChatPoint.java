package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;

import java.math.BigDecimal;

public class WeChatPoint implements CreditCardPoint {
    private BigDecimal perAmount = new BigDecimal(20);

    @Override
    public BigDecimal getPointsByPerAmount(ConsumptionRecord consumptionRecord) {
        if (PaymentPatternEnum.WECHAT_PAY == consumptionRecord.getPaymentPattern()) {
            return consumptionRecord.getAmount().divide(perAmount, 0, BigDecimal.ROUND_FLOOR);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getIncentivePoints(ConsumptionRecord consumptionRecord) {
        return BigDecimal.ZERO;
    }
}
