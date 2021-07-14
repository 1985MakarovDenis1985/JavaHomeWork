package productsObj;

public class Meat extends Food{
    String meatType;

    public Meat(String name, double price, long barCode, boolean kosher, String expDate, double sale, String meatType) {
        super(name, price, barCode, kosher, expDate, sale);
        this.meatType = meatType;
    }
    public Meat(String name, double price, long barCode, boolean kosher, String expDate, String meatType) {
        super(name, price, barCode, kosher, expDate);
        this.meatType = meatType;
    }
    public Meat(boolean kosher, String expDate, String meatType) {
        super(kosher, expDate);
        this.meatType = meatType;
    }
    public Meat(String meatType) {
        this.meatType = meatType;
    }

    public String getMeatType() {
        return meatType;
    }
    public void setMeatType(String milkType) {
        this.meatType = meatType;
    }


    public String toString(){
        return  super.toString() + " | Meat type: " + meatType;
    }
}
