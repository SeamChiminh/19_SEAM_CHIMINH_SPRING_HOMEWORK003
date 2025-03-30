package com.example.spring_boot_homework_003.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenuesRequest {
    private String venueName;
    private String location;
}
