package com.example.dymchikova.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    // unique identifier of movie
    @Id
    private Long id;

    // movie name (length 0-100)
    private String title;

    // release year (1900-2100)
    private int year;

    // director's id
    private int director;

    // duration of movie
    private Duration length;

    // rating (0-10)
    private int rating;
}
