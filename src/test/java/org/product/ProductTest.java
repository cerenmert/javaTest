package org.product;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductTest {

    @Test
    public void testProductMapLookup() {
        ProductDB productDB = new ProductDB();

        // Create some products with name and category
        Product laptop = new Product("MacBook Pro", "Electronics");
        Product phone = new Product("iPhone 15", "Electronics");
        Product book = new Product("The Great Gatsby", "Books");

        // Add them to the database with their prices
        productDB.addProduct(laptop, 2500.00);
        productDB.addProduct(phone, 1200.00);
        productDB.addProduct(book, 15.00);

        // Create a new Product object and try to fetch/get its price from the database
        // This simulates searching for the product
        Product searchedProduct = new Product("MacBook Pro", "Electronics");

        // When a product is searched in the database, its price should be returned
        Double price = productDB.getPrice(searchedProduct);

        // Validate that the price is correct
        assertNotNull(price, "Price should not be null for existing product");
        assertEquals(2500.00, price, "Price should match the inserted value");

        System.out.println("Found price for " + searchedProduct.getName() + ": " + price);
    }
}
