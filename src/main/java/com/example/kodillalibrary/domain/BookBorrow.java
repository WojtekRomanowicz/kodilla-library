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
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "bookCopyId")
    private Long bookCopyId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "borrowDate")
    private LocalDate borrowDate;

    @Column(name = "returnDate")
    private LocalDate returnDate;
}
