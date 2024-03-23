package com.example.dymchikova.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO implements Serializable {
    // unique identifier of movie
    @Id
    @GeneratedValue
    private Long id;

    // movie name (length 0-100)
    @Size(min = 0, max = 100, message
            = "Name length must be between 10 and 200 characters")
    private String title;

    // release year (1900-2100)
    @Min(value = 1900, message = "Year should not be less than 1900")
    @Max(value = 2100, message = "Year should not be greater than 2100")
    private int year;

    // director's id
    private int director;

    // duration of movie in minutes
    @Min(value = 0, message = "Age should not be less than 0")
    private int length;

    // rating (0-10)
    @Min(value = 0, message = "Rating should not be less than 0")
    @Max(value = 10, message = "Rating should not be greater than 10")
    private int rating;

}
