package controller;
import models.Employee;
import models.Manager;
import models.SalesManager;
import models.WageEmployee;

public class EmployeeApp {

    public static void main(String[] args) {

        Employee[] firm = new Employee[6];
        firm[0] = new Manager(1000, "John", "Smith", 182, 20000, 20);
        firm[1] = new WageEmployee(2000, "Ann", "Smith", 182, 40);
        firm[2] = new SalesManager(3000, "Peter", "Jackson", 182, 40000, 0.1);
        firm[3] = new SalesManager(4000, "Tigran", "Petrosyan", 91, 80000, 0.1);

        printArr(firm);
        double total = totalSalary(firm);
        System.out.println("total salary: " + total);

    }

    private static double totalSalary(Employee[] firm) {
        double sum = 0;
        for (int i = 0; i < firm.length; i++) {
            if (firm[i] != null){
                sum += firm[i].calcSalary();
            }
        }
        return sum;
    }

    private static void printArr(Employee[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
            System.out.println(arr[i]);
        }
    }
}
