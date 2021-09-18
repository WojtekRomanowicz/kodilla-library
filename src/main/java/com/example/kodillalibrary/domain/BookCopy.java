package com.example.kodillalibrary.domain;


import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "bookCopy")
public class BookCopy {

    public BookCopy(int bookId, String status){
        this.bookId = bookId;
        this.status = status;
    }
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "bookId")
    private Integer bookId;

    @Column(name = "status")
    private String status;

}
