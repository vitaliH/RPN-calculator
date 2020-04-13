package com.rpn.operation;

public class Subtraction implements Operation {

    @Override
    public double execute(double firstValue, double secondValue) {
        return firstValue - secondValue;
    }
}
