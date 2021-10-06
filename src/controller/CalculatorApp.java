package controller;

import model.Calculator;

public class CalculatorApp {
    public static void main(String[] args) throws NoSuchMethodException {
        if (args.length != 3){
            System.out.println("Wrong numbers of argument");
            return;
        }

        Calculator calculator = new Calculator();
        calculator.calc(args[0], args[1], args[2]);
    }
}
