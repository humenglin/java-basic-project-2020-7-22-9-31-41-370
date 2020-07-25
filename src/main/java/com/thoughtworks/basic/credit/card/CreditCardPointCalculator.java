package com.thoughtworks.basic.credit.card;

import com.thoughtworks.basic.credit.card.enumertion.QuickPayPoint;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreditCardPointCalculator {
    private List<CreditCardPoint> creditCardPointList = new ArrayList<CreditCardPoint>(Arrays.asList(new PosPoint(), new WeChatPoint(), new QuickPayPoint(), new InstallmentPoint()));

    public BigDecimal getPoints(ConsumptionRecord consumptionRecord) {
        BigDecimal totalPoints = BigDecimal.ZERO;
        BigDecimal perPoints = BigDecimal.ZERO;
        BigDecimal incentivePoints = BigDecimal.ZERO;
        for (CreditCardPoint creditCardPoint: creditCardPointList) {
            perPoints = perPoints.add(creditCardPoint.getPointsByPerAmount(consumptionRecord));
            incentivePoints = incentivePoints.add(creditCardPoint.getIncentivePoints(consumptionRecord));
        }
        return totalPoints.add(perPoints).add(incentivePoints);
    }
}
