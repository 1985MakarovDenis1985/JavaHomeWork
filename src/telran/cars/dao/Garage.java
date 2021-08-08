package telran.cars.dao;

import telran.cars.interfaces.IGarage;
import telran.cars.model.Car;

import java.util.function.Predicate;

public class Garage implements IGarage {
    Car[] cars;
    int size;

    public Garage(int size) {
        cars = new Car[size];
    }


    @Override
    public boolean addCar(Car car) {
        if (size == cars.length || findCarByRegNumber(car.getRegNumber()) != null) {
            return false;
        }
        cars[size++] = car;
        return true;
    }


    @Override
    public Car removeCar(String regNum) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNum)) {
                Car victim = cars[i];
                cars[i] = cars[--size];
                return victim;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByPredicate(Predicate<Car> tester) { // можно вынести в интерфейс (остальные сделать дефолтными)
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (tester.test(cars[i])) {
                count++;
            }
        }
        Car[] carColor = new Car[count];
        count = 0;
        for (int i = 0; i < size; i++) {
            if (tester.test(cars[i])) {
                carColor[count] = cars[i];
                count++;
            }
        }
        return carColor;
    }
}
