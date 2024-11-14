package com.slippery.booklibrary.controller;

import com.slippery.booklibrary.models.Book;
import com.slippery.booklibrary.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }
    @PostMapping("/admin/add/books")
    public Book createBook(@RequestBody Book book) {
        return service.createBook(book);

    }
    @PutMapping("/admin/update/book")
    public Book updateBook(@RequestBody Book bookDetails,@RequestParam Long id){
        return service.updateBook(bookDetails,id);
    }
    @GetMapping("/adminuser/all/books")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }
    @GetMapping("/get/id")
    public Book findBookById(@RequestParam Long id){
        return service.findBookById(id);
    }
    @GetMapping("/user/get/name")
    public List<Book> getBookByName(@RequestParam String name){
        return service.getBookByName(name);
    }
    @GetMapping("/user/get/author")
    public List<Book> getBookByAuthor(@RequestParam String name){
        return service.getBookByAuthor(name);
    }
    @DeleteMapping("/admin/delete/id")
    public Book deleteBookById(@RequestParam Long id){
        return service.deleteBookById(id);
    }
    @DeleteMapping("/admin/delete/all")
    public void deleteAllBooks(){
        service.deleteAllBooks();
    }

    @PostMapping("/admin/input/array")
    public void insertArray(@RequestBody List<Book> bookList) {
        for(Book book : bookList) {
            ResponseEntity.ok(service.createBook(book));
        }
    }


}
