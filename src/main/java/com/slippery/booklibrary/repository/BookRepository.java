package com.slippery.booklibrary.repository;

import com.slippery.booklibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book findByAuthor(String author);
    Book findByBookName(String bookName);
}
