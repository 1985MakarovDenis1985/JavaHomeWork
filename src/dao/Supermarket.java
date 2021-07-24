package dao;

import models.Product;
import models.Food;
import models.Milk;
import models.Meat;

public class Supermarket {

    private Product[] products;
    private int currentIdx;

    public int getCurrentIdx() {
        return currentIdx;
    }

    public Supermarket(int capacity) {
        this.products = new Product[capacity];
    }

    /*
     переделал функцию /addProduct/, что бы добавляла в случае нахождение уже такого продукта увеличивала его количество на полке
     (Вы говорили что можно добавлять свой функционал)
    */
//    public void addProduct(Product product) {
//        if (currentIdx < products.length && findProduct(product.getBarCode()) == null) {
//            products[currentIdx] = product;
//            currentIdx++;
//        } else if (findProduct(product.getBarCode()) != null) {
//            Product oldProduct = findProduct(product.getBarCode());
//            oldProduct.setCount(product.getCount() + oldProduct.getCount());
//        }
//    }


    public boolean addProduct(Product product) {
        if (currentIdx < products.length && findProduct(product.getBarCode()) == null) {
            products[currentIdx] = product;
            currentIdx++;
            return true;
        }
        return false;
    }

    public Product findProduct(long barCode) {
        for (int i = 0; i < currentIdx; i++) {
            if (products[i].getBarCode() == barCode) {
                return products[i];
            }
        }
        return null;
    }

    /* remove которая уменьшает количество товара а затем удаляет */
//    public boolean removeProd(long barCode) {
//        for (int i = 0; i < currentIdx; i++) {
//            if (products[i].getBarCode() == barCode) {
//                products[i].setCount(products[i].getCount() - 1); // уменьшаю количество продуктов на 1
//            }
//            if (products[i].getCount() == 0) {
//                for (int j = i; j < currentIdx; j++) {
//                    products[j] = products[j + 1];
//                }
//                products[currentIdx - 1] = null; // удаляю элемент если кол 0
//                currentIdx -= 1;
//            }
//        }
//        return false;
//    }

    public boolean removeProd(long barCode) {
        for (int i = 0; i < currentIdx; i++) {
            if (products[i].getBarCode() == barCode) {
                for (int j = i; j < currentIdx-1; j++) {
                    products[j] = products[j + 1];
                }
                products[currentIdx-1] = null;
                currentIdx--;
                return true;
            }
        }
        return false;
    }

    public void printKosherProd() {
        for (int i = 0; i < currentIdx; i++) {
            if (products[i] instanceof Food && ((Food) products[i]).isKosher()) {
                System.out.println(products[i]);
                if (i != products.length - 1)
                    System.out.println("============== NEXT PRODUCT==============");
            }
        }
    }

    public void printNotKosherProd() {
        for (int i = 0; i < currentIdx; i++) {
            if (products[i] instanceof Food && !((Food) products[i]).isKosher()) {
                System.out.println(products[i]);
                if (i != products.length - 1)
                    System.out.println("============== NEXT PRODUCT==============");
            }
        }
    }

    public double totalPrice() {
        double sum = 0;
        for (int i = 0; i < currentIdx; i++) {
            sum += products[i].getPrice();
        }
        return sum;
    }

    public void getSameTypeOfMilk(String type) {
        int countProd = 0;
        for (int i = 0; i < currentIdx; i++) {
            if (products[i] instanceof Milk && ((Milk) products[i]).getMilkType().equals(type)) {
                System.out.println(products[i]);
                countProd += 1;
            }
        }
        System.out.println("Product from " + type + ": " + countProd);
    }

    public void getSameTypeOfMeat(String type) {
        int countProd = 0;
        for (int i = 0; i < currentIdx; i++) {
            if (products[i] instanceof Meat && ((Meat) products[i]).getMeatType().equals(type)) {
                System.out.println(products[i]);
                countProd += 1;
            }
        }
        System.out.println("Product from " + type + ": " + countProd);
    }

    public void printAllProducts() {
        for (int i = 0; i < currentIdx; i++) {
            System.out.println(products[i]);
            if (i != currentIdx - 1) {
                System.out.println("============== NEXT PRODUCT==============");
            }
        }
        System.out.println("====================================");
        System.out.println(currentIdx + " products in the mall");

    }
}
