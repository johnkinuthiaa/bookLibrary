package com.slippery.booklibrary.service;

import com.slippery.booklibrary.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Book findBookById(Long id);
    Book createBook(Book book);
    Book updateBook(Book bookDetails,Long id);
    Book deleteBookById(Long id);
    void deleteAllBooks();
    List<Book> getBookByName(String name);
    List<Book> getBookByAuthor(String author);
}
