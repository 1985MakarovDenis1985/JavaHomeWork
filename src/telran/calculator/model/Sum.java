package telran.calculator.model;

import telran.calculator.infra.IOperation;

import java.util.Arrays;

public class Sum implements IOperation {
    @Override
    public double action(double ...args) {
        return Arrays.stream(args).sum();
    }
}
