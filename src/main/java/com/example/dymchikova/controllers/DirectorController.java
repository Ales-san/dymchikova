package com.example.dymchikova.controllers;

import com.example.dymchikova.controllers.contracts.IDirectorController;
import com.example.dymchikova.dtos.DirectorDTO;
import com.example.dymchikova.exceptions.ResourceNotFoundException;
import com.example.dymchikova.services.contracts.IDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/directors")
public class DirectorController implements IDirectorController {
    @Autowired
    private IDirectorService directorService;

    // Create a new director
    @Override
    @PostMapping
    public DirectorDTO createDirector(@RequestBody DirectorDTO director) {
        return directorService.createDirector(director);
    }

    // Get all directors
    @Override
    @GetMapping
    public List<DirectorDTO> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    // Get director by ID
    @Override
    @GetMapping("/{id}")
    public Optional<DirectorDTO> getDirectorById(@PathVariable Long id) {
        return directorService.getDirectorById(id);
    }

    // Update director by ID
    @Override
    @PatchMapping("/{id}")
    public DirectorDTO updateDirector(@PathVariable Long id, @RequestBody DirectorDTO directorDetails) {
        return directorService.updateDirector(id, directorDetails);
    }

    // Delete director by ID
    @Override
    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable Long id) throws ResourceNotFoundException {
        directorService.deleteDirector(id);
    }


}
