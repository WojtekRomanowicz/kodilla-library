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
@Table(name = "book")
public class Book {

    public Book(String title, String author, LocalDate date){
        this.title = title;
        this.author = author;
        this.publicationDate = date;
    }
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private LocalDate publicationDate;

}
