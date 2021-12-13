package com.example.primefaces.books;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named("dtBookService")
@ViewScoped
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    List<Book> books;

    @PostConstruct
    public void init(){
        books = bookService.getBooks();
    }

    public List<Book> getBooks() {
        books = bookService.getBooks();
        return books;
    }

    public void addBook(){

    }

    public void deleteBook(Book book){
        bookService.deleteBook(book);
    }
}
