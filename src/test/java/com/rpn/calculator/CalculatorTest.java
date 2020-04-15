package com.rpn.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void addsTwoNumbersTest() throws OperationNotSupportedException {
        assertTrue(    calculator.calculate("+", BigDecimal.valueOf(4.5), BigDecimal.valueOf(5.5)).compareTo(BigDecimal.valueOf(10)) == 0);
    }

    @Test
    void subtractsTwoNumbersTest() throws OperationNotSupportedException {
        assertTrue( calculator.calculate("-", BigDecimal.valueOf(10.5), BigDecimal.valueOf(5.5)).compareTo(BigDecimal.valueOf(5)) == 0);
    }

    @Test
    void multipliesTwoNumbersTest() throws OperationNotSupportedException {
        assertTrue( calculator.calculate("*", BigDecimal.valueOf(10.0), BigDecimal.valueOf(5.5)).compareTo(BigDecimal.valueOf(55)) == 0);
    }

    @Test
    void dividesTwoNumbersTest() throws OperationNotSupportedException {
        assertTrue(calculator.calculate("/", BigDecimal.valueOf(10.0), BigDecimal.valueOf(5.0)).compareTo(BigDecimal.valueOf(2)) == 0);
    }

    @Test
    void unsupportedOperationTest() throws OperationNotSupportedException {
        Assertions.assertThrows(OperationNotSupportedException.class, ()->{
            calculator.calculate("%", BigDecimal.valueOf(10.0), BigDecimal.valueOf(5.0));
        });
    }
}
