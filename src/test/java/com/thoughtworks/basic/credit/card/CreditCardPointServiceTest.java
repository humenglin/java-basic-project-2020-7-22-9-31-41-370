package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.CardTypeEnum;
import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;
import org.assertj.core.api.Assertions;
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

    CreditCardPointService service = new CreditCardPointService();

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
}
