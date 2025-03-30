package com.example.spring_boot_homework_003.model.dao;

import com.example.spring_boot_homework_003.model.Venues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String eventName;
    private LocalDateTime eventDate;
    private Integer venueId;
    private List<Integer> attendeesId;
}
