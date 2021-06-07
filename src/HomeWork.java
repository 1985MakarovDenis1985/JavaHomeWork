public class HomeWork {


    public static void main(String[] args) {
// --> own solution with recurs
        double tax = index(newTax(500), 1);
        System.out.println("home: " + tax);


//--> solution from lesson
        double salary = 500;
        double res = taxIsrael(salary, 0);
        System.out.println("class: " + res);
//        double salaryNetto = salaryNetto(salary, res);
//        System.out.println(salaryNetto);
    }

    //// ------------  Solution from lesson ------------ ////
    public static double salaryNetto(double salaryArg, double tax) {
        double salary = salaryArg - tax;
        return salary;
    }

    public static double taxIsrael(double salary, double taxAllowance) {
//        double tax = -(taxAllowance * 219);
        double tax = 0;


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
    private static double posOfTax = 0;


    public static double index(double tax, double ind) {
//        double res = tax - (ind * 219);
        double res = tax;
//        return (res < 0) ? 0 : res;
        return res;
    }

    public static double newTax(double salary) {
        double[] posSal = {6000, 9000, 14580, 20260, 42160, 54300};
        double[] posTax = {0.1, 0.14, 0.2, 0.31, 0.35, 0.47, 0.5};
//        double idx = tax-(index * 1);

        if (posOfSalary == posSal.length - 1) {
            tax = (salary - posSal[posOfSalary]) * posTax[posOfSalary + 1] + tax + (posSal[0] * posTax[0]);
//            tax += res;
        } else if (salary >= posSal[posOfSalary] && salary >= posSal[posOfSalary + 1]) {
//            tax = (posSal[0]) * posTax[posOfSalary] + tax;
            tax = (posSal[posOfSalary + 1] - posSal[posOfSalary]) * posTax[posOfSalary + 1] + tax;
//            tax += res;
            posOfSalary += 1;
            posOfTax += 1;
            newTax(salary);
        } else if (salary >= posSal[posOfSalary] && salary < posSal[posOfSalary + 1]) {
            tax = ((salary - posSal[posOfSalary]) * posTax[posOfSalary +1] + tax) + (posSal[0] * posTax[0]);
//            System.out.println(res);
//            tax = res;
        } else if (salary <= posSal[0]) {
            tax = (salary) * posTax[posOfSalary] + tax;
        }
        return tax;
    }

}
