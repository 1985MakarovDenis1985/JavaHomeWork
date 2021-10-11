package telran.calculator.infra;

import java.util.Arrays;

/* If the method should take only one argument, and you passed more, it will take the first one and perform the operation */
public class Calculator {
    private static final String PACKAGE = "telran.calculator.model.";
    public static double calc(String ...args) {

        double[] arrOfArgs = Arrays.stream(args).limit(args.length-1).mapToDouble(Double::parseDouble).toArray();

        try {
            Class<?> clazz = Class.forName(PACKAGE + args[args.length-1]);
            IOperation calc = (IOperation) clazz.getDeclaredConstructor().newInstance();
            return calc.action(arrOfArgs);

        } catch (Exception e) {
            throw new RuntimeException("SomeThing Wrong...");
        }
    }
}
