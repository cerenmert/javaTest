package org.book;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTest {
    private BookStore bookStore;

    @BeforeMethod
    public void setUp() {
        bookStore = new BookStore();
    }

    @Test
    public void testAddUniqueBooks() {
        Book book1 = new Book("978-3-16-148410-0", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("978-0-13-468599-1", "Clean Code", "Robert C. Martin");

        Assert.assertTrue(bookStore.addBook(book1), "First book should be added successfully");
        Assert.assertTrue(bookStore.addBook(book2), "Second unique book should be added successfully");
        Assert.assertEquals(bookStore.getBookCount(), 2, "Book store should contain 2 books");
    }

    @Test
    public void testAddDuplicateBooks() {
        Book book1 = new Book("978-3-16-148410-0", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("978-3-16-148410-0", "Effective Java", "Joshua Bloch"); // Same ISBN

        Assert.assertTrue(bookStore.addBook(book1), "First book should be added");
        Assert.assertFalse(bookStore.addBook(book2), "Duplicate book should not be added");
        Assert.assertEquals(bookStore.getBookCount(), 1, "Book store should still contain only 1 book");
    }

    @Test
    public void testFetchBook() {
        String isbn = "978-3-16-148410-0";
        Book book = new Book(isbn, "Effective Java", "Joshua Bloch");
        bookStore.addBook(book);

        Book fetchedBook = bookStore.fetchBook(isbn);
        Assert.assertNotNull(fetchedBook, "Should be able to fetch existing book");
        Assert.assertEquals(fetchedBook.getIsbn(), isbn, "Fetched book ISBN should match");
        Assert.assertEquals(fetchedBook.getTitle(), "Effective Java", "Fetched book title should match");
    }

    @Test
    public void testFetchNonExistentBook() {
        Book fetchedBook = bookStore.fetchBook("999-999-9999");
        Assert.assertNull(fetchedBook, "Fetching non-existent book should return null");
    }

    @Test
    public void testContainsBook() {
        Book book = new Book("12345", "Test Book", "Test Author");
        bookStore.addBook(book);

        // Create a new object with same ISBN to test equality check
        Book lookupBook = new Book("12345", "Test Book", "Test Author");
        Assert.assertTrue(bookStore.containsBook(lookupBook),
                "Store should contain the book (checked by ISBN equality)");
    }
}
