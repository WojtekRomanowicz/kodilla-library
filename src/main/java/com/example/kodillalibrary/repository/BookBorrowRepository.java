package com.example.kodillalibrary.repository;

import com.example.kodillalibrary.domain.BookBorrow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BookBorrowRepository extends CrudRepository<BookBorrow, Integer> {
    @Override
    List<BookBorrow> findAll();

    @Override
    BookBorrow save(BookBorrow bookBorrow);

    @Override
    Optional<BookBorrow> findById(Integer id);
}