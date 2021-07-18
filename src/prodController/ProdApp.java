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

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Bread", 15, 668986581);
        products[1] = new Food("Fish", 25, 879865765, true, "15.10.2021", 25);
        products[2] = new Milk("Milk", 12, 29842908, true, "15.11.2021", 33, 1.5, "Cow");
        products[3] = new Meat("Meat", 67, 779875765, false, "17.08.2021", "Pig");
        products[4] = new Meat("cheese", -37, 874875765, true, "08.09.2021", "Goat");

//        products[1].printDataSale();
//        displayAllProducts(products);
        displayProductsKosher(products);
//        System.out.println("sum all: " + totalPrice(products));
//        System.out.println("sum kosher: " + totalPriceKosher(products));
    }
}

// распечатать только кошерные продукты, сумму общюю, сумму только кошерных продуктов
