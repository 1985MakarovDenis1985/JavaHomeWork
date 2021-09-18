package cars.domain;

import java.time.LocalDate;

public class RentRecord {

    long licence;
    String regNumber;
    LocalDate rentDate;
    LocalDate returnDate;
    int gasTankPercent; // percent of full tank at return
    int rentDays; // rent period  with prepayment
    float coast; // overall coast
    int damages; // percent of damages

    public RentRecord() {}

    public RentRecord(long licence, String regNumber, LocalDate rentDate, int rentDays) {
        this.licence = licence;
        this.regNumber = regNumber;
        this.rentDate = rentDate;
        this.rentDays = rentDays;
    }

    public long getLicence() {
        return licence;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getGasTankPercent() {
        return gasTankPercent;
    }

    public int getRentDays() {
        return rentDays;
    }

    public float getCoast() {
        return coast;
    }

    public int getDamages() {
        return damages;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setGasTankPercent(int gasTankPercent) {
        this.gasTankPercent = gasTankPercent;
    }

    public void setCoast(float coast) {
        this.coast = coast;
    }

    public void setDamages(int damages) {
        this.damages = damages;
    }

    @Override
    public String toString() {
        return "RentRecord{" +
                "licence=" + licence +
                ", regNumber='" + regNumber + '\'' +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                ", gasTankPercent=" + gasTankPercent +
                ", rentDays=" + rentDays +
                ", coast=" + coast +
                ", damages=" + damages +
                '}';
    }
}
