package com.example.spring_boot_homework_003.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venues {
    private Integer venueId;
    private String venueName;
    private String location;
}
