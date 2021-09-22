package tests;

import cars.dao.AbstractRentCompany;
import cars.dao.RentCompany;
import cars.domain.Car;
import cars.domain.Driver;
import cars.domain.Model;
import cars.domain.RentRecord;
import enums.CarsReturnCode;
import enums.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RentCompanyTest {

    RentCompany myCompany;

    @BeforeEach
    void setUp() {
        myCompany = new RentCompany();
        myCompany.addModel(new Model("z3", 50, "bmw", "Germany", 100));
        myCompany.addModel(new Model("z4", 50, "bmw", "Germany", 150));
        myCompany.addModel(new Model("polo", 50, "VW", "Germany", 40));
        myCompany.addCar(new Car("1000", "red", "z4"));
        myCompany.addCar(new Car("2000", "red", "z3"));
        myCompany.addDriver(new Driver(1000, "Peter", 1975, "0547630001"));
        myCompany.addDriver(new Driver(2000, "Sam", 1986, "0547630002"));
    }

    @Test
    void testAddModel() {
        Model i8 = new Model("i8", 50, "bmw", "Germany", 180);
        assertEquals(CarsReturnCode.OK, myCompany.addModel(i8));
        Model z3 = new Model("z3", 40, "bmw", "Germany", 70);
        assertEquals(CarsReturnCode.MODEL_EXIST, myCompany.addModel(z3));
    }

    @Test
    void testAddCar() {
        Car car1 = new Car("3000", "red", "z4");
        assertEquals(CarsReturnCode.OK, myCompany.addCar(car1));

        Car car2 = new Car("1000", "red", "z4");
        assertEquals(CarsReturnCode.CAR_EXIST, myCompany.addCar(car2));
        assertEquals(CarsReturnCode.CAR_EXIST, myCompany.addCar(car1));

        Car car3 = new Car("4000", "white", "mercedes");
        assertEquals(CarsReturnCode.NO_MODEL, myCompany.addCar(car3));
    }

    @Test
    void testAddDriver() {
        Driver d1 = new Driver(3000, "Sara", 1991, "0547630003");
        assertEquals(CarsReturnCode.OK, myCompany.addDriver(d1));
        assertEquals(CarsReturnCode.DRIVER_EXIST, myCompany.addDriver(d1));
        Driver d2 = new Driver(2000, "Jim", 1991, "0547630004");
        assertEquals(CarsReturnCode.DRIVER_EXIST, myCompany.addDriver(d2));
    }

    @Test
    void testGetModel() {
        Model m1 = new Model("polo", 50, "VW", "Germany", 40);
        Model m2 = new Model("jetta", 50, "VW", "Germany", 40);
        assertEquals(m1, myCompany.getModel("polo"));
        assertNull(myCompany.getModel(m2.getModelName()));

        myCompany.addModel(m2);
        assertEquals(m1, myCompany.getModel(m1.getModelName()));
        assertEquals(m2, myCompany.getModel("jetta"));
    }

    @Test
    void testGetCar() {
        Car car1 = new Car("1000", "red", "z4");
        Car car2 = new Car("3000", "red", "i8");
        Car car3 = new Car("4000", "red", "z4");
        assertEquals(car1, myCompany.getCar("1000"));
        assertNull(myCompany.getCar("3000"));

        myCompany.addCar(car2);
        myCompany.addCar(car3);
        assertNull(myCompany.getCar("3000"));
        assertEquals(car3, myCompany.getCar("4000"));
    }

    @Test
    void testGetDriver() {
        Driver d1 = new Driver(1000, "Peter", 1975, "0547630001");
        Driver d2 = new Driver(3000, "Jim", 1985, "0547630002");
        Driver d3 = new Driver(5000, "Sara", 1995, "0547630003");
        assertEquals(d1, myCompany.getDriver(1000));
        assertNull(myCompany.getDriver(3000));

        myCompany.addDriver(d2);
        assertEquals(d2, myCompany.getDriver(3000));
    }


    @Test
    void testRentCar() {
        assertFalse(myCompany.getCar("1000").isInUse());
        assertEquals(CarsReturnCode.OK, myCompany.rentCar("1000", 1000, LocalDate.of(2021, 9, 15), 5));
        assertTrue(myCompany.getCar("1000").isInUse());

        assertEquals(CarsReturnCode.CAR_IN_USE, myCompany.rentCar("1000", 1000, LocalDate.of(2021, 9, 15), 5));
        assertEquals(CarsReturnCode.NO_DRIVER, myCompany.rentCar("2000", 3000, LocalDate.of(2021, 9, 15), 5));
        assertEquals(CarsReturnCode.CAR_NOT_EXIST, myCompany.rentCar("3000", 3000, LocalDate.of(2021, 9, 15), 5));
    }


    @Test
    void testReturnCar() {
        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 9, 15), 5);
        assertTrue(myCompany.getCar("1000").isInUse());
        assertEquals(CarsReturnCode.OK, myCompany.returnCar("1000", 1000, LocalDate.of(2021, 9, 17), 100, 10));
        assertEquals(CarsReturnCode.CAR_NOT_RENTED, myCompany.returnCar("1000", 1000, LocalDate.of(2021, 9, 17), 100, 10));
        assertEquals(CarsReturnCode.CAR_NOT_RENTED, myCompany.returnCar("2000", 1000, LocalDate.of(2021, 9, 17), 100, 10));
        assertEquals(CarsReturnCode.CAR_NOT_RENTED, myCompany.returnCar("3000", 1000, LocalDate.of(2021, 9, 17), 100, 10));

        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 9, 15), 5);
        assertEquals(CarsReturnCode.NO_DRIVER, myCompany.returnCar("1000", 2000, LocalDate.of(2021, 9, 17), 100, 10));
        assertEquals(CarsReturnCode.NO_DRIVER, myCompany.returnCar("1000", 3000, LocalDate.of(2021, 9, 17), 100, 10));

        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 9, 15), 5);
        assertEquals(CarsReturnCode.RETURN_DATE_WRONG, myCompany.returnCar("1000", 1000, LocalDate.of(2021, 9, 11), 100, 10));

        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 9, 21), 50, 10);
        assertFalse(myCompany.getCar("1000").isInUse());
        assertEquals(State.GOOD, myCompany.getCar("1000").getState());

        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 9, 15), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 9, 21), 50, 25);
        assertEquals(State.BAD, myCompany.getCar("1000").getState());

        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 9, 15), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 9, 21), 50, 35);
        assertTrue(myCompany.getCar("1000").isIfRemoved());

    }

    @Test
    void testRemoveCar() {
        Car car = new Car("3000", "red", "z4");
        myCompany.addCar(car);
        assertEquals(CarsReturnCode.OK, myCompany.removeCar("3000"));
        assertTrue(myCompany.getCar("3000").isIfRemoved());

        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 9, 15), 5);
        assertEquals(CarsReturnCode.CAR_IN_USE, myCompany.removeCar("1000"));
        assertEquals(CarsReturnCode.CAR_NOT_EXIST, myCompany.removeCar("4000"));
    }

    @Test
    void testClear() {
        myCompany.addCar(new Car("3000", "red", "polo"));
        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 1, 15), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 1, 21), 50, 10);
        myCompany.rentCar("2000", 2000, LocalDate.of(2021, 2, 15), 5);
        myCompany.returnCar("2000", 2000, LocalDate.of(2021, 2, 21), 50, 25);
        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 3, 15), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 3, 21), 50, 50);
        myCompany.rentCar("3000", 2000, LocalDate.of(2021, 4, 15), 5);
        myCompany.returnCar("3000", 2000, LocalDate.of(2021, 4, 21), 50, 25);



