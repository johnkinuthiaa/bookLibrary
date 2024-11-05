package com.slippery.booklibrary.service;

import com.slippery.booklibrary.models.Book;
import com.slippery.booklibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository){
        this.repository=repository;
    }

    @Override
    public Book createBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book updateBook(Book bookDetails) {
        if(repository.findById(bookDetails.getId()).isPresent()){
            repository.delete(repository.findById(bookDetails.getId()).orElseThrow());
            return repository.save(bookDetails);
        }
        return null;
    }

    @Override
    public Book deleteBookById(Long id) {
        return null;
    }

    @Override
    public Book deleteAllBooks(Book bookDetails) {
        return null;
    }

    @Override
    public List<Book> getBookByName(String name) {
        return List.of();
    }
}
