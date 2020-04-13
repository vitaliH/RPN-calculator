package com.rpn.operation;

public class Addition implements Operation {

    @Override
    public double execute(double firstValue, double secondValue) {
        return firstValue + secondValue;
    }
}
