package telran.calculator.controller;

import telran.calculator.model.Calculator;

public class CalculatorApp {
    public static void main(String[] args) throws NoSuchMethodException {
//        if (args.length > 3 || args.length < 2) {
//            System.out.println("Wrong numbers of argument");
//            return;
//        }

        double a = Calculator.calc(args[0], args[1], args[2], args[args.length - 1]);
        System.out.println(a);

    }
}
