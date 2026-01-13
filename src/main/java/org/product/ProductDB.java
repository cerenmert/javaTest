package org.product;

import java.util.HashMap;

public class ProductDB {
    private HashMap<Product, Double> productMap;

    //initialize the map in the constructor
    public ProductDB() {
        productMap = new HashMap<>();
    }

    // method to add a product with its price to the map in the database
    public void addProduct(Product product, Double price) {
        productMap.put(product, price);
    }

    // method to fetch/get a price for a given product
    public Double getPrice(Product product) {
        return productMap.get(product);
    }

    public void removeProductFromDB(Product product) {
        productMap.remove(product);
    }
    public Boolean containsProduct(Product product) {
        return productMap.containsKey(product);
    }
}
