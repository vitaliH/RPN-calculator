package com.rpn.calculator;


import com.rpn.operation.*;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Calculator {
    private Map<String, Operation> operations;

    public Calculator() {
        operations = initOperations();
    }

    private Map<String, Operation> initOperations() {
        Map<String, Operation> operationMap = new HashMap<>();
        operationMap.put("+", new Addition());
        operationMap.put("-", new Subtraction());
        operationMap.put("*", new Multiplication());
        operationMap.put("/", new Division());
        return operationMap;
    }

    public BigDecimal calculate(String operation, BigDecimal firstOperand, BigDecimal secondOperand) throws OperationNotSupportedException {
        Operation desiredOperation = Optional.ofNullable(operations.get(operation))
                .orElseThrow(() -> new OperationNotSupportedException());

        return desiredOperation.execute(firstOperand, secondOperand);
    }

    public boolean isOperationSupported(String operation) {
        return operations.get(operation) != null;
    }
}
