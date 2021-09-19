package com.example.kodillalibrary.domain;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "bookborrow")
public class BookBorrow {

    public BookBorrow(Integer bookCopyId, Integer userId){
        this.bookCopyId = bookCopyId;
        this.userId = userId;
        this.borrowDate = LocalDate.now();
        this.returnDate = LocalDate.now().plusMonths(1);
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "bookCopyId")
    private Integer bookCopyId;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "borrowDate")
    private LocalDate borrowDate;

    @Column(name = "returnDate")
    private LocalDate returnDate;
}
