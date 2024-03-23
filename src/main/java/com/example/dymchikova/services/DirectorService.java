package com.example.dymchikova.services;

import com.example.dymchikova.dtos.DirectorDTO;
import com.example.dymchikova.entities.Director;
import com.example.dymchikova.entities.Movie;
import com.example.dymchikova.exceptions.ResourceNotFoundException;
import com.example.dymchikova.repositories.IDirectorRepository;
import com.example.dymchikova.services.contracts.IDirectorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DirectorService implements IDirectorService {
//    @Autowired
    private IDirectorRepository directorRepository;

//    @Autowired
    private ModelMapper modelMapper;


    // Create a new director
    @Override
    public DirectorDTO createDirector(DirectorDTO directorDTO) {
        Director director = modelMapper.map(directorDTO, Director.class);
        Director result = directorRepository.save(director);
        return modelMapper.map(result, DirectorDTO.class);
    }

    // Get all directors
    @Override
    public List<DirectorDTO> getAllDirectors() {
        return directorRepository.findAll().stream()
                        .map(director -> modelMapper.map(director, DirectorDTO.class))
                        .collect(Collectors.toList());
    }

    // Get director by ID
    @Override
    public Optional<DirectorDTO> getDirectorById(Long id) {
        Optional<Director> director = directorRepository.findById(id);
        return director.map(value -> modelMapper.map(value, DirectorDTO.class));
    }

    // Update director
    @Override
    public DirectorDTO updateDirector(Long id, DirectorDTO directorDetails) {
        Optional<Director> director = directorRepository.findById(id);
        if (director.isPresent()) {
            Director existingDirector = director.get();
            modelMapper.map(directorDetails, existingDirector);
            Director res = directorRepository.save(existingDirector);
            return modelMapper.map(res, DirectorDTO.class);
        }
        return null;
    }

    // Delete director
    @Override
    public void deleteDirector(Long id) throws ResourceNotFoundException {
        Optional<Director> director = directorRepository.findById(id);
        if (director.isEmpty()) {
            throw new ResourceNotFoundException("Director with id: " + id + " is not found!");
        }
        directorRepository.delete(director.get());
    }

}
