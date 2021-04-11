package com.ehurturk;

public class Parser {
    public static int parseInput(String str) {
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
                            return parseInput(left) + parseInput(right);
                        case Operands.MINUS:
                            return parseInput(left) - parseInput(right);
                        case Operands.TIMES:
                            return parseInput(left) * parseInput(right);
                        case Operands.DIVISION:
                            return parseInput(left) / parseInput(right);
                    }
                }
            }
        }
        return Integer.parseInt(str);

    }
}
