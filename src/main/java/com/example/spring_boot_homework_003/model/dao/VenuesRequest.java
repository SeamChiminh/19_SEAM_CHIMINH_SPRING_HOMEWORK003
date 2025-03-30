package com.example.spring_boot_homework_003.model.dao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenuesRequest {
    @NotBlank(message = "Venue's name can't be null")
    @Size(min = 3, max = 30, message = "Venue's name must be between 3 and 30 characters")
    private String venueName;

    @NotBlank(message = "Location can't be null")
    @Size(min = 3, max = 30, message = "Location must be between 3 and 30 characters")
    private String location;
}
