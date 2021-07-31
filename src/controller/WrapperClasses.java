package controller;

public class WrapperClasses {

    public static void main(String[] args) {
        if (args.length >0){
            for (int i = 0; i < args.length; i++) {
                switchType(args[i]);
            }
        }
        else{
            System.out.println("Byte MAX: " + Byte.MAX_VALUE + " | MIN: " + Byte.MIN_VALUE);
            System.out.println("Integer MAX: " + Integer.MAX_VALUE + " | MIN: " + Integer.MIN_VALUE);
            System.out.println("Short MAX: " + Short.MAX_VALUE + " | MIN: " + Short.MIN_VALUE);
            System.out.println("Long MAX: " + Long.MAX_VALUE + " | MIN: " + Long.MIN_VALUE);
            System.out.println("Character MAX: " + Character.MIN_VALUE + " | MIN: " + Character.MIN_VALUE);
            System.out.println("Float MAX: " + Float.MAX_VALUE + " | MIN: " + Float.MIN_VALUE);
            System.out.println("Double MAX: " + Double.MAX_VALUE + " | MIN: " + Double.MIN_VALUE);
        }
    }

    private static void switchType(String args){
        switch (args) {
            case "byte":
                System.out.println("Byte MAX: " + Byte.MAX_VALUE + " | MIN: " + Byte.MIN_VALUE);
                break;
            case "int":
                System.out.println("Integer MAX: " + Integer.MAX_VALUE + " | MIN: " + Integer.MIN_VALUE);
                break;
            case "short":
                System.out.println("Short MAX: " + Short.MAX_VALUE + " | MIN: " + Short.MIN_VALUE);
                break;
            case "long":
                System.out.println("Long MAX: " + Long.MAX_VALUE + " | MIN: " + Long.MIN_VALUE);
                break;
            case "char":
                System.out.println("Character MAX: " + Character.MIN_VALUE + " | MIN: " + Character.MIN_VALUE);
                break;
            case "float":
                System.out.println("Float MAX: " + Float.MAX_VALUE + " | MIN: " + Float.MIN_VALUE);
                break;
            case "double":
                System.out.println("Double MAX: " + Double.MAX_VALUE + " | MIN: " + Double.MIN_VALUE);
                break;
            default:
                System.out.println("Wrong type");
        }
    }
}

