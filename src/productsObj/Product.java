package productsObj;

public class Product {
    String name;
    double price;
    long barCode;
    double sale;
    double newPrice;

    public Product(String name, double price, long barCode, double sale) {
        this.name = name;
        this.price = (price < 0) ? -price : price;
        this.barCode = barCode;
        this.sale = sale;
    }

    public Product(String name, double price, long barCode) {
        this.name = name;
        this.price = (price < 0) ? -price : price;
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

    public void setSale(double sale) {
        this.sale = sale;
        this.newPrice = price - percent();
    }

    public double getNewPrice() {
        return (sale != 0.0) ? price - percent() : price;
    }

    public double percent() {
        double percent = price / 100 * sale;
        return percent;
    }

    public void printDataSale() {
        double percent = price / 100 * sale;
        newPrice = price - percent;
        if (percent != 0) {
            System.out.println("Sale: " + sale + "% | New price: " + newPrice + " ILS" + " -> code of product: " + barCode);
        } else {
            System.out.println("Without sale :(");
        }
    }

    @Override
    public String toString() {
        return "Name: " + ((getName() == null) ? "Unknown" : getName()) + " | Price: " + getPrice() + " | Sale: " +
                ((getSale() != 0.0) ? sale + "%" + " -> new price: " + getNewPrice() + " ILS" : "without sale :(") +
                " | Code: " + barCode;
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        return this.price == product.price && this.barCode == product.barCode &&  this.sale == product.sale && this.newPrice == product.newPrice && this.name.equals(product.name);
    }

//    public boolean equals(Object obj) {
//        Product product = (Product) obj;
//        return Double.compare(product.price, price) == 0 && barCode == product.barCode && Double.compare(product.sale, sale) == 0 && Double.compare(product.newPrice, newPrice) == 0 && Objects.equals(name, product.name);
//    }

//
}
