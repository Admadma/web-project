package com.example.primefaces.books;

import java.util.List;

public interface BookService {

    void createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Book book);

    List<Book> getBooks();

}
