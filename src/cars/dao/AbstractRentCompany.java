package cars.dao;

import cars.domain.Car;
import cars.domain.Driver;
import cars.domain.Model;
import cars.domain.RentRecord;
import enums.CarsReturnCode;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractRentCompany implements IRentCompany{
    protected int finePercent;
    protected int gasPrice;

    public AbstractRentCompany() {
        this.finePercent = 15;
        this.gasPrice = 10;
    }

    public void setFinePercent(int finePercent) {
        this.finePercent = finePercent;
    }

    public void setGasPrice(int gasPrice) {
        this.gasPrice = gasPrice;
    }

    public int getFinePercent() {
        return finePercent;
    }

    public int getGasPrice() {
        return gasPrice;
    }

    @Override
    public String toString() {
        return "AbstractRentCompany{" +
                "finePercent=" + finePercent +
                ", gasPrice=" + gasPrice +
                '}';
    }

}
