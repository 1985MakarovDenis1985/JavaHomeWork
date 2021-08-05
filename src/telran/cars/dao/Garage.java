package telran.cars.dao;

import telran.cars.interfaces.IGarage;
import telran.cars.model.Car;

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
    public int quantity() {
        return size;
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
    public Car[] findCarByModel(String model) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getModel().equals(model)) {
                count++;
            }
        }
        Car[] carsArr = new Car[count];
        count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getModel().equals(model)) {
                carsArr[count] = cars[i];
                count++;
            }
        }
        return carsArr;
    }

    @Override
    public Car[] findCarByCompany(String company) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getCompany().equals(company)) {
                count += 1;
            }
        }
        Car[] carsArr = new Car[count];
        count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getCompany().equals(company)) {
                carsArr[count] = cars[i];
                count++;
            }
        }
        return carsArr;
    }

    @Override
    public Car[] findCarByEngine(double min, double max) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getEngine() > min && cars[i].getEngine() < max) {
                count++;
            }
        }
        Car[] carEngine = new Car[count];
        count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getEngine() > min && cars[i].getEngine() < max) {
                carEngine[count] = cars[i];
                count++;
            }
        }
        return carEngine;
    }

    @Override
    public Car[] findCarByColor(String color) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getColor().equals(color)) {
                count++;
            }
        }
        Car[] carColor = new Car[count];
        count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getColor().equals(color)) {
                carColor[count] = cars[i];
                count++;
            }
        }
        return carColor;
    }



}
