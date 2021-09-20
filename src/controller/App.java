package controller;


import cars.dao.RentCompany;
import cars.domain.Car;
import cars.domain.Driver;
import cars.domain.Model;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        RentCompany myCompany = new RentCompany();
        myCompany.addModel(new Model("z3", 40, "bmw", "Germany", 70));
        myCompany.addModel(new Model("z4", 50, "bmw", "Germany", 200));
        myCompany.addModel(new Model("polo", 50, "VW", "Germany", 40));

        myCompany.addCar(new Car("1000", "red", "z4"));
        myCompany.addCar(new Car("2000", "red", "polo"));
        myCompany.addCar(new Car("3000", "red", "z4"));

        myCompany.addDriver(new Driver(1000, "Peter", 1975, "0547630001"));
        myCompany.addDriver(new Driver(2000, "Sam", 1986, "0547630002"));

//        System.out.println(myCompany.addCar(new Car("1000", "red", "bmw")));

//        myCompany.addCar(new Car("2000", "red", "bmw"));

//        System.out.println(myCompany.getCar("1000"));
//        System.out.println(myCompany.getModel("z3"));

//        myCompany.getAllCars()
//        .forEach(System.out::println);

        myCompany.rentCar("1000", 2000, LocalDate.of(2021, 9, 21), 5);
//        myCompany.rentCar("2000", 2000, LocalDate.of(2021, 9, 10), 5);
//        myCompany.rentCar("1000", 2000, LocalDate.of(2021, 9, 23), 5);
//        myCompany.rentCar("2000", 2000, LocalDate.of(2021, 9, 28), 5);
//        myCompany.rentCar("1000", 1000, LocalDate.of(2021, 9, 17), 5);



        myCompany.returnCar("1000", 2000, LocalDate.of(2021, 9, 23), 100, 10);



    }
}
