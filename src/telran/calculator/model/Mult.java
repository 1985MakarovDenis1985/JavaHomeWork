package telran.calculator.model;

import telran.calculator.controller.IOperation;

public class Mult implements IOperation {

    @Override
    public double action(double... args) {
        double res = args[0];
        for (int i = 1; i < args.length; i++){
            res *= args[i];
        }
        return res;
    }
}
