package com.rpn.operation;

import java.math.BigDecimal;

public class Addition implements Operation {

    @Override
    public BigDecimal execute(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.add(secondValue);
    }
}
