package com.cis.batch33.library.service;

import com.cis.batch33.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {
    private Map<Long, Book> bookMap = new HashMap<>();
    private long bookIdCounter=1;
    public Book updateBook(Long bookId, Book updatedBook) {
        if (bookMap.containsKey(bookId)) {
            updatedBook.setBookId(bookId);
            bookMap.put(bookId, updatedBook);
            return updatedBook;
        } else {
            return null;
        }
    }

    public void deleteBook(Long bookId) {
        bookMap.remove(bookId);
    }

    public Book createBook(Book book) {

        book.setBookId(bookIdCounter++);
        bookMap.put(book.getBookId(), book);
        return book;
    }

    public Book getBook(Long bookId) {
        return bookMap.get(bookId);
    }
}

