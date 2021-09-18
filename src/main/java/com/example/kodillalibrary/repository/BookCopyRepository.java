package com.example.kodillalibrary.repository;

import com.example.kodillalibrary.domain.BookCopy;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BookCopyRepository extends CrudRepository<BookCopy, Integer> {
    @Override
    List<BookCopy> findAll();

    @Override
    BookCopy save(BookCopy bookCopy);

    @Override
    Optional<BookCopy> findById(Integer id);
}