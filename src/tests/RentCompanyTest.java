package tests;

import cars.dao.AbstractRentCompany;
import cars.dao.RentCompany;
import cars.domain.Car;
import cars.domain.Driver;
import cars.domain.Model;
import cars.domain.RentRecord;
import enums.CarsReturnCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RentCompanyTest {

    RentCompany myCompany;

    @BeforeEach
    void setUp() {
        myCompany = new RentCompany();
        myCompany.addModel(new Model("z3", 40, "bmw", "Germany", 70));
        myCompany.addModel(new Model("z4", 50, "bmw", "Germany", 80));
        myCompany.addModel(new Model("polo", 50, "VW", "Germany", 40));
        myCompany.addCar(new Car("1000", "red", "z4"));
        myCompany.addCar(new Car("2000", "red", "z3"));
        myCompany.addDriver(new Driver(1000, "Peter", 1975, "0547630001"));
        myCompany.addDriver(new Driver(2000, "Sam", 1986, "0547630002"));

    }

//    @Test
//    void testAddModel() {
//        Model i8 = new Model("i8", 50, "bmw", "Germany", 180);
//        assertEquals(CarsReturnCode.OK, myCompany.addModel(i8));
//        Model z3 = new Model("z3", 40, "bmw", "Germany", 70);
//        assertEquals(CarsReturnCode.MODEL_EXIST, myCompany.addModel(z3));
//    }
//
//    @Test
//    void testAddCar() {
//        Car car1 = new Car("3000", "red", "z4");
//        assertEquals(CarsReturnCode.OK, myCompany.addCar(car1));
//
//        Car car2 = new Car("1000", "red", "z4");
//        assertEquals(CarsReturnCode.CAR_EXIST, myCompany.addCar(car2));
//        assertEquals(CarsReturnCode.CAR_EXIST, myCompany.addCar(car1));
//
//        Car car3 = new Car("4000", "white", "mercedes");
//        assertEquals(CarsReturnCode.NO_MODEL, myCompany.addCar(car3));
//    }
//
//    @Test
//    void testAddDriver() {
//        Driver d1 = new Driver(3000, "Sara", 1991, "0547630003");
//        assertEquals(CarsReturnCode.OK, myCompany.addDriver(d1));
//        assertEquals(CarsReturnCode.DRIVER_EXIST, myCompany.addDriver(d1));
//        Driver d2 = new Driver(2000, "Jim", 1991, "0547630004");
//        assertEquals(CarsReturnCode.DRIVER_EXIST, myCompany.addDriver(d2));
//    }
//
//    @Test
//    void testGetModel() {
//        Model m1 = new Model("polo", 50, "VW", "Germany", 40);
//        Model m2 = new Model("jetta", 50, "VW", "Germany", 40);
//        assertEquals(m1, myCompany.getModel("polo"));
//        assertNull(myCompany.getModel(m2.getModelName()));
//
//        myCompany.addModel(m2);
//        assertEquals(m1, myCompany.getModel(m1.getModelName()));
//        assertEquals(m2, myCompany.getModel("jetta"));
//    }
//
//    @Test
//    void testGetCar() {
//        Car car1 = new Car("1000", "red", "z4");
//        Car car2 = new Car("3000", "red", "i8");
//        Car car3 = new Car("4000", "red", "z4");
//        assertEquals(car1, myCompany.getCar("1000"));
//        assertNull(myCompany.getCar("3000"));
//
//        myCompany.addCar(car2);
//        myCompany.addCar(car3);
//        assertNull(myCompany.getCar("3000"));
//        assertEquals(car3, myCompany.getCar("4000"));
//    }
//
//    @Test
//    void testGetDriver() {
//        Driver d1 = new Driver(1000, "Peter", 1975, "0547630001");
//        Driver d2 = new Driver(3000, "Jim", 1985, "0547630002");
//        Driver d3 = new Driver(5000, "Sara", 1995, "0547630003");
//        assertEquals(d1, myCompany.getDriver(1000));
//        assertNull(myCompany.getDriver(3000));
//
//        myCompany.addDriver(d2);
//        assertEquals(d2, myCompany.getDriver(3000));
//    }
//


    @Test
    void testRentCar() {
        assertFalse(myCompany.getCar("1000").isInUse());
        assertEquals(CarsReturnCode.OK,  myCompany.rentCar("1000", 1000, LocalDate.of(2021, 9, 15), 5));
        assertTrue(myCompany.getCar("1000").isInUse());

        assertEquals(CarsReturnCode.CAR_IN_USE, myCompany.rentCar("1000", 1000, LocalDate.of(2021, 9, 15), 5));
        assertEquals(CarsReturnCode.NO_DRIVER, myCompany.rentCar("2000", 3000, LocalDate.of(2021, 9, 15), 5));
        assertEquals(CarsReturnCode.CAR_NOT_EXIST, myCompany.rentCar("3000", 3000, LocalDate.of(2021, 9, 15), 5));
    }


//    @Test
//    void testReturnCar() {
//    }
//
//    @Test
//    void testRemoveCar() {
//    }
//
//    @Test
//    void testClear() {
//    }
//
//    @Test
//    void testGetCarDrivers() {
//    }
//
//    @Test
//    void testGetDriverCars() {
//    }
//
//    @Test
//    void testGetAllCars() {
//    }
//
//    @Test
//    void testGetAllDrivers() {
//    }
//
//    @Test
//    void testGetAllRecords() {
//    }
//
//    @Test
//    void testGetMostPopularModeNames() {
//    }
//
//    @Test
//    void testGetModelProfit() {
//    }
//
//    @Test
//    void testGetMostProfitModelNames() {
//    }
}