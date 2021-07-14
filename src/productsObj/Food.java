package productsObj;

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

    public String toString(){
        return  super.toString() + " | Kosher: " + kosher + " | Exp Date: " + expDate;
    }
}
