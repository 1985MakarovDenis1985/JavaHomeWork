package telran.cars.interfaces;

import telran.cars.model.Car;

public interface IGarage {
    boolean addCar(Car car);
    Car removeCar(String regNum);
    Car findCarByRegNumber(String regNumber);
    Car[] findCarByModel(String model);
    Car[] findCarByCompany(String company);
    Car[] findCarByEngine(double min, double max);
    Car[] findCarByColor(String company);
    int quantity();
}
