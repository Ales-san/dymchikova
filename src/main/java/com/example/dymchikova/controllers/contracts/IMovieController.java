package com.example.dymchikova.controllers.contracts;

import com.example.dymchikova.dtos.MovieDTO;
import com.example.dymchikova.exceptions.InvalidArgumentException;
import com.example.dymchikova.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IMovieController {
    // Create a new movie
    @PostMapping
    MovieDTO createMovie(@RequestBody MovieDTO movie) throws ResourceNotFoundException, InvalidArgumentException;

    // Get all movies
    @GetMapping
    List<MovieDTO> getAllMovies();

    // Get movie by ID
    @GetMapping("/{id}")
    Optional<MovieDTO> getMovieById(@PathVariable Long id) throws ResourceNotFoundException;

    // Update movie by ID
    @PatchMapping("/{id}")
    MovieDTO updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDetails) throws ResourceNotFoundException;

    // Delete movie by ID
    @DeleteMapping("/{id}")
    void deleteMovie(@PathVariable Long id) throws ResourceNotFoundException;
}
