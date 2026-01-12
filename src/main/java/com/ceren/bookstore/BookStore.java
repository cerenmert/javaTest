package com.ceren.bookstore;

import java.util.HashSet;
import java.util.Set;

public class BookStore {
    private Set<Book> books;

    public BookStore() {
        this.books = new HashSet<>();
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    /*
    // Book.java içinde equals/hashCode olmadığını varsayalım
    // Dezavantajı: Performans kaybı. HashSet normalde bir kitabı "şıp" diye tek seferde (O(1) hızında) bulur,
    // Bu yöntemde her ekleme işleminde, mağazadaki tüm kitapları tek tek gezmek (O(N) hızında) zorunda kalırız.
    // Binlerce kitap olduğunda sistem çok yavaşlar.
    public boolean addBook(Book newBook) {
        // 1. Önce içeride bu ISBN'e sahip kitap var mı diye TEK TEK bak
        for (Book existingBook : books) {
            if (existingBook.getIsbn().equals(newBook.getIsbn())) {
                return false; // Bulduk, ekleme yapma.
            }
        }
        // 2. Yoksa ekle
        return books.add(newBook);
    }
     */

    /**
     * Checks if a book exists in the store efficiently using HashSet.
     * Use this if you have a Book object (or a probe with the same ISBN).
     */
    public boolean containsBook(Book book) {
        return books.contains(book);
    }

    /**
     * Fetches a book by ISBN.
     * Note: Since we are using a HashSet, we must iterate to retrieve the actual
     * object if we only have the ISBN.
     * This is O(N). For O(1) retrieval by ISBN, a HashMap<String, Book> would be
     * preferred, but the requirements specified using a HashSet.
     */
    public Book fetchBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null; // Not found
    }

    public int getBookCount() {
        return books.size();
    }
}
