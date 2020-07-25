package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.CardTypeEnum;
import com.thoughtworks.basic.credit.card.enumertion.PaymentPatternEnum;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreditCardPointService {
    public static final String ITEM_REGEX = "\n";
    public static final String REGEX = " ";
    public static final String CURRENCY_UNIT = "元";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private CreditCardPointCalculator creditCardPointCalculator;
    private CreditCardPointPrint creditCardPointPrint;

    public CreditCardPointService(CreditCardPointCalculator creditCardPointCalculator) {
        this.creditCardPointCalculator = creditCardPointCalculator;
    }

    public CreditCardPointService(CreditCardPointCalculator creditCardPointCalculator, CreditCardPointPrint creditCardPointPrint) {
        this.creditCardPointCalculator = creditCardPointCalculator;
        this.creditCardPointPrint = creditCardPointPrint;
    }

    public List<ConsumptionRecord> transformToConsumptionRecords(String consumptionInfosStr) throws ParseException {
        List<ConsumptionRecord> consumptionRecords = new ArrayList<>();
        String[] consumptionItems = consumptionInfosStr.split(ITEM_REGEX);
        for (String consumptionItem: consumptionItems) {
            String[] consumptionInfos = consumptionItem.split(REGEX);

            String dateStr = consumptionInfos[0] + REGEX + consumptionInfos[1];
            Date consumptionTime = simpleDateFormat.parse(dateStr);
            PaymentPatternEnum paymentPattern = PaymentPatternEnum.form(consumptionInfos[2]);
            BigDecimal amount = new BigDecimal(consumptionInfos[3].replace(CURRENCY_UNIT, ""));

            consumptionRecords.add(new ConsumptionRecord(consumptionTime, paymentPattern, CardTypeEnum.NORMAL_CARD, amount));
        }
        return consumptionRecords;
    }

    public BigDecimal getPoints(List<ConsumptionRecord> consumptionRecords) {
        BigDecimal totalPoints = BigDecimal.ZERO;
        for (ConsumptionRecord consumptionRecord: consumptionRecords) {
            totalPoints = totalPoints.add(creditCardPointCalculator.getPoints(consumptionRecord));
        }
        return totalPoints;
    }

    public String print(List<ConsumptionRecord> consumptionRecords) {
        sortConsumptionRecords(consumptionRecords);
        List<BigDecimal> pointList = new ArrayList<>();

        BigDecimal totalPoints = BigDecimal.ZERO;
        for (ConsumptionRecord consumptionRecord : consumptionRecords) {
            BigDecimal itemPoint = BigDecimal.ZERO;
            itemPoint = itemPoint.add(creditCardPointCalculator.getPoints(consumptionRecord));
            totalPoints = totalPoints.add(itemPoint);
            pointList.add(itemPoint);
        }

        return creditCardPointPrint.print(consumptionRecords, pointList);
    }

    private void sortConsumptionRecords(List<ConsumptionRecord> consumptionRecords) {
        Collections.sort(consumptionRecords, new Comparator<ConsumptionRecord>() {
            @Override
            public int compare(ConsumptionRecord o1, ConsumptionRecord o2) {
                return o2.getConsumptionTime().compareTo(o1.getConsumptionTime());
            }
        });
    }
}
