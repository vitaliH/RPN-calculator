package com.rpn.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void addsTwoNumbersTest() throws OperationNotSupportedException {
        assertEquals(10.0, calculator.calculate("+", 4.5, 5.5));
    }

    @Test
    void subtractsTwoNumbersTest() throws OperationNotSupportedException {
        assertEquals(5.0, calculator.calculate("-", 10.5, 5.5));
    }

    @Test
    void multipliesTwoNumbersTest() throws OperationNotSupportedException {
        assertEquals(55.0, calculator.calculate("*", 10.0, 5.5));
    }

    @Test
    void dividesTwoNumbersTest() throws OperationNotSupportedException {
        assertEquals(2.0, calculator.calculate("/", 10.0, 5.0));
    }


    @Test
    void unsupportedOperationTest() throws OperationNotSupportedException {
        Assertions.assertThrows(OperationNotSupportedException.class, ()->{
            calculator.calculate("%", 10.0, 5.0);
        });
    }
}
