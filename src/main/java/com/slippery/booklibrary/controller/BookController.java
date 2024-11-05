package com.slippery.booklibrary.controller;

import com.slippery.booklibrary.models.Book;
import com.slippery.booklibrary.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

//    Book deleteBookById(Long id);
//    void deleteAllBooks();
//    ;
//    List<Book> getBookByAuthor(String author);
    private final  BookService service;

    public BookController(BookService service) {
        this.service = service;
    }
    @PostMapping("/add/books")
    public Book createBook(@RequestBody Book book) {
        return service.createBook(book);

    }
    @PutMapping("/update/book")
    public Book updateBook(@RequestBody Book bookDetails,@RequestParam Long id){
        return service.updateBook(bookDetails,id);
    }
    @GetMapping("/all/books")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }
    @GetMapping("/get/id")
    public Book findBookById(@RequestParam Long id){
        return service.findBookById(id);
    }
    @GetMapping("/get/name")
    public List<Book> getBookByName(@RequestParam String name){
        return service.getBookByName(name);
    }
    @GetMapping("/get/name")
    public List<Book> getBookByAuthor(@RequestParam String name){
        return service.getBookByAuthor(name);
    }
    @DeleteMapping("/delete/id")
    public Book deleteBookById(@RequestParam Long id){
        return service.deleteBookById(id);
    }
    @DeleteMapping("/delete/all")
    public void deleteAllBooks(){
        service.deleteAllBooks();
    }

}
