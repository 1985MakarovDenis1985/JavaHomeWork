public class HomeWork {

    public static void main(String[] args) {
        int[] arr = new int[10];
        printArr(arr);
        revArrVoid(arr);
        System.out.println("--- old arr ---");
        printArr(arr);
        System.out.println("--- fun revers");
        reversArr(arr);
        System.out.println("--- old arr ---");
        printArr(arr);


        // --> TAX ISRAEL - solution with recurs and arrays
        System.out.println();
        System.out.println("TAX ISRAEL - solution with recurs and arrays: ");
        double salary = 10000;
        double indexOfTax = 2.5;
        double tax = newTax(salary, indexOfTax);
        System.out.println("tax: " + tax);
    }

    public static void revArrVoid(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(i * i + "\t");
        }
        System.out.println();
    }
    public static int[] reversArr(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = ((arr.length - 1) - i) * ((arr.length - 1) - i);
        }
        return arr;
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }


    /// ------ tax Israel by arrays and recurs


    //// ------------  Solution with recursion ------------ ////
    private static int posOfSalary = 0;
    private static double tax;

    public static double newTax(double salary, double index) {
        double[] posSal = {6000, 9000, 14580, 20260, 42160, 54300};
        double[] posTax = {0.1, 0.14, 0.2, 0.31, 0.35, 0.47, 0.5};
        double idx = -(index * 219);

        if (posOfSalary == posSal.length - 1) {
            tax = (salary - posSal[posOfSalary]) * posTax[posOfSalary + 1] + tax + (posSal[0] * posTax[0]) + idx;
        } else if (salary >= posSal[posOfSalary] && salary >= posSal[posOfSalary + 1]) {
            tax = (posSal[posOfSalary + 1] - posSal[posOfSalary]) * posTax[posOfSalary + 1] + tax;
            posOfSalary += 1;
            newTax(salary, index);
        } else if (salary >= posSal[posOfSalary] && salary < posSal[posOfSalary + 1]) {
            tax = ((salary - posSal[posOfSalary]) * posTax[posOfSalary + 1] + tax) + (posSal[0] * posTax[0]) + idx;
        } else if (salary <= posSal[0]) {
            tax = (salary) * posTax[posOfSalary] + tax + idx;
        }
        tax = (tax <= 0) ? tax = 0 : tax;
        return tax;
    }
}

