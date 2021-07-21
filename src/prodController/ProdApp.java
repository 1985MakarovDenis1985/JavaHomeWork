package prodController;

import productsObj.Food;
import productsObj.Meat;
import productsObj.Milk;
import productsObj.Product;

public class ProdApp {

    public static void displayAllProducts(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
            if (i != products.length - 1) {
                System.out.println("============== NEXT PRODUCT==============");
            }
        }
    }

    public static void displayProductsKosher(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] instanceof Food && ((Food) products[i]).isKosher()) {
                System.out.println(products[i]);
                if (i != products.length - 1)
                    System.out.println("============== NEXT PRODUCT==============");
            }
        }
    }

    public static double totalPrice(Product[] products) {
        double sum = 0;
        for (int i = 0; i < products.length; i++) {
            sum += products[i].getPrice();
        }
        return sum;
    }

    public static double totalPriceKosher(Product[] products) {
        double sum = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] instanceof Food && ((Food) products[i]).isKosher()) {
                sum += products[i].getPrice();
            }
        }
        return sum;
    }

    public static void getSameType(Product[] products, String type) {
        int countProd = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] instanceof Milk && ((Milk) products[i]).getMilkType().equals(type) || products[i] instanceof Meat && ((Meat) products[i]).getMeatType().equals(type)) {
                System.out.println(products[i]);
                countProd += 1;
            }
        }
        System.out.println("Product from " + type + ": " + countProd);
    }

    public static void main(String[] args) {
        Product[] products = new Product[8];
        products[0] = new Product("Bread", 15, 668986581);
        products[1] = new Food("Fish", 25, 879865765, true, "15.10.2021", 25);
        products[2] = new Milk("Milk", 12, 29842908, true, "15.11.2021", 33, 1.5, "Goat");
        products[3] = new Meat("Meat", 67, 779875765, false, "17.08.2021", "Pig");
        products[4] = new Milk("Milk", 8, 57842943, true, "11.11.2021", 23, 1.5, "Goat");
        products[5] = new Meat("Meat", 45, 779875756, false, "17.08.2021", "Pig");
        products[6] = new Meat("Meat", 70, 55687432, false, "17.08.2021", "Pig");
        products[7] = new Meat("Meat", 54, 345875789, false, "17.08.2021", "Pig");

//        Product p = new Meat("Meat", 67, 779875765, false, "17.08.2021", "Pig");
//        System.out.println(p.equals(products[4]));

//        products[1].printDataSale();
//        displayAllProducts(products);
//        displayProductsKosher(products);
//        System.out.println("sum all: " + totalPrice(products));
//        System.out.println("sum kosher: " + totalPriceKosher(products));
        getSameType(products, "Pig");
    }
}