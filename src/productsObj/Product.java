package productsObj;

public class Product {
    String name;
    double price;
    long barCode;
    double sale;

    public Product(String name, double price, long barCode, double sale) {
        this.name = name;
        this.price = price;
        this.barCode = barCode;
        this.sale = sale;
    }

    public Product(String name, double price, long barCode) {
        this.name = name;
        this.price = price;
        this.barCode = barCode;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getBarCode() {
        return barCode;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(long barCode) {
        this.sale = sale;
    }

    public String toString() {
        return "Name: " + ((getName() == null) ? "Unknown" : getName()) + " | Price: " + getPrice() + " | Code: " + barCode + " | Sale: " + sale;
    }

    public void printDataSale() {
        double percent = price / 100 * sale;
        double newPrice = price - percent;
        if (percent != 0){
            System.out.println("Sale: " + sale + "% | New price: " + newPrice + " -> code of product: " + barCode);
        } else {
            System.out.println("Without sale :(");
        }

    }
}
