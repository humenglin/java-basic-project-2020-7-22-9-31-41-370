package com.thoughtworks.basic.credit.card;

import java.math.BigDecimal;
import java.util.List;

public interface CreditCardPointPrint {
    String print(List<ConsumptionRecord> consumptionRecords, List<BigDecimal> pointList);
}
