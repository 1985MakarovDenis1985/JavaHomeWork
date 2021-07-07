package HW_15.employee;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private double taxAllowance;
    private double taxSalary;
    private double salaryNetto;


    public Employee(int id, String name, double salary, double taxAllowance) { // public - обязательно
        if (id >= 0){
            this.id = id;
        }
        this.name = name;
        setSalary(salary);
        setTaxAllowance(taxAllowance);
        this.taxSalary = taxIsrael();
        this.salaryNetto = salary - taxSalary;
    }

    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
       if (salary > 0) {
           this.salary = salary;
       }
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getTaxAllowance() {
        return taxAllowance;
    }

    public void setTaxAllowance(double taxAllowance) {
        if (this.taxAllowance > 0){
            this.taxAllowance = taxAllowance;
        }
    }

    public double getTaxSalary() {
        return taxSalary;
    }

    public void setTaxSalary(double taxSalary) {
        this.taxSalary = taxSalary;
    }

    public double getSalaryNetto() {
        return salaryNetto;
    }

    public void setSalaryNetto(double salaryNetto) {
        this.salaryNetto = salaryNetto;
    }

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
    public static void main(String[] args) {
        Employee john = new Employee(1000, "John", 20000, 2.25);
        Employee peter = new Employee(2000, "Peter", 33000, 5.25);
        john.display();
        double totalSalary = john.getSalary() + peter.getSalary();
        john.setSalary(-35000); // так как минусовай зарплаты небывает => условие метода вернуть предыдущую зп
        System.out.println(john.salary);

//        System.out.println("totalSalary: " + totalSalary);
    }
}
