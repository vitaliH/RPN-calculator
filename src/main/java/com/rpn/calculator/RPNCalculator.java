package com.rpn.calculator;


import org.apache.commons.lang3.math.NumberUtils;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;
import java.util.Stack;

public class RPNCalculator {
    private Calculator calculator = new Calculator();
    private Stack<String> calculationData;

    public RPNCalculator(Stack<String> calculationData) {
        this.calculationData = calculationData;
    }

    public BigDecimal calculate() throws OperationNotSupportedException {
        validateData(calculationData);
        String operation = calculationData.pop();
        BigDecimal firstValue, secondValue;
        BigDecimal result = BigDecimal.valueOf(Double.parseDouble(calculationData.firstElement()));
        calculationData.remove(calculationData.firstElement());

        while (!calculationData.isEmpty()) {
            firstValue = result;
            secondValue = BigDecimal.valueOf(Double.parseDouble(calculationData.firstElement()));
            calculationData.remove(calculationData.firstElement());
            result = calculator.calculate(operation, firstValue, secondValue);
        }

        return result;
    }

    public boolean isOperationSupported(String operation) {
        return calculator.isOperationSupported(operation);
    }

    private void validateData(Stack<String> data) {
        for (int i = 0; i < data.size(); i++) {
            String dataItem = data.get(i);
            if (!NumberUtils.isParsable(dataItem) && !isOperationSupported(dataItem)) {
                data.remove(dataItem);
            }
        }

        if (!isOperationSupported(data.peek())) {
            throw new IllegalArgumentException("Stack top element should  arithmetic operations: `+`, `-`, `/`, `*`");
        }
    }
}
