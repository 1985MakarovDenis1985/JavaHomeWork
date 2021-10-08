package telran.calculator.model;

import telran.calculator.controller.IOperation;

import java.util.Arrays;

public class Div implements IOperation {

    @Override
    public double action(double... args) {
        return Arrays.stream(args).reduce((a, b) -> a / b).orElse(0);
    }
}
