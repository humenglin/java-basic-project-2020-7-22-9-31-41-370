package com.thoughtworks.basic.credit.card;

import java.math.BigDecimal;
import java.util.List;

public class HtmlPrint implements CreditCardPointPrint {
    public static final String ITEM_REGEX = "\n";
    public static final String REGEX = " ";

    @Override
    public String print(List<ConsumptionRecord> consumptionRecords, List<BigDecimal> pointList) {
        StringBuilder printStr = new StringBuilder();
        StringBuilder itemStr = new StringBuilder();
        BigDecimal totalPoints = BigDecimal.ZERO;
        for (int i = 0; i < consumptionRecords.size(); i++) {
            totalPoints = totalPoints.add(pointList.get(i));
            itemStr.append("<p>").append(consumptionRecords.get(i).print()).append("，").append(REGEX)
                    .append("积分").append(REGEX).append("<b>+").append(pointList.get(i)).append("</b></p>").append(ITEM_REGEX);
        }

        return printStr.append("<h2>总积分：<b>").append(totalPoints.toString()).append("</b></h2>").append(ITEM_REGEX).append(itemStr).toString();
    }
}
