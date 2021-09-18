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
@Table(name = "user")
public class User {

   public User(String name, String surname, LocalDate date){
        this.name = name;
        this.surname = surname;
        this.joinDate = date;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date")
    private LocalDate joinDate;


}
