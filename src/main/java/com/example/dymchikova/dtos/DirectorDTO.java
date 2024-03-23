package com.example.dymchikova.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDTO {
    // unique identifier of director
    @Id
    @NotBlank(message = "Field 'id' is required")
    private Long id;

    // first, middle and last names of a director
    @NotBlank(message = "Field 'fio' is required")
    private String fio;
}
