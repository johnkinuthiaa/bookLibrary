package com.slippery.booklibrary.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.slippery.booklibrary.models.Book;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponseDao {
    private int statusCode;
    private String error;
    private String message;
    private Book book;
    private List<Book> books;
}
