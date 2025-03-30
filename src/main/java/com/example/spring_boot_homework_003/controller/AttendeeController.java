package com.example.spring_boot_homework_003.controller;

import com.example.spring_boot_homework_003.model.Attendee;
import com.example.spring_boot_homework_003.model.dao.AttendeeRequest;
import com.example.spring_boot_homework_003.model.response.ApiResponse;
import com.example.spring_boot_homework_003.service.AttendeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {

    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Attendee>>> getAllAttendees(@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
        ApiResponse<List<Attendee>> apiResponse = ApiResponse.<List<Attendee>>builder()
                .message("All venues have been successfully fetched.")
                .status(HttpStatus.OK)
                .payload(attendeeService.getAllAttendees(offset, limit))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{attend-id}")
    public ResponseEntity<ApiResponse<Attendee>> getAttendeeById(@Positive @PathVariable("attend-id") Integer attendId) {
        ApiResponse<Attendee> apiResponse = ApiResponse.<Attendee>builder()
                .message("The attendee has been successfully founded.")
                .status(HttpStatus.OK)
                .payload(attendeeService.getAttendeeById(attendId))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Attendee>> addAttendee(@Valid @RequestBody AttendeeRequest attendeeRequest) {
        ApiResponse<Attendee> apiResponse = ApiResponse.<Attendee>builder()
                .message("The attendee has been successfully added.")
                .status(HttpStatus.CREATED)
                .payload(attendeeService.addAttendee(attendeeRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<Attendee>> updateAttendeeById(@Positive @PathVariable("attendee-id") Integer attendId, @Valid @RequestBody AttendeeRequest attendeeRequest) {
        ApiResponse<Attendee> apiResponse = ApiResponse.<Attendee>builder()
                .message("The attendee has been successfully updated.")
                .status(HttpStatus.OK)
                .payload(attendeeService.updateAttendeeById(attendId, attendeeRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<Attendee>> deleteAttendeeById(@Positive @PathVariable("attendee-id") Integer attendId) {
        ApiResponse<Attendee> apiResponse = ApiResponse.<Attendee>builder()
                .status(HttpStatus.OK)
                .message("The attendee has been successfully deleted.")
                .payload(attendeeService.deleteAttendeeById(attendId))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    public ResponseEntity<ApiResponse<List<Attendee>>> getAttendeesByEventId(Integer attendId) {
//        ApiResponse<List<Attendee>> apiResponse = ApiResponse.<List<Attendee>>builder()
//                .message("The attendee has been successfully retrieved.")
//                .status(HttpStatus.OK)
//                .payload(attendeeService.getAttendeesByEventId(attendId))
//                .timestamp(LocalDateTime.now())
//                .build();
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }
}
