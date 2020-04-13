package com.rpn.calculator;


import javax.naming.OperationNotSupportedException;
import java.util.Stack;

public class RPNCalculator {
    private Calculator calculator = new Calculator();
    private Stack<String> calculationData;

    public RPNCalculator(Stack<String> calculationData) {
        this.calculationData = calculationData;
    }

    public Double calculate() throws OperationNotSupportedException {
        String operation = calculationData.pop();
        double firstValue, secondValue;
        double result = Double.parseDouble(calculationData.pop());

        while (!calculationData.isEmpty()) {
            firstValue = result;
            secondValue = Double.parseDouble(calculationData.pop());
            result = calculator.calculate(operation, firstValue, secondValue);
        }
        return result;
    }

    public boolean isOperationSupported(String operation) {
        return calculator.isOperationSupported(operation);
    }
}
