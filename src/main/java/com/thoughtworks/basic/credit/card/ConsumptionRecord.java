package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.CardTypeEnum;
import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;

import java.math.BigDecimal;
import java.util.Date;

public class ConsumptionRecord {
    private Date consumptionTime;
    private PaymentPatternEnum paymentPattern;
    private CardTypeEnum cardType;
    private BigDecimal amount;

    public ConsumptionRecord(Date consumptionTime, PaymentPatternEnum paymentPattern, CardTypeEnum cardType, BigDecimal amount) {
        this.consumptionTime = consumptionTime;
        this.paymentPattern = paymentPattern;
        this.cardType = cardType;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
