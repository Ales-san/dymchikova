package com.example.dymchikova.controllers.contracts;

import com.example.dymchikova.dtos.DirectorDTO;
import com.example.dymchikova.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IDirectorController {
    // Create a new director
    @PostMapping
    DirectorDTO createDirector(@RequestBody DirectorDTO director);

    // Get all directors
    @GetMapping
    List<DirectorDTO> getAllDirectors();

    // Get director by ID
    @GetMapping("/{id}")
    Optional<DirectorDTO> getDirectorById(@PathVariable Long id);

    // Update director by ID
    @PatchMapping("/{id}")
    DirectorDTO updateDirector(@PathVariable Long id, @RequestBody DirectorDTO directorDetails);

    // Delete director by ID
    @DeleteMapping("/{id}")
    void deleteDirector(@PathVariable Long id) throws ResourceNotFoundException;
}
