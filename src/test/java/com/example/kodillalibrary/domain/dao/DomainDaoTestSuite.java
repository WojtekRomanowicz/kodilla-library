package com.example.kodillalibrary.domain.dao;

import com.example.kodillalibrary.domain.Book;
import com.example.kodillalibrary.domain.BookCopy;
import com.example.kodillalibrary.domain.User;
import com.example.kodillalibrary.repository.BookCopyRepository;
import com.example.kodillalibrary.repository.BookRepository;
import com.example.kodillalibrary.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DomainDaoTestSuite {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Test
    void testUserRepositorySave() {
        //Given
        User user = new User("Wojtek", "Roman", LocalDate.now());

        //When
        userRepository.save(user);

        //Then
        int id = user.getId();
        Optional<User> readUser = userRepository.findById(id);
        assertTrue(readUser.isPresent());

        //CleanUp
        userRepository.deleteById(id);

    }

    @Test
    void testBookRepositorySave() {
        //Given
        Book book = new Book("Ania z zielonego pagorka", "Jakis pisarz", LocalDate.of(1995, 11, 23));

        //When
        bookRepository.save(book);

        //Then
        int id = book.getId();
        Optional<Book> readBook = bookRepository.findById(id);
        assertTrue(readBook.isPresent());
    }


    @Test
    void testBookCopyRepositorySave() {
        //Given
        Book book = bookRepository.findByAuthor("Jakis pisarz");
        BookCopy bookCopy = new BookCopy(book.getId(), "Gdzies jest");

        //When
        bookCopyRepository.save(bookCopy);

        //Then
        int id = bookCopy.getId();
        Optional<BookCopy> readBookCopy = bookCopyRepository.findById(id);
        assertTrue(readBookCopy.isPresent());

    }


}
