package com.cis.batch33.library.controller;
import com.cis.batch33.library.entity.LibraryBook;
import com.cis.batch33.library.model.Book;
import com.cis.batch33.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Integer bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping("/")
    public LibraryBook createBook(@RequestBody LibraryBook book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{bookId}")
    public LibraryBook updateBook(@PathVariable Integer bookId, @RequestBody LibraryBook updatedBook) {
        return bookService.updateBook(bookId, updatedBook);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
    }
}

