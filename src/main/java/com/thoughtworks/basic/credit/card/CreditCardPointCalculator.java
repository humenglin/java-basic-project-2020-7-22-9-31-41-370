package com.thoughtworks.basic.credit.card;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreditCardPointCalculator {
    private List<CreditCardPoint> creditCardPointList = new ArrayList<CreditCardPoint>(Arrays.asList(new PosPoint(), new WeChatPoint()));

    public BigDecimal getPoints(ConsumptionRecord consumptionRecord) {
        BigDecimal totalPoints = BigDecimal.ZERO;
        for (CreditCardPoint creditCardPoint: creditCardPointList) {
            totalPoints = totalPoints.add(creditCardPoint.getPointsByPerAmount(consumptionRecord));
        }
        return totalPoints;
    }
}
