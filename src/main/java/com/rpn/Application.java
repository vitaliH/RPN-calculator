package com.rpn;

import com.rpn.client.RPNClient;
import com.rpn.client.impl.CommandLineRunner;

import javax.naming.OperationNotSupportedException;

public class Application {
    public static void main(String[] args) throws OperationNotSupportedException {
        RPNClient rpnClient = new CommandLineRunner();
        rpnClient.launch();
    }
}
