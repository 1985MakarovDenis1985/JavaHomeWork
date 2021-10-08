package telran.calculator.model;

import telran.calculator.controller.IOperation;

public class Calculator {

    private static final String PACKAGE = "telran.calculator.model.";

    public static double calc(String ...args) {

        double[] d = new double [args.length-1];
        for (int i = 0; i < args.length-1; i++){
            d[i] = Double.parseDouble(args[i]);
        }
        try {
            Class<?> clazz = Class.forName(PACKAGE + args[args.length-1]);
            IOperation calc = (IOperation) clazz.getDeclaredConstructor().newInstance();
            double res = calc.action(d);
            return res;
        } catch (Exception e) {
            throw new RuntimeException("SomeThing Wrong...");
        }
    }
}
