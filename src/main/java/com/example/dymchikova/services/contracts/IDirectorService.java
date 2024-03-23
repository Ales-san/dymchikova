package com.example.dymchikova.services.contracts;

import com.example.dymchikova.dtos.DirectorDTO;
import com.example.dymchikova.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IDirectorService {
    // Create a new director
    DirectorDTO createDirector(DirectorDTO directorDTO);

    // Get all directors
    List<DirectorDTO> getAllDirectors();

    // Get director by ID
    Optional<DirectorDTO> getDirectorById(Long id);

    // Update director
    DirectorDTO updateDirector(Long id, DirectorDTO directorDetails);

    // Delete director
    void deleteDirector(Long id) throws ResourceNotFoundException;
}
