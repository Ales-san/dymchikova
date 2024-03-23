package com.example.dymchikova.services.contracts;

import com.example.dymchikova.dtos.MovieDTO;
import com.example.dymchikova.entities.Movie;
import com.example.dymchikova.exceptions.InvalidArgumentException;
import com.example.dymchikova.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IMovieService {

    // Create a new movie
    MovieDTO createMovie(MovieDTO movieDTO) throws ResourceNotFoundException, InvalidArgumentException;

    // Get all movies
    List<MovieDTO> getAllMovies();

    // Get movie by ID
    Optional<MovieDTO> getMovieById(Long id) throws ResourceNotFoundException;

    // Update movie
    MovieDTO updateMovie(Long id, MovieDTO movieDetails) throws ResourceNotFoundException;

    // Delete movie
    void deleteMovie(Long id) throws ResourceNotFoundException;
}
