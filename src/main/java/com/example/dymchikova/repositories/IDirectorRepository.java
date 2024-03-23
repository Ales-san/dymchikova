package com.example.dymchikova.repositories;

import com.example.dymchikova.entities.Director;
import com.example.dymchikova.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDirectorRepository extends JpaRepository<Director, Long> {}
