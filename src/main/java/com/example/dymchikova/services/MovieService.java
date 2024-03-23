package com.example.dymchikova.services;

import com.example.dymchikova.dtos.MovieDTO;
import com.example.dymchikova.entities.Movie;
import com.example.dymchikova.exceptions.InvalidArgumentException;
import com.example.dymchikova.exceptions.ResourceNotFoundException;
import com.example.dymchikova.repositories.IMovieRepository;
import com.example.dymchikova.services.contracts.IDirectorService;
import com.example.dymchikova.services.contracts.IMovieService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService implements IMovieService {
    private IMovieRepository movieRepository;

    private ModelMapper modelMapper;

    private IDirectorService directorService;
    @PostConstruct
    private void init() {
        TypeMap<Movie, MovieDTO> movieToDTOTypeMap = this.modelMapper.createTypeMap(Movie.class, MovieDTO.class);
        Converter<Duration, Integer> durationToMinutes = c -> Math.toIntExact(c.getSource().toMinutes());
        movieToDTOTypeMap.addMappings(
                mapper -> mapper.using(durationToMinutes).map(Movie::getLength, MovieDTO::setLength)
        );

        TypeMap<MovieDTO, Movie> DTOToMovieTypeMap = this.modelMapper.createTypeMap(MovieDTO.class, Movie.class);
        Converter<Integer, Duration> minutesToDuration = c -> Duration.ofMinutes(c.getSource());
        DTOToMovieTypeMap.addMappings(
                mapper -> mapper.using(minutesToDuration).map(MovieDTO::getLength, Movie::setLength)
        );

    }


    // Create a new movie
    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) throws InvalidArgumentException {
        if (directorService.getDirectorById((long) movieDTO.getDirector()).isEmpty()) {
            throw new InvalidArgumentException("Director with id: " + movieDTO.getDirector() + " is not found!");
        }
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        Movie result = movieRepository.save(movie);
        return modelMapper.map(result, MovieDTO.class);
    }

    // Get all movies
    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }

    // Get movie by ID
    @Override
    public Optional<MovieDTO> getMovieById(Long id) throws ResourceNotFoundException {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new ResourceNotFoundException("Movie with id: " + id + " is not found!");
        }
        return Optional.ofNullable(modelMapper.map(movie.get(), MovieDTO.class));
    }

    // Update movie
    @Override
    public MovieDTO updateMovie(Long id, MovieDTO movieDetails) throws ResourceNotFoundException {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new ResourceNotFoundException("Movie with id: " + id + " is not found!");
        }
        Movie existingMovie = movie.get();
        modelMapper.map(movieDetails, existingMovie);
        Movie res = movieRepository.save(existingMovie);
        return modelMapper.map(res, MovieDTO.class);
    }

    // Delete movie
    @Override
    public void deleteMovie(Long id) throws ResourceNotFoundException {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new ResourceNotFoundException("Movie with id: " + id + " is not found!");
        }
        movieRepository.delete(movie.get());
    }

}
