package com.example.spring_boot_homework_003.controller;

import com.example.spring_boot_homework_003.model.Venues;
import com.example.spring_boot_homework_003.model.dao.VenuesRequest;
import com.example.spring_boot_homework_003.model.response.ApiResponse;
import com.example.spring_boot_homework_003.service.VenueService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenuesController {

    private final VenueService venueService;

    public VenuesController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Venues>>> getAllVenues(@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
        ApiResponse<List<Venues>> apiResponse = ApiResponse.<List<Venues>>builder()
                .message("All events have been successfully fetched.")
                .status(HttpStatus.OK)
                .payload(venueService.getAllVenues(offset, limit))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Venues>> getVenueById(@Positive @PathVariable("venue-id") Integer venueId) {
        ApiResponse<Venues> apiResponse = ApiResponse.<Venues>builder()
                .message("The venue has been successfully founded.")
                .status(HttpStatus.OK)
                .payload(venueService.getVenueById(venueId))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Venues>> addVenue(@Valid @RequestBody VenuesRequest venuesRequest) {
        ApiResponse<Venues> apiResponse = ApiResponse.<Venues>builder()
                .message("The venue has been successfully added.")
                .status(HttpStatus.CREATED)
                .payload(venueService.addVenue(venuesRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Venues>> updateVenueById(@Positive @PathVariable("venue-id") Integer venueId, @Valid @RequestBody VenuesRequest venuesRequest) {
        ApiResponse<Venues> apiResponse = ApiResponse.<Venues>builder()
                .message("The venue has been successfully updated.")
                .status(HttpStatus.OK)
                .payload(venueService.updateVenueById(venueId, venuesRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Venues>> deleteVenueById(@Positive @PathVariable("venue-id") Integer venueId) {
        ApiResponse<Venues> apiResponse = ApiResponse.<Venues>builder()
                .message("The venue has been successfully deleted.")
                .status(HttpStatus.OK)
                .payload(venueService.deleteVenueById(venueId))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
