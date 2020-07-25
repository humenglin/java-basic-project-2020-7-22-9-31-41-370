package com.thoughtworks.basic.credit.card.enumertion;

import com.thoughtworks.basic.credit.card.ConsumptionRecord;
import com.thoughtworks.basic.credit.card.CreditCardPoint;

import java.math.BigDecimal;

public class QuickPayPoint implements CreditCardPoint {
    private BigDecimal perAmount = new BigDecimal(10);
    private BigDecimal perIncentiveAmount = new BigDecimal(100);
    private BigDecimal perIncentivePoints = new BigDecimal(5);
    private BigDecimal upperIncentivePoints = new BigDecimal(100);

    @Override
    public BigDecimal getPointsByPerAmount(ConsumptionRecord consumptionRecord) {
        if (PaymentPatternEnum.QUICK_PAY == consumptionRecord.getPaymentPattern()) {
            return consumptionRecord.getAmount().divide(perAmount, 0, BigDecimal.ROUND_FLOOR);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getIncentivePoints(ConsumptionRecord consumptionRecord) {
        if (PaymentPatternEnum.QUICK_PAY == consumptionRecord.getPaymentPattern()) {
            BigDecimal incentivePoints = consumptionRecord.getAmount().divide(perIncentiveAmount, 0, BigDecimal.ROUND_FLOOR).multiply(perIncentivePoints);
            return incentivePoints.compareTo(upperIncentivePoints) < 0 ? incentivePoints : upperIncentivePoints;
        }
        return BigDecimal.ZERO;
    }
}
