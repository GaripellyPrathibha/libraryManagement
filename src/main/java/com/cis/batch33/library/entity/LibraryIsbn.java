package com.cis.batch33.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Table(name="isbn")
@Entity
@Data
public class LibraryIsbn {
    @Id
    @Column(name = "isbn")
    private Long isbn;
    @Column(name = "book_id", insertable = false, updatable = false)
    private Integer bookId;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private LibraryBook libraryBook;
}
