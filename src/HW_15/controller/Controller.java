package HW_15.controller;

import HW_15.employee.Employee;

public class Controller {
    public static void main(String[] args) {
        Employee john = new Employee();
        john.id = 1;
        john.name = "John Smith";
        john.salary = 30000;
        john.taxAllowance = 2.25;
        john.taxIsrael();
        john.salNetto();
        john.display();

        Employee peter = new Employee();
        peter.id = 2;
        peter.name = "John Smith";
        peter.salary = 150000;
        peter.taxAllowance = 2.25;
        peter.taxIsrael();
        peter.salNetto();
        peter.display();
    }
}
