package com.example.spring_boot_homework_003.model.dao;

import com.example.spring_boot_homework_003.model.Venues;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {

    @NotBlank(message = "Event's name can't be null")
    @Size(min = 3, max = 30, message = "Event's name must be between 3 and 30 characters")
    private String eventName;

    @NotBlank(message = "Event date can't be null")
    private LocalDateTime eventDate;

    @NotBlank(message = "Venue's ID can't be null")
    private Integer venueId;

    @NotBlank(message = "Attendee's ID can't be null")
    private List<Integer> attendeesId;
}
