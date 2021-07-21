package productsObj;

import java.util.Objects;

public class Food extends Product {
    private boolean kosher;
    private String expDate;

    public Food(String name, double price, long barCode, boolean kosher, String expDate, double sale) {
        super(name, price, barCode, sale);
        this.kosher = kosher;
        this.expDate = expDate;
    }
    public Food(String name, double price, long barCode, boolean kosher, String expDate) {
        super(name, price, barCode);
        this.kosher = kosher;
        this.expDate = expDate;
    }

    public Food(boolean kosher, String expDate) {
        this.kosher = kosher;
        this.expDate = expDate;
    }

    public Food() {

    }

    public boolean isKosher() {
        return kosher;
    }

    public void setKosher(boolean kosher) {
        this.kosher = kosher;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString(){
        return  super.toString() + " | Kosher: " + ((kosher) ? "Yes" : "No" )
                + " | Exp Date: " + expDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Food)) return false;
        if (!super.equals(obj)) return false;
        Food food = (Food) obj;
        return super.equals(food) && this.kosher == food.kosher && this.expDate.equals(food.expDate);
    }

//    стартовая функция
//    @Override
//    public boolean equals(Object obj) {
//        Food product = (Food) obj;
//        return super.equals(product) && this.kosher == product.kosher && this.expDate.equals(product.expDate);
//    }
}
