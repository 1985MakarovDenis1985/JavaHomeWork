package HW_15.employee;

public class Employee {
    public int id;
    public String name;
    public double salary;
    public double taxAllowance;

    public double taxSalary;
    public double salaryNetto;

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("name: " + name);
        System.out.println("salary: " + salary);
        System.out.println("taxAllowance: " + taxAllowance);
        System.out.println("tax: " + taxSalary);
        System.out.println("salaryNetto: " + salaryNetto);
    }

    public double taxIsrael() {
        double tax = -(taxAllowance * 219);
        if (salary < 6330) {
            taxSalary = tax + salary * 0.1;
            return taxSalary = (taxSalary > 0) ? taxSalary : 0;
        } else {
            tax = tax + 6330 * 0.1;
        }
        if (salary >= 6330 && salary < 9080) {
            taxSalary = tax + (salary - 6330) * 0.14;
            return taxSalary = taxSalary > 0 ? taxSalary : 0;
        } else {
            tax = tax + (9080 - 6330) * 0.14;
        }
        if (salary >= 9080 && salary < 14580) {
            taxSalary = tax + (salary - 9080) * 0.2;
            return taxSalary = taxSalary > 0 ? taxSalary : 0;
        } else {
            tax = tax + (14580 - 9080) * 0.2;
        }
        if (salary >= 14580 && salary < 20260) {
            taxSalary = tax + (salary - 14580) * 0.31;
            return taxSalary = taxSalary > 0 ? taxSalary : 0;
        } else {
            tax = tax + (20260 - 14580) * 0.31;
        }
        if (salary >= 20260 && salary < 42160) {
            taxSalary = tax + (salary - 20260) * 0.35;
            return taxSalary = taxSalary > 0 ? taxSalary : 0;
        } else {
            tax = tax + (42160 - 20260) * 0.35;
        }
        if (salary >= 42160 && salary < 54300) {
            taxSalary = tax + (salary - 42160) * 0.47;
            return taxSalary = taxSalary > 0 ? taxSalary : 0;
        } else {
            tax = tax + (54300 - 42160) * 0.47;
        }
        taxSalary = tax + (salary - 54300) * 0.5;
        return taxSalary > 0 ? taxSalary : 0;
    }

    public double salNetto() {
        return salary - taxSalary;
    }

    public static void main(String[] args) {
        Employee john = new Employee();
        john.salary = 33000;
        System.out.println(john.taxIsrael());
        System.out.println(john.salNetto());
    }
}
