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

    private final int DAMAGE_10 = 10;
    private final int DAMAGE_30 = 30;

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
        if (!cars.containsKey(regNumber) || cars.get(regNumber).isIfRemoved() || rentDate.isAfter(LocalDate.now()))
            return CarsReturnCode.CAR_NOT_EXIST;
        if (!drivers.containsKey(licenceId)) return CarsReturnCode.NO_DRIVER;
        if (cars.get(regNumber).isInUse()) return CarsReturnCode.CAR_IN_USE;

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
        if (!drivers.containsKey(licenceId) || lastRecordOfThisCar.getLicenceId() != licenceId)
            return CarsReturnCode.NO_DRIVER;
        if (returnDate.isBefore(lastRecordOfThisCar.getRentDate()) || returnDate.isAfter(LocalDate.now()))
            return CarsReturnCode.RETURN_DATE_WRONG;

        int thisModelPrice = getModel(getCar(regNumber).getModelName()).getPriceDay();
        int thisModelGasTank = getModel(getCar(regNumber).getModelName()).getGasTank();

        lastRecordOfThisCar.setDamages(damages);
        lastRecordOfThisCar.setReturnDate(returnDate);
        lastRecordOfThisCar.setGasTankPercent(gasTankPercent);

        int factDaysRent = returnDate.getDayOfYear() - lastRecordOfThisCar.getRentDate().getDayOfYear();
        int difOfDays = factDaysRent - lastRecordOfThisCar.getRentDays();

        // sum coast over rent
        if (returnDate.isAfter(lastRecordOfThisCar.getRentDate().plusDays(lastRecordOfThisCar.getRentDays()))) {
            float sumOverRent = difOfDays * (thisModelPrice + (thisModelPrice / 100 * finePercent));
            lastRecordOfThisCar.setCoast(lastRecordOfThisCar.getCoast() + sumOverRent);
        }

        // sum coast if car returned before contract
        if (returnDate.isBefore(lastRecordOfThisCar.getRentDate().plusDays(lastRecordOfThisCar.getRentDays()))) {
            float factCoast = factDaysRent * models.get(cars.get(regNumber).getModelName()).getPriceDay();
            lastRecordOfThisCar.setCoast(factCoast);
        }

        // price of petrol
        if (lastRecordOfThisCar.getGasTankPercent() < 100) {
            float petrolCoast = (thisModelGasTank - Math.round((float) thisModelGasTank / 100 * gasTankPercent)) * gasPrice;
            lastRecordOfThisCar.setCoast(lastRecordOfThisCar.getCoast() + petrolCoast);
        }

        if (lastRecordOfThisCar.getDamages() <= DAMAGE_10) {
            cars.get(regNumber).setState(State.GOOD);
        } else if (lastRecordOfThisCar.getDamages() > DAMAGE_10 && lastRecordOfThisCar.getDamages() < DAMAGE_30) {
            cars.get(regNumber).setState(State.BAD);
        } else if (lastRecordOfThisCar.getDamages() >= DAMAGE_30) {
            cars.get(regNumber).setIfRemoved(true);
        }
        cars.get(regNumber).setInUse(false);
        if (!returnedRecords.containsKey(returnDate)) returnedRecords.put(returnDate, new ArrayList<>());
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
        List<Car> removedCar =
                returnedRecords.entrySet().stream()
                        .flatMap(e -> StreamSupport.stream(e.getValue().spliterator(), false))
                        .filter(e -> e.getReturnDate().isBefore(currentDate.minusDays(days)))
                        .filter(e -> e.getDamages() >= DAMAGE_30)
                        .map(e -> cars.get(e.getRegNumber()))
                        .distinct()
                        .collect(Collectors.toList());

//        removedCar.stream().forEach(System.out::println);


        for (int i = 0; i < removedCar.size(); i++) {
            String regNum = removedCar.get(i).getRegNumber();

            Iterator<Map.Entry<Long, List<RentRecord>>> it = driverRecords.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().removeIf(r -> r.getRegNumber().equals(regNum));
            }

            Iterator<Map.Entry<LocalDate, List<RentRecord>>> itDate = returnedRecords.entrySet().iterator();
            while (itDate.hasNext()) {
                itDate.next().getValue().removeIf(r -> r.getRegNumber().equals(regNum));
            }
            carRecords.entrySet().removeIf(r -> cars.get(r.getKey()).getRegNumber().equals(regNum));
            cars.entrySet().removeIf(e -> e.getValue().getRegNumber().equals(regNum));
        }
        returnedRecords.entrySet().removeIf(e -> e.getValue().size() == 0);
        driverRecords.entrySet().removeIf(e -> e.getValue().size() == 0);




//        System.out.println();
//        System.out.println("--------- driver ----------");
//        driverRecords.entrySet().stream()
//                .flatMap(e -> StreamSupport.stream(e.getValue().spliterator(), false))
//                .forEach(System.out::println);
//        System.out.println("--------- carRecords ----------");
//        carRecords.entrySet().stream()
//                .flatMap(e -> StreamSupport.stream(e.getValue().spliterator(), false))
//                .forEach(System.out::println);
//        System.out.println("--------- car ----------");
//        cars.entrySet().stream().forEach(System.out::println);
//        System.out.println("--------- returned ----------");
//        returnedRecords.entrySet().stream()
//                .flatMap(e -> StreamSupport.stream(e.getValue().spliterator(), false))
//                .forEach(System.out::println);

        return removedCar;
    }


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

        Long max = mostPopularModel.entrySet().stream()
                .map(e -> e.getValue())
                .max((n1, n2) -> Long.compare(n1, n2)).orElse(null);

        return mostPopularModel.entrySet().stream()
                .filter(e -> e.getValue().equals(max))
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    @Override
    public double getModelProfit(String modelName) {
        return returnedRecords.entrySet().stream()
                .flatMap(e -> StreamSupport.stream(e.getValue().spliterator(), false))
                .filter(e -> cars.get(e.getRegNumber()).getModelName().equals(modelName))
                .mapToDouble(e -> e.getCoast()).sum();
    }

    @Override
    public List<String> getMostProfitModelNames() {
        Map<String, Double> a = returnedRecords.entrySet().stream()
                .flatMap(e -> StreamSupport.stream(e.getValue().spliterator(), false))
                .collect(Collectors.groupingBy(t -> cars.get(t.getRegNumber()).getModelName(), Collectors.summingDouble(RentRecord::getCoast)));


        Double max = a.entrySet().stream()
                .map(e -> e.getValue())
                .max((n1, n2) -> Double.compare(n1, n2)).orElse(null);

        return a.entrySet().stream()
                .filter(e -> e.getValue().equals(max))
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

}
