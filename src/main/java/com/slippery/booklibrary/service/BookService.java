package com.slippery.booklibrary.service;

import com.slippery.booklibrary.models.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book updateBook(Book bookDetails);
    Book deleteBookById(Long id);
    Book deleteAllBooks(Book bookDetails);
    List<Book> getBookByName(String name);
}
