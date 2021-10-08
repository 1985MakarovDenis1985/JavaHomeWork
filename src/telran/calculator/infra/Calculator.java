package telran.calculator.infra;

public class Calculator {

    private static final String PACKAGE = "telran.calculator.model.";
    public static double calc(String ...args) {

        double[] arrOfArgs = new double [args.length-1];
        for (int i = 0; i < args.length-1; i++){
            arrOfArgs[i] = Double.parseDouble(args[i]);
        }

        try {
            Class<?> clazz = Class.forName(PACKAGE + args[args.length-1]);
            IOperation calc = (IOperation) clazz.getDeclaredConstructor().newInstance();
            return calc.action(arrOfArgs);
        } catch (Exception e) {
            throw new RuntimeException("SomeThing Wrong...");
        }
    }
}
