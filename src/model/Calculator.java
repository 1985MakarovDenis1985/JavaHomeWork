package model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {
    //    public void  sum(int a, int b){
//        int res = a + b;
//        System.out.println("Sum : " + a + " + " + b + " = " + res);
//    }
    public void sum(int a, int b) {
        int res = a + b;
        System.out.println("Sum : " + res);
    }

//    public void sub(int a, int b) {
//        int res = a - b;
//        System.out.println("Sum : " + a + " - " + b + " = " + res);
//    }
//
//    public void multiplication(int a, int b) {
//        int res = a * b;
//        System.out.println("Sum : " + a + " * " + b + " = " + res);
//    }
//
//    public void div(int a, int b) {
//        int res = a / b;
//        System.out.println("Sum : " + a + " / " + b + " = " + res);
//    }

//    public void calc(String funName, int firstArg, int secondArg) throws NoSuchMethodException {
//
//        Class<Calculator> clazz = Calculator.class;
//        try {
//            Method method = clazz.getDeclaredMethod(funName, int.class, int.class);
//            method.invoke(this, firstArg, secondArg);
//
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }


}
