package com.rpn.operation;

public class Multiplication implements Operation {

    @Override
    public double execute(double firstValue, double secondValue) {
        return firstValue * secondValue;
    }
}
