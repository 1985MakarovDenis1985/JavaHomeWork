package telran.cars.interfaces;

import telran.cars.model.Car;

import java.util.function.Predicate;

public interface IGarage {
    boolean addCar(Car car);
    Car removeCar(String regNum);
    Car findCarByRegNumber(String regNumber);
//    Car[] findCarByModel(String model);
//    Car[] findCarByCompany(String company);
//    Car[] findCarByEngine(double min, double max);
//    Car[] findCarByColor(String company);

    default Car[] findCarByColor(String color) {
        return findCarsByPredicate(c -> color.equals(c.getColor()));
    }
    default Car[] findCarByModel(String model) {
        return findCarsByPredicate(c -> model.equals(c.getModel()));
    }
    default Car[] findCarByCompany(String company) {
        return findCarsByPredicate(c -> company.equals(c.getCompany()));
    }
    default Car[] findCarByEngine(double min, double max) {
        return findCarsByPredicate(c -> c.getEngine() > min && c.getEngine() < max);
    }

    Car[] findCarsByPredicate(Predicate<Car> tester);
}
