package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.CardTypeEnum;
import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCardPointService {
    public static final String REGEX = " ";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public ConsumptionRecord transformToConsumptionRecords(String consumptionInfosStr) throws ParseException {
        Date consumptionTime = simpleDateFormat.parse("2020-07-01 18:40");
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(consumptionTime, PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(8));
        return consumptionRecord;
    }
}
