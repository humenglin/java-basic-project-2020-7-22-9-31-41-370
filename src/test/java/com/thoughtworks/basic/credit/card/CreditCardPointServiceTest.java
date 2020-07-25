package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.CardTypeEnum;
import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCardPointServiceTest {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    CreditCardPointService service = new CreditCardPointService();

    @Test
    public void should_return_ConsumptionRecord_when_transform_to_ConsumptionRecords_given_consumptionInfosStr() throws ParseException {
        String consumptionInfosStr = "2020-07-01 18:40 POS机消费 8元";
        Date consumptionTime = simpleDateFormat.parse("2020-07-01 18:40");
        ConsumptionRecord expected = new ConsumptionRecord(consumptionTime, PaymentPatternEnum.POS_PAY, CardTypeEnum.NORMAL_CARD, new BigDecimal(8));

        ConsumptionRecord actual = service.transformToConsumptionRecords(consumptionInfosStr);

        Assertions.assertThat(actual).isEqualToComparingFieldByField(expected);
    }
}
