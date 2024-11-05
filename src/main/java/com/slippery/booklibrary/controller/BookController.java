package com.slippery.booklibrary.controller;

import com.slippery.booklibrary.models.Book;
import com.slippery.booklibrary.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    private final  BookService service;

    public BookController(BookService service) {
        this.service = service;
    }
    @PostMapping("/add/books")
    public Book createBook(@RequestBody Book book) {
            return service.createBook(book);

    }

}
