package telran.cars.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.cars.dao.Garage;
import telran.cars.interfaces.IGarage;
import telran.cars.model.Car;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {

    Garage garage;
    Car[] cars;

    @BeforeEach
    void setUp() {
        garage = new Garage(6);
        cars = new Car[5];
        cars[0] = new Car("1000", "m3", "BMW", 2.0, "blue");
        cars[1] = new Car("2000", "m5", "BMW", 2.5, "red");
        cars[2] = new Car("3000", "a7", "Audi", 3.0, "blue");
        cars[3] = new Car("4000", "m3", "Audi", 1.6, "white");
        cars[4] = new Car("5000", "m3", "Audi", 1.8, "blue");

        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);

        }
    }


    @Test
    void testAddCar() {
        assertFalse(garage.addCar(cars[1]));
        Car car = new Car("6000", "a5", "Audi", 1.8, "white");
        assertTrue(garage.addCar(car));
        Assertions.assertEquals(car, garage.findCarByRegNumber("6000"));
        car = new Car("7000", "a5", "Audi", 1.8, "white");
        assertFalse(garage.addCar(car));
    }

    @Test
    void testRemoveCar() {
        Car actual = garage.removeCar("2000");
        assertEquals(cars[1], actual);
        assertEquals(cars[1].getModel(), actual.getModel());
        assertNull(garage.findCarByRegNumber("2000"));
        assertNull(garage.removeCar("7000"));
    }

    @Test
    void testFindCarByRegNumber() {
        assertEquals(cars[1], garage.findCarByRegNumber("2000"));
        assertNull(garage.removeCar("7000"));
    }

    @Test
    void testFindCarByModel() {
        Car[] arrTest = {cars[0], cars[3], cars[4]};
        assertArrayEquals(arrTest, garage.findCarByModel("m3"));
    }

    @Test
    void testFindCarByCompany() {
        Car[] arrTest = {cars[2], cars[3], cars[4]};
        assertArrayEquals(arrTest, garage.findCarByCompany("Audi"));
    }

    @Test
    void testFindCarByEngine() {
        Car[] arrTest = {cars[0], cars[4]};
        assertArrayEquals(arrTest, garage.findCarByEngine(1.6, 2.5));
    }

    @Test
    void testFindCarByColor() {
        Car[] arrTest = {cars[0], cars[2], cars[4]};
        assertArrayEquals(arrTest, garage.findCarByColor("blue"));
    }
}