package com.rpn.operation;

import java.math.BigDecimal;

public interface Operation {

    BigDecimal execute(BigDecimal firstValue, BigDecimal secondValue);
}
