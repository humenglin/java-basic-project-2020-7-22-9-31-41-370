package com.thoughtworks.basic.credit.card;

import java.math.BigDecimal;

public class PosPoint implements CreditCardPoint {
    private BigDecimal perAmount = new BigDecimal(10);

    @Override
    public BigDecimal getPointsByPerAmount(BigDecimal amount) {
        return amount.divide(perAmount,0, BigDecimal.ROUND_FLOOR);
    }
}
