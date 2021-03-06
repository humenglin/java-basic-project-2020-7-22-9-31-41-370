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

    @Test
    public void should_return_30_points_when_calculate_points_given_quick_pay_208() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(208));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(30), actual);
    }

    @Test
    public void should_return_320_points_when_calculate_points_given_quick_pay_2208() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(2208));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(320), actual);
    }

    @Test
    public void should_return_0_points_when_calculate_points_given_installment__pay_8() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.INSTALLMENT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(8));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(0), actual);
    }

    @Test
    public void should_return_499_points_when_calculate_points_given_installment__pay_4999() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.INSTALLMENT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(4999));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(499), actual);
    }

    @Test
    public void should_return_600_points_when_calculate_points_given_installment__pay_5000() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.INSTALLMENT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(5000));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(600), actual);
    }

    @Test
    public void should_return_15_points_when_calculate_points_given_pospay_and_gold_card_and_108() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(108));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(15), actual);
    }

    @Test
    public void should_return_1_points_when_calculate_points_given_wechat_pay_and_gold_card_and_22() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(22));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(1), actual);
    }

    @Test
    public void should_return_3_points_when_calculate_points_given_wechat_pay_and_gold_card_and_50() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(50));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(3), actual);
    }

    @Test
    public void should_return_12_points_when_calculate_points_given_quick_pay_and_gold_card_and_80() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(80));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(12), actual);
    }

    @Test
    public void should_return_430_points_when_calculate_points_given_quick_pay_and_gold_card_and_2208() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(2208));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(430), actual);
    }

    @Test
    public void should_return_748_points_when_calculate_points_given_installment_and_gold_card_and_pay_4999() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.INSTALLMENT_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(4999));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(748), actual);
    }

    @Test
    public void should_return_850_points_when_calculate_points_given_installment_and_gold_card_and_pay_5000() throws ParseException {
        CreditCardPointCalculator calculator = new CreditCardPointCalculator();
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.INSTALLMENT_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(5000));

        BigDecimal actual = calculator.getPoints(consumptionRecord);

        Assert.assertEquals(new BigDecimal(850), actual);
    }
}
