package com.cis.batch33.library.entity;

import  com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "book")
@Entity
@Data
public class LibraryBook {
    @Id
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "author_name")
    private String author;

    @Column(name = "year_published")
    private Integer yearPublished;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "libraryBook", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<LibraryIsbn> isbns;


}
