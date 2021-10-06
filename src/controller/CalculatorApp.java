package controller;

import model.Calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalculatorApp {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (args.length != 3){
            System.out.println("Wrong numbers of argument");
            return;
        }

        Calculator calculator = new Calculator();
        Method method = Calculator.class.getDeclaredMethod(args[0], int.class, int.class);
        method.setAccessible(true);

        method.invoke(calculator, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }
}
