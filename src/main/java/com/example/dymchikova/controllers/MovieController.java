package com.example.dymchikova.controllers;

import com.example.dymchikova.controllers.contracts.IMovieController;
import com.example.dymchikova.dtos.MovieDTO;
import com.example.dymchikova.exceptions.InvalidArgumentException;
import com.example.dymchikova.exceptions.ResourceNotFoundException;
import com.example.dymchikova.services.contracts.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController implements IMovieController {
    @Autowired
    private IMovieService movieService;

    // Create a new movie
    @Override
    @PostMapping
    public MovieDTO createMovie(@RequestBody MovieDTO movie) throws ResourceNotFoundException, InvalidArgumentException {
        return movieService.createMovie(movie);
    }

    // Get all movies
    @Override
    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Get movie by ID
    @Override
    @GetMapping("/{id}")
    public Optional<MovieDTO> getMovieById(@PathVariable Long id) throws ResourceNotFoundException {
        return movieService.getMovieById(id);
    }

    // Update movie by ID
    @Override
    @PatchMapping("/{id}")
    public MovieDTO updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDetails) throws ResourceNotFoundException {
        return movieService.updateMovie(id, movieDetails);
    }

    // Delete movie by ID
    @Override
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) throws ResourceNotFoundException {
        movieService.deleteMovie(id);
    }
}
