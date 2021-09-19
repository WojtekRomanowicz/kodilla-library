package com.example.kodillalibrary.domain.dao;

import com.example.kodillalibrary.domain.Book;
import com.example.kodillalibrary.domain.BookBorrow;
import com.example.kodillalibrary.domain.BookCopy;
import com.example.kodillalibrary.domain.User;
import com.example.kodillalibrary.repository.BookBorrowRepository;
import com.example.kodillalibrary.repository.BookCopyRepository;
import com.example.kodillalibrary.repository.BookRepository;
import com.example.kodillalibrary.repository.UserRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.List;
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
    @Autowired
    private BookBorrowRepository bookBorrowRepository;



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

        //Clean
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

        //Clean
        bookRepository.deleteById(id);
    }


    @Test
    void testBookCopyRepositorySave() {
        //Given
        Book book = new Book("Ania z zielonego pagorka", "Jakis pisarz",
                LocalDate.of(1995, 11, 23));
        bookRepository.save(book);
        int bookId = book.getId();
        BookCopy bookCopy = new BookCopy(book.getId(), "Gdzies jest");

        //When
        bookCopyRepository.save(bookCopy);

        //Then
        int id = bookCopy.getId();
        Optional<BookCopy> readBookCopy = bookCopyRepository.findById(id);
        assertTrue(readBookCopy.isPresent());

        //Clean
        bookCopyRepository.deleteById(id);
        bookRepository.deleteById(bookId);

    }

    @Test
    void testBookBorrowRepositorySave() {
        //Given
        Book book = new Book("Ania z zielonego pagorka", "Jakis pisarz",
                LocalDate.of(1995, 11, 23));
        bookRepository.save(book);
        BookCopy bookCopy = new BookCopy(book.getId(), "Gdzies jest");
        bookCopyRepository.save(bookCopy);
        User user = new User("Wojtek", "Roman", LocalDate.now());
        userRepository.save(user);
        BookBorrow bookBorrow = new BookBorrow(bookCopy.getId(), user.getId());

        //When
        bookBorrowRepository.save(bookBorrow);

        //Then
        int id = bookBorrow.getId();
        Optional<BookBorrow> readBookBorrow = bookBorrowRepository.findById(id);
        assertTrue(readBookBorrow.isPresent());

        //Clean
        bookBorrowRepository.deleteById(id);
        bookCopyRepository.deleteById(bookCopy.getId());
        bookRepository.deleteById(book.getId());
        userRepository.deleteById(user.getId());

    }


}
