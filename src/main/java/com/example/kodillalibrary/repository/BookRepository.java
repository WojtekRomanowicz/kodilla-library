package com.example.kodillalibrary.repository;

import com.example.kodillalibrary.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Integer> {
    @Override
    List<Book> findAll();

    @Override
    Book save(Book Book);

    @Override
    Optional<Book> findById(Integer id);


    Book findByAuthor(String author);
}