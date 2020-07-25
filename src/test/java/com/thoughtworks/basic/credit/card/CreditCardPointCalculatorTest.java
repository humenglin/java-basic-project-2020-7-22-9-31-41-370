package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.CardTypeEnum;
import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreditCardPointCalculatorTest {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Test
    public void should_return_0_points_when_calculate_points_given_pospay_8() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(8));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(BigDecimal.ZERO, actual);
    }

    @Test
    public void should_return_10_points_when_calculate_points_given_pospay_108() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(108));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(10), actual);
    }

    @Test
    public void should_return_20_points_when_calculate_points_given_pospay_208() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(208));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(20), actual);
    }
}