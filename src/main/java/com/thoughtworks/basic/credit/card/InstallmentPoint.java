package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.CardTypeEnum;
import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;

import java.math.BigDecimal;

public class InstallmentPoint implements CreditCardPoint {
    private BigDecimal perAmount = new BigDecimal(10);
    private BigDecimal upperConsumptionAmount = new BigDecimal(5000);
    private BigDecimal incentivePoints = new BigDecimal(100);
    private BigDecimal goldRate = new BigDecimal(0.5);

    @Override
    public BigDecimal getPointsByPerAmount(ConsumptionRecord consumptionRecord) {
        if (PaymentPatternEnum.INSTALLMENT_PAY == consumptionRecord.getPaymentPattern()) {
            return consumptionRecord.getAmount().divide(perAmount, 0, BigDecimal.ROUND_FLOOR);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getIncentivePoints(ConsumptionRecord consumptionRecord) {
        if (PaymentPatternEnum.INSTALLMENT_PAY == consumptionRecord.getPaymentPattern()) {
            return consumptionRecord.getAmount().compareTo(upperConsumptionAmount) < 0 ? BigDecimal.ZERO : incentivePoints;
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getGoldPoints(ConsumptionRecord consumptionRecord) {
        if (PaymentPatternEnum.INSTALLMENT_PAY == consumptionRecord.getPaymentPattern() && CardTypeEnum.GOLD_CARD == consumptionRecord.getCardType()) {
            return getPointsByPerAmount(consumptionRecord).multiply(goldRate).setScale(0, BigDecimal.ROUND_FLOOR);
        }
        return BigDecimal.ZERO;
    }
}
