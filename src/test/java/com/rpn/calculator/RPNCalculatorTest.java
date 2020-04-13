package com.rpn.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPNCalculatorTest {
    private static Stack<String> calculatorStack = new Stack<>();
    private static RPNCalculator rpnCalculator = new RPNCalculator(calculatorStack);

    @BeforeEach
    public void prepareTest() {
        calculatorStack.removeAllElements();
        calculatorStack.push("3");
        calculatorStack.push("3");
        calculatorStack.push("90");
    }

    @Test
    void addsTwoNumbersTest() throws OperationNotSupportedException {
        calculatorStack.push("+");
        assertEquals(96.0, rpnCalculator.calculate());
    }

    @Test
    void subtractsTwoNumbersTest() throws OperationNotSupportedException {
        calculatorStack.push("-");
        assertEquals(84.0, rpnCalculator.calculate());
    }

    @Test
    void multipliesTwoNumbersTest() throws OperationNotSupportedException {
        calculatorStack.push("*");
        assertEquals(810.0, rpnCalculator.calculate());
    }

    @Test
    void dividesTwoNumbersTest() throws OperationNotSupportedException {
        calculatorStack.push("/");
        assertEquals(10.0, rpnCalculator.calculate());
    }

    @Test
    void unsupportedOperationTest() throws OperationNotSupportedException {
        calculatorStack.push("%");
        Assertions.assertThrows(OperationNotSupportedException.class, () -> rpnCalculator.calculate());
    }
}