//        assertEquals(4, myCompany.getAllRecords().count());
//        myCompany.clear(LocalDate.of(2021, 5, 1), 5);
//        assertEquals(2, myCompany.getAllRecords().count());
//        assertEquals(2, myCompany.getAllCars().count());
//        myCompany.getCar("2000").setIfRemoved(true);
//        myCompany.clear(LocalDate.of(2021, 5, 1), 5);
//        assertEquals(1, myCompany.getAllRecords().count());
//        assertEquals(1, myCompany.getAllCars().count());


    }

    @Test
    void testGetCarDrivers() {
        myCompany.addCar(new Car("3000", "red", "polo"));
        myCompany.addDriver(new Driver(3000, "Sam", 1986, "0547630002"));

        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 1, 15), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 1, 21), 50, 25);
        myCompany.rentCar("1000", 2000, LocalDate.of(2021, 2, 15), 5);
        myCompany.returnCar("1000", 2000, LocalDate.of(2021, 2, 21), 50, 25);
        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 3, 15), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 3, 21), 50, 25);
        myCompany.rentCar("1000", 3000, LocalDate.of(2021, 4, 15), 5);
        myCompany.returnCar("1000", 3000, LocalDate.of(2021, 5, 21), 50, 25);

        List<Driver> drv = myCompany.getCarDrivers("1000");
        assertEquals(3, drv.size());

        Driver d1 = myCompany.getDriver(2000);

        assertEquals(d1, drv.stream().filter(e -> e.getLicenceId() == 2000).findAny().orElse(null));
        assertNull(drv.stream().filter(e -> e.getLicenceId() == 4000).findAny().orElse(null));
    }

    // ПЕРЕДЕЛАТЬ
    @Test
    void testGetDriverCars() {
        myCompany.addCar(new Car("3000", "red", "polo"));
        myCompany.addDriver(new Driver(3000, "Sam", 1986, "0547630002"));

        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 1, 15), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 1, 21), 50, 25);
        myCompany.rentCar("2000", 1000, LocalDate.of(2021, 2, 15), 5);
        myCompany.returnCar("2000", 1000, LocalDate.of(2021, 2, 21), 50, 25);
        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 3, 15), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 3, 21), 50, 25);
        myCompany.rentCar("3000", 1000, LocalDate.of(2021, 4, 15), 5);
        myCompany.returnCar("3000", 1000, LocalDate.of(2021, 5, 21), 50, 25);

        List<Car> cars = myCompany.getDriverCars(1000);
        assertEquals(3, cars.size());

        Car car1 = myCompany.getCar("1000");
        Car car2 = myCompany.getCar("2000");
        Car car3 = myCompany.getCar("3000");
        assertEquals(car1, cars.stream().filter(e -> e.getRegNumber().equals("1000")).findAny().orElse(null));
        assertEquals(car2, cars.stream().filter(e -> e.getRegNumber().equals("2000")).findAny().orElse(null));
        assertEquals(car3, cars.stream().filter(e -> e.getRegNumber().equals("3000")).findAny().orElse(null));

        assertNull(cars.stream().filter(e -> e.getRegNumber().equals("4000")).findAny().orElse(null));
    }

    @Test
    void testGetAllCars() {
        List<Car> testStreamCarsList = myCompany.getAllCars()
                .collect(Collectors.toList());
        assertEquals(List.of(
                new Car("1000", "red", "z4"),
                new Car("2000", "red", "z3")),
                testStreamCarsList);
    }

    @Test
    void testGetAllDrivers() {
        List<Driver> testStreamDriversList = myCompany.getAllDrivers()
                .collect(Collectors.toList());
        assertEquals(List.of(
                new Driver(2000, "Sam", 1986, "0547630002"),
                new Driver(1000, "Peter", 1975, "0547630001")),
                testStreamDriversList);
    }

    @Test
    void testGetAllRecords() {
        myCompany.rentCar("2000", 1000, LocalDate.of(2021, 1, 21), 5);
        myCompany.returnCar("2000", 1000, LocalDate.of(2021, 1, 23), 10, 10);
        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 2, 10), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 2, 23), 10, 10);
        myCompany.rentCar("1000", 2000, LocalDate.of(2021, 3, 15), 5);
        List<RentRecord> testStreamRent = myCompany.getAllRecords()
                .collect(Collectors.toList());
        assertEquals(3, testStreamRent.size());
    }

    @Test
    void testGetMostPopularModeNames() {
        myCompany.rentCar("2000", 1000, LocalDate.of(2021, 1, 21), 5);
        myCompany.returnCar("2000", 1000, LocalDate.of(2021, 1, 23), 10, 10);
        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 2, 10), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 2, 23), 10, 10);
        myCompany.rentCar("1000", 2000, LocalDate.of(2021, 3, 15), 5);
        myCompany.returnCar("1000", 2000, LocalDate.of(2021, 3, 23), 10, 10);
        assertEquals(List.of("z4"), myCompany.getMostPopularModeNames());

        myCompany.addCar(new Car("3000", "red", "polo"));
        myCompany.rentCar("3000", 1000, LocalDate.of(2021, 3, 15), 5);
        myCompany.returnCar("3000", 1000, LocalDate.of(2021, 3, 23), 10, 10);
        myCompany.rentCar("2000", 2000, LocalDate.of(2021, 4, 15), 5);
        myCompany.returnCar("2000", 2000, LocalDate.of(2021, 4, 23), 10, 10);
        assertEquals(List.of("z3", "z4"), myCompany.getMostPopularModeNames());

        myCompany.rentCar("3000", 4000, LocalDate.of(2021, 5, 15), 5);
        myCompany.returnCar("3000", 4000, LocalDate.of(2021, 5, 23), 10, 10);
        myCompany.rentCar("3000", 1000, LocalDate.of(2021, 6, 15), 5);
        myCompany.returnCar("3000", 1000, LocalDate.of(2021, 6, 23), 10, 10);
        myCompany.rentCar("3000", 1000, LocalDate.of(2021, 6, 15), 5);
        assertEquals(List.of("polo"), myCompany.getMostPopularModeNames());

    }

    @Test
    void testGetModelProfit() {
        myCompany.addCar(new Car("3000", "red", "polo")); // polo : 40$ // 2000 - z3 : 100$
        myCompany.rentCar("3000", 1000, LocalDate.of(2021, 3, 15), 5);
        myCompany.returnCar("3000", 1000, LocalDate.of(2021, 3, 20), 100, 10);
        // 5*40=200
        assertEquals(200, myCompany.getModelProfit("polo"));

        myCompany.rentCar("3000", 1000, LocalDate.of(2021, 3, 15), 5);
        myCompany.returnCar("3000", 1000, LocalDate.of(2021, 3, 17), 50, 10);
        // 2*40=80 + (50/50%=25*10)=250(petrol) + 200 already get(above)
        assertEquals(530, myCompany.getModelProfit("polo"));

        myCompany.rentCar("2000", 2000, LocalDate.of(2021, 4, 15), 5);
        myCompany.returnCar("2000", 2000, LocalDate.of(2021, 4, 23), 100, 10);
        // 5*100=500 + 3*100=300(over contract) + 3*15%=45
        assertEquals(845, myCompany.getModelProfit("z3"));

        myCompany.rentCar("2000", 2000, LocalDate.of(2021, 4, 15), 5);
        myCompany.returnCar("2000", 2000, LocalDate.of(2021, 4, 23), 50, 10);
        // 5*100=500 + 3*100=300(over contract) + 3*15%=45 + (50/50%=25*10)=250(petrol) + 845 already get(above)
        assertEquals(1940, myCompany.getModelProfit("z3"));

    }

    @Test
    void testGetMostProfitModelNames() {
        myCompany.addCar(new Car("3000", "red", "polo"));
        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 3, 15), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 3, 20), 100, 10);
        // 750.0

        myCompany.rentCar("2000", 2000, LocalDate.of(2021, 4, 15), 5);
        myCompany.returnCar("2000", 2000, LocalDate.of(2021, 4, 25), 100, 10);
        // 1075.0
        assertEquals(List.of("z3"), myCompany.getMostProfitModelNames());

        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 3, 15), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 3, 20), 100, 10);
        // 1500.0
        assertEquals(List.of("z4"), myCompany.getMostProfitModelNames());

        myCompany.rentCar("3000", 1000, LocalDate.of(2021, 3, 1), 5);
        myCompany.returnCar("3000", 1000, LocalDate.of(2021, 3, 30), 32, 10);
        assertEquals(List.of("polo", "z4"), myCompany.getMostProfitModelNames());

    }
}