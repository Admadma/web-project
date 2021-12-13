package com.example.primefaces.books;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService{

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init(){
        createBook(new Book("Dune", "Frank Herbert", 412));
        createBook(new Book("Gyilkosság az Orient expresszen", "Agatha Christie", 256));
        createBook(new Book("Quantum Break", "Cam Rogers", 448));
        createBook(new Book("Harry Potter és a bölcsek köve", "J. K. Rowling", 223));
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        if(!Objects.isNull(book.getId())){
            bookRepository.save(new Book(book.getId(),
                                        book.getName(),
                                        book.getAuthor(),
                                        book.getNumberOfPages()));
        }
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = new LinkedList<Book>();
        bookRepository.findAll().forEach(s -> books.add(s));
        return books;
    }
}
