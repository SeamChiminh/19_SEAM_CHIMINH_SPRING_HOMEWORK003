package com.example.spring_boot_homework_003.model.dao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeRequest {

    @NotBlank(message = "Attendee's name can't be null")
    @Size(min = 3, max = 20, message = "Attendee's name must be between 3 and 20 characters")
    private String attendeeName;

    @NotBlank(message = "Attendee's email can't be null")
    @Email(message = "Invalid email format")
    private String email;
}
