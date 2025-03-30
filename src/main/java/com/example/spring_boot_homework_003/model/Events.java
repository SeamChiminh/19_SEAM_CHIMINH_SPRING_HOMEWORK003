package com.example.spring_boot_homework_003.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {
    private Integer eventId;
    private String eventName;
    private LocalDateTime eventDate;
    private Venues venues;
    private List<Attendee> attendees;
}
