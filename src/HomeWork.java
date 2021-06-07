public class HomeWork {


    public static void main(String[] args) {
        double salary = 11500;
        double indexOfTax = 2.5;

// --> own solution with recurs
        double tax = newTax(salary, indexOfTax);
        System.out.println("home tax: " + tax);
        double salaryNettoHW = salary - tax;
        System.out.println("home - salaryNetto: " + salaryNettoHW);

//--> solution from lesson
        double res = taxIsrael(salary, indexOfTax);
        System.out.println("class tax: " + res);
        double salaryNettoCW = salaryNetto(salary, res);
        System.out.println("class - salaryNetto: " + salaryNettoCW);
    }

    //// ------------  Solution from lesson ------------ ////
    public static double salaryNetto(double salaryArg, double tax) {
        double salary = salaryArg - tax;
        return salary;
    }

    public static double taxIsrael(double salary, double taxAllowance) {
        double tax = -(taxAllowance * 219);

        if (salary < 6000) {
            double res = tax + salary * 0.1;
            return res > 0 ? res : 0;
        } else {
            tax = tax + 6000 * 0.1;
        }

        if (salary >= 6000 && salary < 9000) {
            double res = tax + (salary - 6000) * 0.14;
            return res > 0 ? res : 0;
        } else {
            tax = tax + (9000 - 6000) * 0.14;
        }

        if (salary >= 9000 && salary < 14580) {
            double res = tax + (salary - 9000) * 0.2;
            return res > 0 ? res : 0;
        } else {
            tax = tax + (14580 - 9080) * 0.2;
        }

        if (salary >= 14580 && salary < 20260) {
            double res = tax + (salary - 14580) * 0.31;
            return res > 0 ? res : 0;
        } else {
            tax = tax + (20260 - 14580) * 0.31;
        }

        if (salary >= 20260 && salary < 42160) {
            double res = tax + (salary - 20260) * 0.35;
            return res > 0 ? res : 0;
        } else {
            tax = tax + (42160 - 20260) * 0.35;
        }

        if (salary >= 42160 && salary < 54300) {
            double res = tax + (salary - 42160) * 0.47;
            return res > 0 ? res : 0;
        } else {
            tax = tax + (54300 - 42160) * 0.47;
        }
        double res = tax + (salary - 54300) * 0.5;
        return res > 0 ? res : 0;
    }


    //// ------------  Solution with recursion ------------ ////
    private static int posOfSalary = 0;
    private static double tax;

    public static double newTax(double salary, double index) {
        double[] posSal = {6000, 9000, 14580, 20260, 42160, 54300};
        double[] posTax = {0.1, 0.14, 0.2, 0.31, 0.35, 0.47, 0.5};
        double idx = - (index * 219);

        if (posOfSalary == posSal.length - 1) {
            tax = (salary - posSal[posOfSalary]) * posTax[posOfSalary + 1] + tax + (posSal[0] * posTax[0]) + idx ;
        } else if (salary >= posSal[posOfSalary] && salary >= posSal[posOfSalary + 1]) {
            tax = (posSal[posOfSalary + 1] - posSal[posOfSalary]) * posTax[posOfSalary + 1] + tax;
            posOfSalary += 1;
            newTax(salary, index);
        } else if (salary >= posSal[posOfSalary] && salary < posSal[posOfSalary + 1]) {
            tax = ((salary - posSal[posOfSalary]) * posTax[posOfSalary +1] + tax) + (posSal[0] * posTax[0]) + idx;
        } else if (salary <= posSal[0]) {
            tax = (salary) * posTax[posOfSalary] + tax + idx;
        }
        tax = (tax <= 0) ? tax = 0 : tax;
        return tax;
    }

}
