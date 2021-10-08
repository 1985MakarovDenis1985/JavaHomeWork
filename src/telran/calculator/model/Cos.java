package telran.calculator.model;

import telran.calculator.controller.IOperation;

public class Cos implements IOperation {
    @Override
    public double action(double... args) {
        return Math.cos(args[0]);
    }
}

