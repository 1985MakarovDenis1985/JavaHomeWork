package telran.calculator.controller;

import telran.calculator.infra.Calculator;

public class CalculatorApp {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Wrong numbers of argument");
            return;
        }
        try {
            String operation = args[args.length - 1];
            double res = Calculator.calc(args[0], args[1], args[2], args[3], operation);
            System.out.println("res : " + res);
        } catch (NumberFormatException e) {
            System.out.println("Format was Wrong");
        } catch (Exception e) {
            System.out.println("SomeThing Wrong...");
        }

    }
}
