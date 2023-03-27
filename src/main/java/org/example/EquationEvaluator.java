package org.example;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class EquationEvaluator {
    private static final ScriptEngine ENGINE = new ScriptEngineManager().getEngineByName("JEXL");
    public static boolean evaluateEquation(String equation, double rootGuess) {
        String guessedEquation = substituteX(equation, rootGuess);
        String[] splitEquation = splitToSides(guessedEquation);
        Double lhs = evaluateSide(splitEquation[0]);
        Double rhs = evaluateSide(splitEquation[1]);
        return lhs.equals(rhs);
    }

    private static String substituteX(String equation, double guess) {
        return equation.replaceAll("x", String.valueOf(guess));
    }

    private static String[] splitToSides(String equation) {
        return equation.split("=");
    }

    public static Double evaluateSide(String side) {
        try {
            return Double.valueOf(String.valueOf(ENGINE.eval(side)));
        } catch (ScriptException e) {
            throw new IllegalArgumentException("Failed to evaluate equation side: " + side, e);
        }
    }

    public static int countNumericTerms(String equation) {
        return equation.replaceAll("[x+\\-*/=]", " ").split("\\s+").length;
    }
}
