public class HomeWork {

    public static void main(String[] args) {
        int[] arr = new int[10];
        fillArr(arr, 10, 99);
        printArr(arr);
        int minDig = findMin(arr);
        int indexOfMinOfDig = indexOfMin(arr);
        System.out.println("min value: " + minDig);
        System.out.println("index of min value: " + indexOfMinOfDig);

        // --> TAX ISRAEL - solution with recurs and arrays
//        System.out.println();
//        System.out.println("TAX ISRAEL - solution with recurs and arrays: ");
//        double salary = 10000;
//        double indexOfTax = 2.5;
//        double tax = newTax(salary, indexOfTax);
//        System.out.println("tax: " + tax);
    }


    public static int indexOfMin(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (findMin(arr) == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int findMin(int[] arr) {
        int res = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (res > arr[i]) {
                res = arr[i];
            }
        }
        return res;
    }

    public static void fillArr(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (min + Math.random() * (max - min + 1));
        }
        System.out.println();
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }


    //// ------ tax Israel by arrays and recurs ------ ////
    //// ------ Solution with recursion ------ ////
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

