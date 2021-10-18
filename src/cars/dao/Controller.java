package cars.dao;

import cars.domain.Car;

import java.time.LocalDate;
import java.util.HashMap;

public class Controller {
    public static void main(String[] args) {
        cars.domain.Car car1 = new cars.domain.Car("REG_NUMBER1", "red", "MODEL1");
        cars.domain.Car car2 = new cars.domain.Car("REG_NUMBER2", "green", "MODEL1");
        cars.domain.Car car3 = new cars.domain.Car("REG_NUMBER3", "silver", "MODEL1");
        cars.domain.Model model1 = new cars.domain.Model("MODEL1", 55, "Germany", "BMW", 200);
        cars.domain.Model model2 = new cars.domain.Model("MODEL2", 50, "Japan", "Subaru", 190);
        cars.domain.Driver driver1 = new cars.domain.Driver(1, "Moshe", 1980, "050-1234567");
        cars.domain.Driver driver2 = new cars.domain.Driver(2, "David", 1960, "050-7654321");

        RentCompany rentCompany = RentCompany.restoreFromFile("saveCompany");
        rentCompany.addModel(model1);
        rentCompany.addDriver(driver1);
        rentCompany.addCar(car1);
        rentCompany.rentCar("REG_NUMBER1", 1, LocalDate.of(2021, 5, 7), 5);
//
        rentCompany.save("saveCompany");
        RentCompany newCompany = rentCompany.restoreFromFile("saveCompany");


        newCompany.getAllCars().forEach(System.out::println);
        newCompany.getAllRecords().forEach(System.out::println);
        System.out.println("=====");
        rentCompany.addCar(car2);
        rentCompany.save("saveCompany");
        newCompany = rentCompany.restoreFromFile("saveCompany");

        newCompany.getAllCars().forEach(System.out::println);
        newCompany.getAllRecords().forEach(System.out::println);
    }
}
