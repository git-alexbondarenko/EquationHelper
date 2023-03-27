package org.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(EquationValidator.isParenthesisInCorrectPlace("(12-4)/3=0"));
        assertTrue(EquationValidator.isParenthesisInCorrectPlace("12-(4/3)=0"));
        assertFalse(EquationValidator.isParenthesisInCorrectPlace("(12-4/3=)0"));
        assertFalse(EquationValidator.isParenthesisInCorrectPlace("12(-4/)3=0"));
        assertFalse(EquationValidator.isParenthesisInCorrectPlace("12()-4/3=0"));

        assertTrue(EquationValidator.isParenthesisMatch("(12-4)/3=0"));
        assertTrue(EquationValidator.isParenthesisMatch("(5443*12)-(4/3)=0"));
        assertFalse(EquationValidator.isParenthesisMatch("((12-4)/3=0"));
        assertFalse(EquationValidator.isParenthesisMatch(")12-4(/3=0"));
        assertFalse(EquationValidator.isParenthesisMatch("(12-4))/3=0"));

        assertTrue(EquationValidator.isSignCorrect("(12*-4/3=0"));
        assertTrue(EquationValidator.isSignCorrect("12/-4/3=0"));
        assertFalse(EquationValidator.isSignCorrect("12*+4/3=0"));
        assertFalse(EquationValidator.isSignCorrect("12*/4/3=0"));
        assertFalse(EquationValidator.isSignCorrect("12**4/3=0"));

        assertTrue(EquationEvaluator.evaluateEquation("10.5 = 2.9 * x - 4", 5));
        assertTrue(EquationEvaluator.evaluateEquation("14=2+x*4", 3));
        assertTrue(EquationEvaluator.evaluateEquation("2.5*x+12*2=34", 4));
        assertTrue(EquationEvaluator.evaluateEquation("2.5*x+12*2+x=38", 4));
    }
}
