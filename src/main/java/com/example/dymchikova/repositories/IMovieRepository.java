package com.example.dymchikova.repositories;

import com.example.dymchikova.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Long> {}
