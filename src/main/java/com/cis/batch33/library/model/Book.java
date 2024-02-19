package com.cis.batch33.library.model;

public class Book {
    private Long bookId;
    private String title;
    private String author;
    private int yearPublished;

    public Long getBookId() {
        return bookId;
    }

    public Book()
    {

    }

    public Book(Long bookId,String title,String author,int yearPublished) {
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.yearPublished = yearPublished;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
