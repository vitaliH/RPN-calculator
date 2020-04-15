package com.rpn.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RPNCalculatorTest {
    private static Stack<String> calculatorStack = new Stack<>();
    private static RPNCalculator rpnCalculator = new RPNCalculator(calculatorStack);

    @BeforeEach
    public void prepareTest() {
        calculatorStack.removeAllElements();
        calculatorStack.push("90");
        calculatorStack.push("3");
        calculatorStack.push("3");
    }

    @Test
    void addsTwoNumbersTest() throws OperationNotSupportedException {
        calculatorStack.push("+");
        assertTrue(rpnCalculator.calculate().compareTo(BigDecimal.valueOf(96)) == 0);
    }

    @Test
    void subtractsTwoNumbersTest() throws OperationNotSupportedException {
        calculatorStack.push("-");
        assertTrue(rpnCalculator.calculate().compareTo(BigDecimal.valueOf(84)) == 0);
    }

    @Test
    void multipliesTwoNumbersTest() throws OperationNotSupportedException {
        calculatorStack.push("*");
        assertTrue(rpnCalculator.calculate().compareTo(BigDecimal.valueOf(810)) == 0);
    }

    @Test
    void dividesTwoNumbersTest() throws OperationNotSupportedException {
        calculatorStack.push("/");
        assertTrue(rpnCalculator.calculate().compareTo(BigDecimal.valueOf(10)) == 0);
    }

    @Test
    void unsupportedOperationTest() throws OperationNotSupportedException {
        calculatorStack.push("%");
        Assertions.assertThrows(OperationNotSupportedException.class, () -> rpnCalculator.calculate());
    }
}
