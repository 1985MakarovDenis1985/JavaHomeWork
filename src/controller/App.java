package controller;


import cars.dao.RentCompany;
import cars.domain.Car;
import cars.domain.Driver;
import cars.domain.Model;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        RentCompany myCompany = new RentCompany();
        myCompany.addModel(new Model("z3", 40, "bmw", "Germany", 70));
        myCompany.addModel(new Model("z4", 50, "bmw", "Germany", 100));
        myCompany.addModel(new Model("polo", 50, "VW", "Germany", 40));

        myCompany.addCar(new Car("1000", "red", "z4"));
        myCompany.addCar(new Car("2000", "red", "polo"));
        myCompany.addCar(new Car("3000", "red", "z3"));
        myCompany.addCar(new Car("8000", "red", "z4"));

        myCompany.addDriver(new Driver(1000, "Peter", 1975, "0547630001"));
        myCompany.addDriver(new Driver(2000, "Sam", 1986, "0547630002"));
        myCompany.addDriver(new Driver(3000, "Jim", 1986, "0547630003"));
        myCompany.addDriver(new Driver(4000, "Sara", 1986, "0547630004"));
//        myCompany.addDriver(new Driver(2000, "Dodik", 1986, "0547630005"));

//        System.out.println(myCompany.addCar(new Car("1000", "red", "bmw")));

//        myCompany.addCar(new Car("2000", "red", "bmw"));

//        System.out.println(myCompany.getCar("1000"));
//        System.out.println(myCompany.getModel("z3"));

//        myCompany.getAllCars()
//        .forEach(System.out::println);

        myCompany.rentCar("2000", 1000, LocalDate.of(2021, 11, 21), 5);
        myCompany.returnCar("2000", 1000, LocalDate.of(2021, 11, 23), 100, 10);
//
        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 2, 10), 5);
        myCompany.returnCar("1000", 1000, LocalDate.of(2021, 2, 11), 100, 10);
//
        myCompany.rentCar("1000", 3000, LocalDate.of(2021, 3, 15), 5);
        myCompany.returnCar("1000", 3000, LocalDate.of(2021, 3, 16), 100, 10);
//
        myCompany.rentCar("1000", 3000, LocalDate.of(2021, 4, 15), 5);
        myCompany.returnCar("1000", 3000, LocalDate.of(2021, 4, 17), 100, 10);
//
//        myCompany.rentCar("8000", 2000, LocalDate.of(2021, 4, 15), 5);
//        myCompany.returnCar("8000", 2000, LocalDate.of(2021, 4, 23), 10, 10);
//
//        myCompany.rentCar("3000", 4000, LocalDate.of(2021, 5, 15), 5);
//        myCompany.returnCar("3000", 4000, LocalDate.of(2021, 5, 23), 10, 10);
//
        myCompany.rentCar("3000", 1000, LocalDate.of(2021, 6, 15), 5);
        myCompany.returnCar("3000", 1000, LocalDate.of(2021, 6, 27), 10, 10);
//
//        myCompany.rentCar("3000", 1000, LocalDate.of(2021, 6, 15), 5);
//        myCompany.returnCar("3000", 1000, LocalDate.of(2021, 6, 23), 10, 10);


//        myCompany.getAllRecords()
//                .forEach(System.out::println);
//
//        System.out.println("-------------------");
//        List<String> s = myCompany.getMostPopularModeNames();
//        System.out.println(s);

//
//        myCompany.getAllCars()
//                .forEach(System.out::println);
//
//        myCompany.getAllDrivers()
//                .forEach(System.out::println);

//        List<Driver> drv = myCompany.getCarDrivers("1000");
//        System.out.println(drv);

//        myCompany.getModelProfit("z4");
        myCompany.getMostProfitModelNames();

    }
}
