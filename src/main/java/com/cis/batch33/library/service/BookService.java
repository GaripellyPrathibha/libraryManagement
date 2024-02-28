package com.cis.batch33.library.service;

import com.cis.batch33.library.entity.LibraryBook;
import com.cis.batch33.library.model.Book;
import com.cis.batch33.library.model.IsbnDTO;
import com.cis.batch33.library.repository.LibraryBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private LibraryBookRepository bookRepository;

    public LibraryBook updateBook(Integer bookId, LibraryBook updatedBook) {
        Optional<LibraryBook> existingBookOptional = bookRepository.findById(bookId);

        if (existingBookOptional.isPresent()) {
            LibraryBook existingBook = existingBookOptional.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setYearPublished(updatedBook.getYearPublished());
            return bookRepository.save(existingBook);
        } else {
            return null;
        }
    }

    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    public LibraryBook createBook(LibraryBook book) {

        Integer bookId = new Random().nextInt();
        book.setBookId(bookId);
        return bookRepository.save(book);
    }

    public Book getBook(Integer bookId) {
        Optional<LibraryBook> bookOptional =
                bookRepository.findById(bookId);
        LibraryBook libraryBook =
                bookOptional.orElse(new LibraryBook());

        Book book = new Book();
        book.setBookId(libraryBook.getBookId());
        book.setTitle(libraryBook.getTitle());
        book.setAuthor(libraryBook.getAuthor());
        book.setYearPublished(libraryBook.getYearPublished());
        book.setQuantity(libraryBook.getQuantity());

        List<IsbnDTO> bookIsbnDTOS =
                libraryBook.getIsbns().stream().map(b -> {
                    IsbnDTO bdo = new IsbnDTO();
                    bdo.setIsbn(b.getIsbn());
                    bdo.setBookId(b.getBookId());
                    return bdo;
                }).collect(Collectors.toList());
        book.setIsbns(bookIsbnDTOS);
        return book;
    }
}

