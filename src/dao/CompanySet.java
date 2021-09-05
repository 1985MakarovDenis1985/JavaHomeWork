package dao;

import interfacese.ICompany;
import models.Employee;
import models.SalesManager;

import java.util.*;
import java.util.stream.Stream;

public class CompanySet implements ICompany {
    private Set<Employee> employees;
    private int capacity;

    public CompanySet(int capacity) {
        this.capacity = capacity;
        employees = new HashSet<>();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || employees.size() == capacity) {
            return false;
        }
        return employees.add(employee);
    }

    @Override
    public Employee removeEmployee(int id) {
        Employee victim = findEmployee(id);
        employees.remove(victim);
        return victim;
    }

    @Override
    public Employee findEmployee(int id) {
        return employees.stream().filter(el -> el.getId() == id).findFirst().orElse(null);
    }

    @Override
    public double totalSalary() {
        return employees.stream().mapToDouble(Employee::calcSalary).sum();
    }

    @Override
    public int quantity() {
        return employees.size();
    }

    @Override
    public double avgSalary() {
        return employees.stream().mapToDouble(Employee::calcSalary).average().getAsDouble();
    }

    @Override
    public double totalSales() {
        return employees.stream().filter(el -> el instanceof SalesManager).mapToDouble(el -> ((SalesManager) el).getSalesValue()).sum();
    }

    @Override
    public void printEmployee() {
        employees.forEach(e -> System.out.println(e));
    }
}
