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

    @Test
    public void should_return_0_points_when_calculate_points_given_wechat_pay_18() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(18));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(0), actual);
    }

    @Test
    public void should_return_1_points_when_calculate_points_given_wechat_pay_22() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(22));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(1), actual);
    }

    @Test
    public void should_return_0_points_when_calculate_points_given_quick_pay_8() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(8));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(0), actual);
    }

    @Test
    public void should_return_1_points_when_calculate_points_given_quick_pay_12() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(12));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(1), actual);
    }
}
