package com.cis.batch33.library.repository;

import com.cis.batch33.library.entity.LibraryBook;
import com.cis.batch33.library.entity.LibraryMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBookRepository  extends JpaRepository<LibraryBook, Integer> {
}
