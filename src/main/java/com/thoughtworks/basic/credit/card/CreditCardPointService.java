package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.CardTypeEnum;
import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCardPointService {
    public static final String REGEX = " ";
    public static final String CURRENCY_UNIT = "元";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public ConsumptionRecord transformToConsumptionRecords(String consumptionInfosStr) throws ParseException {
        String[] consumptionInfos = consumptionInfosStr.split(REGEX);

        String dateStr = consumptionInfos[0] + REGEX + consumptionInfos[1];
        Date consumptionTime = simpleDateFormat.parse(dateStr);
        PaymentPatternEnum paymentPattern = PaymentPatternEnum.form(consumptionInfos[2]);
        BigDecimal amount = new BigDecimal(consumptionInfos[3].replace(CURRENCY_UNIT, ""));

        ConsumptionRecord consumptionRecord = new ConsumptionRecord(consumptionTime, paymentPattern, CardTypeEnum.NORMAL_CARD, amount);
        return consumptionRecord;
    }
}
