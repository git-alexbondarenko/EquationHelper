package org.example;

public class EquationValidator {

    public static boolean validateEquation(String equation) {
        if (!isParenthesisMatch(equation)) {
            System.out.println("some parenthesis missing");
            return false;
        }
        if (!isParenthesisInCorrectPlace(equation)) {
            System.out.println("parenthesis placed incorrectly");
            return false;
        }
        if (!isSignCorrect(equation)) {
            System.out.println("some signs placed incorrectly");
            return false;
        }
        return true;
    }

    public static boolean isParenthesisMatch(String equation) {
        int diff = 0;
        for (char c : equation.toCharArray()) {
            if (c == '(') {
                diff++;
            } else if (c == ')') {
                diff--;
            }
            if (diff < 0) {
                return false;
            }
        }
        return diff == 0;
    }

    public static boolean isParenthesisInCorrectPlace(String equation) {
        String acceptableCharsBeforeClosingBracket = "0123456789x";
        String acceptableCharsAfterOpeningBracket = acceptableCharsBeforeClosingBracket + "-";

        for (int i = 0; i < equation.length() - 1; i++) {
            char currentChar = equation.charAt(i);
            char nextChar = equation.charAt(i + 1);
            if (currentChar == '(' && !acceptableCharsAfterOpeningBracket.contains(String.valueOf(nextChar))) {
                return false;
            } else if (currentChar == ')' && !acceptableCharsBeforeClosingBracket
                    .contains(String.valueOf(equation.charAt(i - 1)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSignCorrect(String equation) {
        String invalidSignsAfterSign = "+*/";
        String signs = invalidSignsAfterSign + "-";
        for (int i = 0; i < equation.length(); i++) {
            char currentChar = equation.charAt(i);
            if (signs.contains(String.valueOf(currentChar)) &&
                    invalidSignsAfterSign.contains(String.valueOf(equation.charAt(i + 1)))) {
                return false;
            }
        }
        return true;
    }

    public static int getNumberOfVariables(String equation) {
        int numberOfVariables = 0;
        for (char c : equation.toCharArray()) {
            if (c == 'x') {
                numberOfVariables++;
            }
        }
        return numberOfVariables;
    }
}
