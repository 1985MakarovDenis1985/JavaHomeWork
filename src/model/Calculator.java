package model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {
        public void  sum(int a, int b){
        int res = a + b;
        System.out.println("Sum : " + a + " + " + b + " = " + res);
    }

    public void sub(int a, int b) {
        int res = a - b;
        System.out.println("Sub : " + a + " - " + b + " = " + res);
    }

    public void multiplication(int a, int b) {
        int res = a * b;
        System.out.println("Multiplication : " + a + " * " + b + " = " + res);
    }

    public void div(int a, int b) {
        int res = a / b;
        System.out.println("Div : " + a + " / " + b + " = " + res);
    }

    public void calc(String funName, String firstArg, String secondArg) throws NoSuchMethodException {

        Class<?> clazz = Calculator.class;
        try {
            Method method = clazz.getDeclaredMethod(funName, int.class, int.class);
            method.invoke(this, Integer.parseInt(firstArg), Integer.parseInt(secondArg));
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
