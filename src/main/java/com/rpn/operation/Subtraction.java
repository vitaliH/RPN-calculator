package com.rpn.operation;

import java.math.BigDecimal;

public class Subtraction implements Operation {

    @Override
    public BigDecimal execute(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.subtract(secondValue);
    }
}
