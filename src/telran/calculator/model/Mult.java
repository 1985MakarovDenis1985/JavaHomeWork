package telran.calculator.model;

import telran.calculator.controller.IOperation;

public class Mult implements IOperation {
    @Override
    public double action(double a, double b) {
        return a * b;
    }
}
