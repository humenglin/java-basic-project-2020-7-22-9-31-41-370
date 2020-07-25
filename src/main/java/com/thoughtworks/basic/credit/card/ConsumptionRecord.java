package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.CardTypeEnum;
import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsumptionRecord {
    private Date consumptionTime;
    private PaymentPatternEnum paymentPattern;
    private CardTypeEnum cardType;
    private BigDecimal amount;

    public static final String REGEX = " ";
    public static final String CURRENCY_UNIT = "元";

    public ConsumptionRecord(Date consumptionTime, PaymentPatternEnum paymentPattern, CardTypeEnum cardType, BigDecimal amount) {
        this.consumptionTime = consumptionTime;
        this.paymentPattern = paymentPattern;
        this.cardType = cardType;
        this.amount = amount;
    }

    public Date getConsumptionTime() {
        return consumptionTime;
    }

    public PaymentPatternEnum getPaymentPattern() {
        return paymentPattern;
    }

    public CardTypeEnum getCardType() {
        return cardType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public StringBuilder print() {
        StringBuilder itemStr = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        itemStr.append(simpleDateFormat.format(consumptionTime)).append(REGEX)
                .append(paymentPattern.getDesc()).append(REGEX)
                .append(amount.toString()).append(CURRENCY_UNIT);

        return itemStr;
    }
}
