package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.CardTypeEnum;
import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CreditCardPointServiceTest {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    CreditCardPointService service = new CreditCardPointService(new CreditCardPointCalculator());

    @Test
    public void should_return_ConsumptionRecord_when_transform_to_ConsumptionRecords_given_consumptionInfosStr() throws ParseException {
        String consumptionInfosStr = "2020-07-01 18:40 POS机消费 8元";
        Date consumptionTime = simpleDateFormat.parse("2020-07-01 18:40");
        ConsumptionRecord consumptionRecord = new ConsumptionRecord(consumptionTime, PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(8));
        List<ConsumptionRecord> expected = Arrays.asList(consumptionRecord);

        List<ConsumptionRecord> actual = service.transformToConsumptionRecords(consumptionInfosStr);

        Assertions.assertThat(actual.size()).isEqualTo(expected.size());
        for (int i = 0; i < actual.size(); i++) {
            Assertions.assertThat(actual.get(i)).isEqualToComparingFieldByField(expected.get(i));
        }
    }

    @Test
    public void should_return_ConsumptionRecords_when_transform_to_ConsumptionRecords_given_consumptionInfosStr() throws ParseException {
        String consumptionInfosStr = "2020-07-01 18:40 POS机消费 8元\n" +
                "2020-07-01 18:50 POS机消费 108元\n" +
                "2020-07-02 18:50 POS机消费 208元";
        ConsumptionRecord consumptionRecord1 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:40"), PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(8));
        ConsumptionRecord consumptionRecord2 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(108));
        ConsumptionRecord consumptionRecord3 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(208));
        List<ConsumptionRecord> expected = Arrays.asList(consumptionRecord1, consumptionRecord2, consumptionRecord3);

        List<ConsumptionRecord> actual = service.transformToConsumptionRecords(consumptionInfosStr);

        Assertions.assertThat(actual.size()).isEqualTo(expected.size());
        for (int i = 0; i < actual.size(); i++) {
            Assertions.assertThat(actual.get(i)).isEqualToComparingFieldByField(expected.get(i));
        }
    }

    @Test
    public void should_return_all_case_ConsumptionRecords_when_transform_to_ConsumptionRecords_given_consumptionInfosStr() throws ParseException {
        String consumptionInfosStr = "2020-07-01 12:20 微信支付消费 25元\n" +
                "2020-07-01 12:50 微信支付消费 18元\n" +
                "2020-07-01 18:50 POS机消费 108元\n" +
                "2020-07-02 08:20 微信支付消费 10元\n" +
                "2020-07-02 12:20 微信支付消费 22元\n" +
                "2020-07-02 18:50 POS机消费 208元\n" +
                "2020-07-02 20:30 快捷支付消费 208元\n" +
                "2020-07-02 22:30 快捷支付消费 2208元\n" +
                "2020-07-02 23:00 信用卡分期购物消费 6400元";
        ConsumptionRecord consumptionRecord1 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 12:20"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(25));
        ConsumptionRecord consumptionRecord2 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 12:50"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(18));
        ConsumptionRecord consumptionRecord3 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(108));
        ConsumptionRecord consumptionRecord4 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 08:20"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(10));
        ConsumptionRecord consumptionRecord5 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 12:20"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(22));
        ConsumptionRecord consumptionRecord6 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(208));
        ConsumptionRecord consumptionRecord7 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 20:30"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(208));
        ConsumptionRecord consumptionRecord8 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 22:30"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(2208));
        ConsumptionRecord consumptionRecord9 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 23:00"), PaymentPatternEnum.INSTALLMENT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(6400));
        List<ConsumptionRecord> expected = Arrays.asList(consumptionRecord1, consumptionRecord2, consumptionRecord3, consumptionRecord4, consumptionRecord5, consumptionRecord6, consumptionRecord7, consumptionRecord8, consumptionRecord9);

        List<ConsumptionRecord> actual = service.transformToConsumptionRecords(consumptionInfosStr);

        Assertions.assertThat(actual.size()).isEqualTo(expected.size());
        for (int i = 0; i < actual.size(); i++) {
            Assertions.assertThat(actual.get(i)).isEqualToComparingFieldByField(expected.get(i));
        }
    }

    @Test
    public void should_return_1122_when_get_points_given_normal_card_consumptionRecords() throws ParseException {
        ConsumptionRecord consumptionRecord1 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 12:20"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(25));
        ConsumptionRecord consumptionRecord2 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 12:50"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(18));
        ConsumptionRecord consumptionRecord3 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(108));
        ConsumptionRecord consumptionRecord4 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 08:20"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(10));
        ConsumptionRecord consumptionRecord5 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 12:20"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(22));
        ConsumptionRecord consumptionRecord6 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(208));
        ConsumptionRecord consumptionRecord7 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 20:30"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(208));
        ConsumptionRecord consumptionRecord8 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 22:30"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(2208));
        ConsumptionRecord consumptionRecord9 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 23:00"), PaymentPatternEnum.INSTALLMENT_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(6400));
        List<ConsumptionRecord> consumptionRecords = Arrays.asList(consumptionRecord1, consumptionRecord2, consumptionRecord3, consumptionRecord4, consumptionRecord5, consumptionRecord6, consumptionRecord7, consumptionRecord8, consumptionRecord9);

        BigDecimal actual = service.getPoints(consumptionRecords);

        Assert.assertEquals(new BigDecimal(1122), actual);
    }

    @Test
    public void should_return_1577_when_get_points_given_golden_card_consumptionRecords() throws ParseException {
        ConsumptionRecord consumptionRecord1 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 12:20"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(25));
        ConsumptionRecord consumptionRecord2 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 12:50"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(18));
        ConsumptionRecord consumptionRecord3 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-01 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(108));
        ConsumptionRecord consumptionRecord4 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 08:20"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(10));
        ConsumptionRecord consumptionRecord5 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 12:20"), PaymentPatternEnum.WECHAT_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(22));
        ConsumptionRecord consumptionRecord6 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 18:50"), PaymentPatternEnum.POS_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(208));
        ConsumptionRecord consumptionRecord7 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 20:30"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(208));
        ConsumptionRecord consumptionRecord8 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 22:30"), PaymentPatternEnum.QUICK_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(2208));
        ConsumptionRecord consumptionRecord9 = new ConsumptionRecord(simpleDateFormat.parse("2020-07-02 23:00"), PaymentPatternEnum.INSTALLMENT_PAY, CardTypeEnum.GOLD_CARD, new BigDecimal(6400));
        List<ConsumptionRecord> consumptionRecords = Arrays.asList(consumptionRecord1, consumptionRecord2, consumptionRecord3, consumptionRecord4, consumptionRecord5, consumptionRecord6, consumptionRecord7, consumptionRecord8, consumptionRecord9);

        BigDecimal actual = service.getPoints(consumptionRecords);

        Assert.assertEquals(new BigDecimal(1577), actual);
    }
}
