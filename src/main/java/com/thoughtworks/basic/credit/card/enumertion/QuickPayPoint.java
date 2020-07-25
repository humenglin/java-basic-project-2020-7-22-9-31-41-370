package com.thoughtworks.basic.credit.card.enumertion;

import com.thoughtworks.basic.credit.card.ConsumptionRecord;
import com.thoughtworks.basic.credit.card.CreditCardPoint;

import java.math.BigDecimal;

public class QuickPayPoint implements CreditCardPoint {
    private BigDecimal perAmount = new BigDecimal(10);

    @Override
    public BigDecimal getPointsByPerAmount(ConsumptionRecord consumptionRecord) {
        if (PaymentPatternEnum.QUICK_PAY == consumptionRecord.getPaymentPattern()) {
            return consumptionRecord.getAmount().divide(perAmount, 0, BigDecimal.ROUND_FLOOR);
        }
        return BigDecimal.ZERO;
    }
}
