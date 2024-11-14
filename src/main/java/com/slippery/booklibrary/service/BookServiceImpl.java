package com.slippery.booklibrary.service;

import com.slippery.booklibrary.models.Book;
import com.slippery.booklibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository){
        this.repository=repository;
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Book createBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book updateBook(Book bookDetails,Long id) {
        if(repository.findById(id).isPresent()){
            repository.delete(repository.findById(id).orElseThrow());

        }else{
            throw new RuntimeException("book not found");
        }
        return repository.save(bookDetails);
    }

    @Override
    public Book deleteBookById(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("book with id "+id+"not found");
        }
        repository.deleteById(id);
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void deleteAllBooks() {
        repository.deleteAll();
    }

    @Override
    public List<Book> getBookByName(String name) {
        return repository.findAll().stream()
                .filter(book->book.getBookTitle().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        return repository.findAll().stream()
                .filter(book->book.getBookTitle().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }



}
