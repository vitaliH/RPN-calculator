package com.rpn.operation;

import java.math.BigDecimal;

public class Division implements Operation {

    @Override
    public BigDecimal execute(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.divide(secondValue);
    }
}
