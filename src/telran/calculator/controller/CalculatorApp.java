package telran.calculator.controller;

import telran.calculator.infra.Calculator;

public class CalculatorApp {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Wrong numbers of argument");
            return;
        }
        try {
            double res = Calculator.calc(args);
            System.out.println("res : " + res);
        } catch (NumberFormatException e) {
            System.out.println("Format was Wrong");
        } catch (Exception e) {
            System.out.println("SomeThing Wrong...");
        }

    }
}
