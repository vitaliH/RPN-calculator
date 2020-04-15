package com.rpn.client.impl;

import com.rpn.calculator.RPNCalculator;
import com.rpn.client.RPNCalculatorClient;
import org.apache.commons.lang3.math.NumberUtils;

import javax.naming.OperationNotSupportedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class CommandLineRunner implements RPNCalculatorClient {
    private static final String COMMAND_EXTRACTOR_REGEX = "\\s+";
    private static final String CLEAR_STACK_COMMAND = "clear";
    private static final String STOP_APPLICATION_COMMAND = "q";
    private static final int STATUS = 0;

    private Stack<String> calculatorStack;
    private RPNCalculator rpnCalculator;
    private Scanner scanner;

    public CommandLineRunner() {
        calculatorStack = new Stack();
        rpnCalculator = new RPNCalculator(calculatorStack);
        scanner = new Scanner(System.in);
    }

    @Override
    public void launch() {
        System.out.println("RPN Calculator is started, please execute Your calculations!\n");

        try {
            while (true) {
                System.out.print(">");
                String[] commands = scanner.nextLine().split(COMMAND_EXTRACTOR_REGEX);

                for (String command : commands) {
                    if (command.equalsIgnoreCase(CLEAR_STACK_COMMAND)) {
                        calculatorStack.removeAllElements();
                    } else if (command.equalsIgnoreCase(STOP_APPLICATION_COMMAND)) {
                        System.exit(STATUS);
                    } else if (!command.isEmpty() && (NumberUtils.isParsable(command) || rpnCalculator.isOperationSupported(command))) {
                        calculatorStack.push(command);
                        System.out.println(command);
                    } else {
                        System.out.println("Not valid input! Only numbers and next operations: `+`, `-`, `/`, `*`");
                    }

                    if (calculatorStack.size() >= 3) {
                        if (!NumberUtils.isParsable(calculatorStack.peek())
                                && rpnCalculator.isOperationSupported(calculatorStack.peek())) {
                            Double result = rpnCalculator.calculate();
                            calculatorStack.push(String.valueOf(result));
                            if (result % 1 == 0) {
                                System.out.println(result.intValue());
                            } else {
                                System.out.println(result);
                            }
                        }
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("You have closed calculator");
            System.exit(STATUS);
        } catch (OperationNotSupportedException e) {
            System.out.println("This operation is not implemented, please try `+`, `-`, `*`, `/`");
            calculatorStack.removeAllElements();
            launch();
        } catch (Exception e) {
            System.out.println("Oops, something went wrong, please calculate once again");
            calculatorStack.removeAllElements();
            launch();
        }
    }
}
