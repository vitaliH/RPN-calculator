package com.rpn.operation;

import java.math.BigDecimal;

public class Multiplication implements Operation {

    @Override
    public BigDecimal execute(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.multiply(secondValue);
    }
}
