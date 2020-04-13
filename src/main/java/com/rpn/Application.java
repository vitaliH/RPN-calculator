package com.rpn;

import com.rpn.client.RPNCalculatorClient;
import com.rpn.client.impl.CommandLineRunner;

import javax.naming.OperationNotSupportedException;

public class Application {
    public static void main(String[] args) throws OperationNotSupportedException {
        RPNCalculatorClient rpnCalculatorClient = new CommandLineRunner();
        rpnCalculatorClient.launch();
    }
}
