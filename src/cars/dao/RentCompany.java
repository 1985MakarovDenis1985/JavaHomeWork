package cars.dao;

import cars.domain.Car;
import cars.domain.Driver;
import cars.domain.Model;
import cars.domain.RentRecord;
import enums.CarsReturnCode;
import enums.State;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class RentCompany extends AbstractRentCompany {
    HashMap<String, Car> cars = new HashMap<>(); // number of model, car
    HashMap<Long, Driver> drivers = new HashMap<>();
    HashMap<String, List<RentRecord>> carRecords = new HashMap<>(); // number of car, list all records
    HashMap<Long, List<RentRecord>> driverRecords = new HashMap<>();
    TreeMap<LocalDate, List<RentRecord>> returnedRecords = new TreeMap<>(); // all completed rents
    HashMap<String, Model> models = new HashMap<>();


    @Override
    public CarsReturnCode addModel(Model model) {
        String newKey = model.getModelName();
        if (!models.containsKey(model.getModelName())) {
            models.put(newKey, model);
            return CarsReturnCode.OK;
        }
        return CarsReturnCode.MODEL_EXIST;
    }

    @Override
    public CarsReturnCode addCar(Car car) {
        if (!models.containsKey(car.getModelName())) return CarsReturnCode.NO_MODEL;
        if (cars.containsKey(car.getRegNumber())) return CarsReturnCode.CAR_EXIST;
        cars.put(car.getRegNumber(), car);
        return CarsReturnCode.OK;
    }

    @Override
    public CarsReturnCode addDriver(Driver driver) {
        if (drivers.containsKey(driver.getLicenceId())) return CarsReturnCode.DRIVER_EXIST;
        drivers.put(driver.getLicenceId(), driver);
        return CarsReturnCode.OK;
    }

    @Override
    public Model getModel(String modelName) {
        return models.get(modelName);
    }

    @Override
    public Car getCar(String regNumber) {
        return cars.get(regNumber);
    }

    @Override
    public Driver getDriver(long licence) {
        return drivers.get(licence);
    }

    @Override
    public CarsReturnCode rentCar(String regNumber, long licenceId, LocalDate rentDate, int rentDays) {
        if (!cars.containsKey(regNumber)) return CarsReturnCode.CAR_NOT_EXIST;
        if (!drivers.containsKey(licenceId)) return CarsReturnCode.NO_DRIVER;
        if (cars.get(regNumber).isInUse()) return CarsReturnCode.CAR_IN_USE;

        if (cars.get(regNumber).isIfRemoved()) return CarsReturnCode.CAR_NOT_EXIST;

        RentRecord newRent = new RentRecord(licenceId, regNumber, rentDate, rentDays);
        float contractCoast = rentDays * models.get(cars.get(regNumber).getModelName()).getPriceDay();
        newRent.setCoast(contractCoast);
        if (!carRecords.containsKey(regNumber)) {
            carRecords.put(regNumber, new ArrayList<>());
        }
        if (!driverRecords.containsKey(licenceId)) {
            driverRecords.put(licenceId, new ArrayList<>());
        }
        carRecords.get(regNumber).add(newRent);
        driverRecords.get(licenceId).add(newRent);
        cars.get(regNumber).setInUse(true);

        return CarsReturnCode.OK;
    }

    @Override
    public CarsReturnCode returnCar(String regNumber, long licenceId, LocalDate returnDate, int gasTankPercent, int damages) {

        if (!cars.containsKey(regNumber) || !cars.get(regNumber).isInUse()) return CarsReturnCode.CAR_NOT_RENTED;
        RentRecord lastRecordOfThisCar = carRecords.get(regNumber).get(carRecords.get(regNumber).size() - 1);

//        System.out.println(lastRecordOfThisCar);
        if (!drivers.containsKey(licenceId) || lastRecordOfThisCar.getLicenceId() != licenceId)
            return CarsReturnCode.NO_DRIVER;
        if (returnDate.isBefore(lastRecordOfThisCar.getRentDate())) return CarsReturnCode.RETURN_DATE_WRONG;


        Car thisCar = getCar(regNumber);
        int thisModelPrice = getModel(thisCar.getModelName()).getPriceDay();
        int thisModelGasTank = getModel(thisCar.getModelName()).getGasTank();

        lastRecordOfThisCar.setDamages(damages);
        lastRecordOfThisCar.setReturnDate(returnDate);
        lastRecordOfThisCar.setGasTankPercent(gasTankPercent);

        int factDaysRent = returnDate.getDayOfYear() - lastRecordOfThisCar.getRentDate().getDayOfYear();
        int difOfDays = factDaysRent - lastRecordOfThisCar.getRentDays();

        // sum coast over rent
        if (returnDate.isAfter(lastRecordOfThisCar.getRentDate().plusDays(lastRecordOfThisCar.getRentDays()))) {
            float sumOverRent = 0;
            sumOverRent = difOfDays * (thisModelPrice + (thisModelPrice / 100 * finePercent));
            lastRecordOfThisCar.setCoast(lastRecordOfThisCar.getCoast() + sumOverRent);
        }

        // sum coast if car returned before contract
        if (returnDate.isBefore(lastRecordOfThisCar.getRentDate().plusDays(lastRecordOfThisCar.getRentDays())) && !returnDate.isBefore(lastRecordOfThisCar.getRentDate())) {
            float factCoast = 0;
            factCoast = factDaysRent * models.get(cars.get(regNumber).getModelName()).getPriceDay();
            lastRecordOfThisCar.setCoast(factCoast);
        }

        // price of petrol
        float coastPetrol = 0;
        if (lastRecordOfThisCar.getGasTankPercent() < 100) {
//            System.out.println("Gas : " + thisModelGasTank);
//            System.out.println(Math.round((double) thisModelGasTank / 100 * gasTankPercent));
            float petrolCoast = (thisModelGasTank - Math.round((double) thisModelGasTank / 100 * gasTankPercent)) * gasPrice;
//            System.out.println(petrolCoast);
            lastRecordOfThisCar.setCoast(lastRecordOfThisCar.getCoast() + petrolCoast);
        }

//        System.out.println("fact days : " + factDaysRent);
//        System.out.println("sum : " + sumOverRent);
//        System.out.println(lastRecordOfThisCar);

        if (lastRecordOfThisCar.getDamages() <= 10) {
            cars.get(regNumber).setState(State.GOOD);
        } else if (lastRecordOfThisCar.getDamages() > 10 && lastRecordOfThisCar.getDamages() <= 30) {
            cars.get(regNumber).setState(State.BAD);
        } else if (lastRecordOfThisCar.getDamages() > 30) {
            cars.get(regNumber).setIfRemoved(true);
        }
        cars.get(regNumber).setInUse(false);
        if (!returnedRecords.containsKey(returnDate)) returnedRecords.put(returnDate, new ArrayList<>());
        returnedRecords.get(returnDate).add(lastRecordOfThisCar);
        if (!returnedRecords.containsKey(returnDate)) {
            returnedRecords.put(returnDate, new ArrayList<>());
        }
        returnedRecords.get(returnDate).add(lastRecordOfThisCar);
        return CarsReturnCode.OK;
    }

    @Override
    public CarsReturnCode removeCar(String regNumber) {
        if (!cars.containsKey(regNumber)) return CarsReturnCode.CAR_NOT_EXIST;
        if (getCar(regNumber).isInUse()) return CarsReturnCode.CAR_IN_USE;
        getCar(regNumber).setIfRemoved(true);
        return CarsReturnCode.OK;
    }

    @Override
    public List<Car> clear(LocalDate currentDate, int days) {
        return null;
    }

    // ========================= next ======================= //

    @Override
    public List<Driver> getCarDrivers(String regNumber) {
        return carRecords.entrySet().stream()
                .flatMap(e -> StreamSupport.stream(e.getValue().spliterator(), false))
                .map(o -> drivers.get(o.getLicenceId()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getDriverCars(long licence) {
        return driverRecords.entrySet().stream()
                .flatMap(e -> StreamSupport.stream(e.getValue().spliterator(), false))
                .map(o -> cars.get(o.getRegNumber()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Stream<Car> getAllCars() {
        return cars.values().stream();
    }

    @Override
    public Stream<Driver> getAllDrivers() {
        return drivers.values().stream();
    }

    @Override
    public Stream<RentRecord> getAllRecords() {
        return carRecords.entrySet().stream()
                .flatMap(e -> StreamSupport.stream(e.getValue().spliterator(), false));
    }

    @Override
    public List<String> getMostPopularModeNames() {
        Map<String, Long> mostPopularModel = getAllRecords()
                .map(e -> cars.get(e.getRegNumber()).getModelName())
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()));
//        System.out.println(mostPopularModel);


        Long max = mostPopularModel.entrySet().stream()
                .map(e -> e.getValue())
                .max((n1, n2) -> Long.compare(n1, n2)).orElse(null);
        System.out.println(max);

        List<String> s =
        mostPopularModel.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        System.out.println(s);

        return null;
    }

    @Override
    public double getModelProfit(String modelName) {
        return 0;
    }

    @Override
    public List<String> getMostProfitModelNames() {
        return null;
    }
}
