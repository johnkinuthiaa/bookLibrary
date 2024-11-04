package com.slippery.booklibrary.service;

import com.slippery.booklibrary.dao.BookResponseDao;

import java.util.List;

public class BookServiceImpl implements BookService{
    @Override
    public BookResponseDao createBook(BookResponseDao bookDetails) {
        return null;
    }

    @Override
    public BookResponseDao updateBook(BookResponseDao bookDetails) {
        return null;
    }

    @Override
    public BookResponseDao deleteBookById(Long id) {
        return null;
    }

    @Override
    public BookResponseDao deleteAllBooks(BookResponseDao bookDetails) {
        return null;
    }

    @Override
    public List<BookResponseDao> getBookByName(String name) {
        return List.of();
    }
}
