package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task3 {
    public static Logger logger = Logger.getLogger(Task3.class.getName());
        public static void Run() {
            logger.info("Task3 run.");
            System.out.println("Enter first number: ");
            int num1 = getNumber();
            logger.info("Entered number 1: " + num1);
            System.out.println("Enter second number: ");
            int num2 = getNumber();
            logger.info("Entered number 2: " + num2);
            System.out.println("Enter operation: -, +, *, /");
            char operation = getOperation();
            logger.info("Entered operation: " + operation);

            int result = getResult(num1, num2, operation);
            System.out.printf("%d %s %d = %d", num1, operation, num2, result);

        }
        static int getNumber() {
            Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        }

        static char getOperation() {
            Scanner input = new Scanner(System.in);
            return input.next().charAt(0);
        }

        static int getResult(int num1, int num2, char opr) {
            int result = 0;
            switch (opr) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
                default -> System.out.println("Something wrong");
            }
            return result;

        }
}
