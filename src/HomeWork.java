public class HomeWork {
    private static int s = 0;
    private static double tax = 0;

    public static double newTax(double salary) {
        double[] a = {2000, 3000, 4000, 5000, 6000, 7000};
        double[] b = {0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
        System.out.println(s);


        if (s == a.length - 1) {
            double res = (salary - a[s]) * b[s] + tax;
            System.out.println(res);
            return res;
        } else if (salary > a[s] && salary > a[s + 1]) {
            double res = (a[s + 1] - a[s]) * b[s];
            tax += res;
            System.out.println(tax);
            s = s + 1;
            newTax(salary);
        } else if (salary > a[s] && salary < a[s + 1] ) {
            double res = (salary - a[s]) * b[s] + tax;
            System.out.println(res);
            return res;
        }
        return tax;
    }


    public static void main(String[] args) {
        double x = newTax(9000);
        System.out.println(x);

//        double salary = 8000;
//        double res = taxIsrael(salary, 2.25);
//        System.out.println(res);
//        double salaryNetto = salaryNetto(salary, res);
//        System.out.println(salaryNetto);
//        System.out.println();
    }

    public static double salaryNetto(double salaryArg, double tax) {
        double salary = salaryArg - tax;
        return salary;
    }

    public static double taxIsrael(double salary, double taxAllowance) {
        double tax = -(taxAllowance * 219);


        if (salary < 6330) {
            double res = tax + salary * 0.1;
            return res > 0 ? res : 0;
        } else {
            tax = tax + 6330 * 0.1;
        }

        if (salary >= 6330 && salary < 9080) {
            double res = tax + (salary - 6330) * 0.14;
            return res > 0 ? res : 0;
        } else {
            tax = tax + (9080 - 6330) * 0.14;
        }

        if (salary >= 9080 && salary < 14580) {
            double res = tax + (salary - 9080) * 0.2;
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
}
