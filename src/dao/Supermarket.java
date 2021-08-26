package dao;

import model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Supermarket implements ISuperMarket{

    Collection<Product> productCollection ;

    public Supermarket() {
        productCollection = new ArrayList<>();
    }

    @Override
    public boolean addProduct(Product product) {
        if (productCollection.contains(product)) return false;
        productCollection.add(product);
        return true;
    }

    @Override
    public Product removeProduct(long barCode) {
        Product p = findByBarCode(barCode);
        if (p != null) productCollection.remove(p);
        return p;
    }


    @Override
    public Product findByBarCode(long barCode) {
        for (Product p : productCollection){
            if (p.getBarCode() == barCode) return p;
        }
        return null;
    }

    @Override
    public Iterable<Product> findByCategory(String category) {
        Collection<Product> temp = new ArrayList<>();
        for (Product p : productCollection) {
            if (p.getCategory().equals(category)) temp.add(p);
        }
        return temp;
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        Collection<Product> temp = new ArrayList<>();
        for (Product p : productCollection) {
            if (p.getBrand().equals(brand)) temp.add(p);
        }
        return temp;
    }

    @Override
    public Iterable<Product> findProductWithExpDate() {
        Collection<Product> temp = new ArrayList<>();
        for (Product p : productCollection) {
            if (p.getExpDate().isBefore(LocalDate.now())) temp.add(p);
        }
        return temp;
    }

    @Override
    public int skuQuantity() {
        return productCollection.size();
    }

    @Override
    public Iterator<Product> iterator() {
        return productCollection.iterator();
    }
}
