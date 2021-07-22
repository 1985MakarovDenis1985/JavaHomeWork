package productsObj;

import java.util.Objects;

public class Milk extends Food {
    double fat;
    String milkType;

    public Milk(String name, double price, long barCode, boolean kosher, String expDate, double sale, double fat, String milkType) {
        super(name, price, barCode, kosher, expDate, sale);
        this.fat = fat;
        this.milkType = milkType;
    }

    public Milk(String name, double price, long barCode, boolean kosher, String expDate, double fat, String milkType) {
        super(name, price, barCode, kosher, expDate);
        this.fat = fat;
        this.milkType = milkType;
    }

    public Milk(boolean kosher, String expDate, double fat, String milkType) {
        super(kosher, expDate);
        this.fat = fat;
        this.milkType = milkType;
    }

    public Milk(double fat, String milkType) {
        super();
        this.fat = fat;
        this.milkType = milkType;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public String getMilkType() {
        return milkType;
    }

    public void setMilkType(String milkType) {
        this.milkType = milkType;
    }

    public String toString() {
        return super.toString() + " | Fat: " + fat + " | Milk type: " + milkType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Milk)) return false;
        if (!super.equals(o)) return false;
        Milk milk = (Milk) o;
        return super.equals(milk) && milk.fat == this.fat && this.milkType.equals(milk.milkType);
    }

}
