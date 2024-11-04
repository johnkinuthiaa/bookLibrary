package com.slippery.booklibrary.service;

import com.slippery.booklibrary.dao.BookResponseDao;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    BookResponseDao createBook(BookResponseDao bookDetails);
    BookResponseDao updateBook(BookResponseDao bookDetails);
    BookResponseDao deleteBookById(Long id);
    BookResponseDao deleteAllBooks(BookResponseDao bookDetails);
    List<BookResponseDao> getBookByName(String name);
}
