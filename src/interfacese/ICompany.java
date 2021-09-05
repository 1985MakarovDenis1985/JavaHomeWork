package interfacese;

import models.Employee;

public interface ICompany {
    String TITLE = "Apple";
    boolean addEmployee(Employee employee);
    Employee removeEmployee(int id);
    Employee findEmployee(int id);
    double totalSalary();
    int quantity();
    double avgSalary();
    double totalSales();
    void printEmployee();
}
