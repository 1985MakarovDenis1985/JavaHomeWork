package telran.calculator.model;

import telran.calculator.controller.IOp;
import telran.calculator.controller.IOperation;

public class Calculator {

    private static final String PACKAGE = "telran.calculator.model.";

    public static double calc(String... arg) {
        for (String s : arg){
            System.out.print(s + " | ");
            System.out.println();
        }
        try {
            Class<?> clazz = Class.forName(PACKAGE + arg[arg.length-1]);
            IOperation calc = (IOperation) clazz.getDeclaredConstructor().newInstance();
//            double res = calc.action(a, b);
//            return res;

        } catch (Exception e) {
            throw new RuntimeException("SomeThing Wrong...");
        }

        return 0.0;
    }


    // ------------------------- //
    public static double calculate(String o1, String o2, String o3) {
        double a = Double.parseDouble(o1);
        double b = Double.parseDouble(o2);
        try {
            Class<?> clazz = Class.forName(PACKAGE + o3);
            IOperation calc = (IOperation) clazz.getDeclaredConstructor().newInstance();
            double res = calc.action(a, b);
            return res;

        } catch (Exception e) {
            throw new RuntimeException("SomeThing Wrong...");
        }
    }

    public static double calculate(String o1, String o2) {
        double a = Double.parseDouble(o1);
        try {
            Class<?> clazz = Class.forName(PACKAGE + o2);
            IOp calc = (IOp) clazz.getDeclaredConstructor().newInstance();
            double res = calc.action(a);
            return res;

        } catch (Exception e) {
            throw new RuntimeException("SomeThing Wrong...");
        }
    }
}
