package com.rpn.operation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Division implements Operation {

    @Override
    public BigDecimal execute(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.divide(secondValue, 2, RoundingMode.HALF_UP);
    }
}
