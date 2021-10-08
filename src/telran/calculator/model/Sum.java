package telran.calculator.model;

import telran.calculator.controller.IOperation;

import java.util.Arrays;

public class Sum implements IOperation {
    @Override
    public double action(double ...arg) {
        double res = 0.0;
        for (double n : arg) {
            res =+ n;
        }

        return res;
    }

}
