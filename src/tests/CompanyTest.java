package tests;


import dao.CompanySet;
import interfacese.ICompany;
import models.Employee;
import models.Manager;
import models.SalesManager;
import models.WageEmployee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    ICompany company;
    Employee[] firm;

    @BeforeEach
    void setUp() {
        company = new CompanySet(5);
        firm = new Employee[4];
        firm[0] = new Manager(1000, "John", "Smith", 182, 20000, 20);
        firm[1] = new WageEmployee(2000, "Ann", "Smith", 182, 40);
        firm[2] = new SalesManager(3000, "Peter", "Jackson", 182, 40000, 0.1);
        firm[3] = new SalesManager(4000, "Tigran", "Petrosyan", 91, 80000, 0.1);

        for (int i = 0; i < firm.length; i++) {
            company.addEmployee(firm[i]);
        }
    }


    @Test
    void testAddEmployee() {
        assertFalse(company.addEmployee(firm[1]));
        Employee employee = new SalesManager(5000, "Tigran", "Petrosyan", 91, 80000, 0.1);
        assertTrue(company.addEmployee(employee));
        Assertions.assertEquals(employee, company.findEmployee(5000));
        assertEquals(5, company.quantity());
        employee = new SalesManager(6000, "Tigran", "Petrosyan", 91, 80000, 0.1);
        assertFalse(company.addEmployee(employee));
    }

    @Test
    void testRemoveEmployee() {
        Employee actual = company.removeEmployee(3000);
        assertEquals(firm[2], actual);
        assertEquals(firm[2].getLastName(), actual.getLastName());
        assertNull(company.findEmployee(3000));
        assertEquals(3, company.quantity());
        assertNull(company.removeEmployee(6000));
        assertEquals(3, company.quantity());
    }

    @Test
    void testFindEmployee() {
        assertEquals(firm[1], company.findEmployee(2000));
        assertNull(company.removeEmployee(5000));
    }

    @Test
    void testTotalSalary() {
        assertEquals(44380.0, company.totalSalary(), 0.01); //delta => погрешность которая будет учитыватся
    }

    @Test
    void testQuantity() {
        assertEquals(4, company.quantity());
    }

    @Test
    void testAvgSalary() {
        assertEquals(44380.0 / 4, company.avgSalary(), 0.01);
    }

    @Test
    void testTotalSales() {
        assertEquals(120000, company.totalSales(), 0.01);
    }
}