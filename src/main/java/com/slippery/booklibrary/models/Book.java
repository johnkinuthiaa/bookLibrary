package com.slippery.booklibrary.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String bookTitle;
    private String bookAuthor;
    private Integer yearOfPublication;
    private String publisher;
    private String imageUrl;
    private boolean isBorrowed;
    @ManyToOne
    @JoinColumn(name = "borrowed_by_id")
    private User borrowedBy;

}
