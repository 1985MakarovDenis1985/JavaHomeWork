package prodController;

import productsObj.Food;
import productsObj.Meat;
import productsObj.Milk;
import productsObj.Product;

public class ProdApp {
    public static void main(String[] args) {
        Product[] products = new Product[4];
        products[0] = new Product("Bread", 15, 668986581);
        products[1] = new Food("Fish", 25, 879865765, true, "15.10.2021", 25);
        products[2] = new Milk("Milk", 12, 29842908, true, "15.10.2021", 33, 1.5, "Cow");
        products[3] = new Meat("Meat", 67, 879865765, false, "15.10.2021","Pig");

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
            products[i].printDataSale();
            if (i !=  products.length-1){
                System.out.println("============== NEXT PRODUCT==============");
            }
        }
    }
}
