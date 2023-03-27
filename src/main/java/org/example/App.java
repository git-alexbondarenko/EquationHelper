package org.example;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        EquationDAO dao = new EquationDAO();

        System.out.println("Choose operation: \n" +
                "1 - enter and evaluate equation \n" +
                "2 - search for equation by root value \n" +
                "3 - search for equation by number of roots");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1":
                System.out.println("Enter equation: \n");
                String equationString = scanner.nextLine().replaceAll(" ", "");
                if (EquationValidator.validateEquation(equationString)) {
                    Equation equation = new Equation();
                    equation.setEquation(equationString);
                    equation.setNumberOfVariables(EquationValidator.getNumberOfVariables(equationString));

                    System.out.println("Equation has " +
                            EquationEvaluator.countNumericTerms(equationString) + " numeric terms");

                    System.out.println("Enter guess for root: \n");
                    double rootGuess = Double.parseDouble((scanner.nextLine()));

                    if (EquationEvaluator.evaluateEquation(equationString, rootGuess)) {
                        equation.setRoot(rootGuess);
                        System.out.println("Correct root, root saved");
                    } else {
                        System.out.println("Incorrect root, root not saved");
                    }
                    dao.save(equation);
                    break;
                }
            case "2":
                System.out.println("Enter root: ");
                listPrinter(dao.findByRoot(Double.parseDouble((scanner.nextLine()))));
                break;
            case "3":
                System.out.println("Enter number of variables: ");
                listPrinter(dao.findByNumberOfVariables(Integer.parseInt((scanner.nextLine()))));

                break;
            default:
                System.out.println("Not valid operation, enter int");
        }
    }

    private static void listPrinter(List<Equation> equationList) {
        for (Equation equation: equationList) {
            System.out.println(equation);
        }
    }
}
