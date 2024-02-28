package com.cis.batch33.library.model;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private Integer bookId;
    private String title;
    private String author;
    private int yearPublished;
    private Integer quantity;
    private List<IsbnDTO> isbns;


}
