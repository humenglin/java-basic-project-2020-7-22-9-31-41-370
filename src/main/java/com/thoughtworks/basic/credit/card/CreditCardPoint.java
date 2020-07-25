package com.thoughtworks.basic.credit.card;

import java.math.BigDecimal;

public interface CreditCardPoint {
    BigDecimal getPointsByPerAmount(ConsumptionRecord consumptionRecord);

    BigDecimal getIncentivePoints(ConsumptionRecord consumptionRecord);
}
