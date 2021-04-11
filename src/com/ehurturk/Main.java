package com.ehurturk;

import java.util.concurrent.TimeUnit;

class Operands {
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String TIMES = "*";
    public static final String DIVISION = "/";

    public static final String[][] OPERANDS = {{"+", "-"}, {"*", "/"}};
}

public class Main {


    public static void main(String[] args) {

        long startTime = System.nanoTime();

        String str = "5+12*1";
        int res = result(str);

        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;

        System.out.println(res);
        System.out.println("Execution in nanosecond: "+ elapsed);
        System.out.println("Execution in milliseconds: "+ elapsed / 1000000);

    }

    static int result(String str) {
        boolean contains = false;
        for (String[] operand : Operands.OPERANDS) {
            for (String op : operand) {
                if (str.contains(op)) {
                    contains = true;
                    break;
                }
            }
        }

        if (!contains) {
            return Integer.parseInt(str);
        }
        int opCounter = 0;
        for (String[] operand : Operands.OPERANDS) {

            if (str.contains(operand[0]) && str.contains(operand[1])) opCounter++;
        }
        String left;
        String right;
        for (String[] operands: Operands.OPERANDS) {
            for (String op: operands) {
                if (str.contains(op))
                {
                    if (opCounter > 1) {
                        // go from left to right
                        // look at index
                        if (str.indexOf(operands[0]) > str.indexOf(operands[1])) {
                            left = str.substring(0, str.indexOf(operands[1])).trim();
                            right = str.substring(str.indexOf(operands[1]) + 1);
                        } else {
                            left = str.substring(0, str.indexOf(operands[0])).trim();
                            right = str.substring(str.indexOf(operands[0]) + 1);
                        }
                    } else {
                        left = str.substring(0, str.indexOf(op)).trim();
                        right = str.substring(str.indexOf(op) + 1);

                    }
                    switch (op) {
                        case Operands.PLUS:
                            return result(left) + result(right);
                        case Operands.MINUS:
                            return result(left) - result(right);
                        case Operands.TIMES:
                            return result(left) * result(right);
                        case Operands.DIVISION:
                            return result(left) / result(right);
                    }
                }
            }
        }
        return Integer.parseInt(str);

    }
}



