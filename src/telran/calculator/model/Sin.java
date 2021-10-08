package telran.calculator.model;

import telran.calculator.controller.IOperation;

public class Sin implements IOperation {
    @Override
    public double action(double... args) {
        return Math.sin(args[0]);
    }
}
