package org.product;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest {

    private ProductDB productDB;

    @BeforeMethod
    public void setUp() {
        productDB = new ProductDB();
    }

    @Test
    public void testAddProduct() {
        // Create some products with name and category
        Product laptop = new Product("MacBook Pro", "Electronics");
        // Add them to the database with their prices
        productDB.addProduct(laptop, 2500.00);
        Assert.assertTrue(productDB.containsProduct(laptop));
    }

    @Test
    public void testGetPrice() {
        Product phone = new Product("iPhone 15", "Electronics");
        productDB.addProduct(phone, 1200.00);
        Double price = productDB.getPrice(phone);
        Assert.assertNotNull(price, "Price should not be null");
        Assert.assertEquals(price, 1200.00, "Price should match inserted value");
    }

    @Test
    public void testProductNotFound() {
        Product unknownProduct = new Product("Unknown", "Misc");
        Double price = productDB.getPrice(unknownProduct);
        Assert.assertNull(price, "Price should be null for non-existent product");
    }
}
