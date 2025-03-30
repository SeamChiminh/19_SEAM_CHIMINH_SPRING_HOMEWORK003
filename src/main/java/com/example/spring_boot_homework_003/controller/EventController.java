package com.example.spring_boot_homework_003.controller;
import com.example.spring_boot_homework_003.model.Events;
import com.example.spring_boot_homework_003.model.dao.EventRequest;
import com.example.spring_boot_homework_003.model.response.ApiResponse;
import com.example.spring_boot_homework_003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Events>>> getAllEvents(@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
        ApiResponse<List<Events>> apiResponse = ApiResponse.<List<Events>>builder()
                .message("All events have been successfully fetched.")
                .status(HttpStatus.OK)
                .payload(eventService.getAllEvents(offset, limit))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Events>> getEventById(@PathVariable("event-id") Integer eventId){
        ApiResponse<Events> apiResponse = ApiResponse.<Events>builder()
                .message("The event has been successfully founded.")
                .status(HttpStatus.OK)
                .payload(eventService.getEventById(eventId))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Events>> addEvent(@RequestBody EventRequest eventRequest){
        ApiResponse<Events> apiResponse = ApiResponse.<Events>builder()
                .message("The event has been successfully added.")
                .status(HttpStatus.CREATED)
                .payload(eventService.addEvent(eventRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Events>> updateEventById(@PathVariable("event-id") Integer eventId, @RequestBody EventRequest eventRequest){
        ApiResponse<Events> apiResponse = ApiResponse.<Events>builder()
                .message("The event has been successfully updated.")
                .status(HttpStatus.OK)
                .payload(eventService.updateEventById(eventId, eventRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Events>> deleteEventById(@PathVariable("event-id") Integer eventId){
        ApiResponse<Events> apiResponse = ApiResponse.<Events>builder()
                .message("The event has been successfully deleted.")
                .status(HttpStatus.OK)
                .payload(eventService.deleteEventById(eventId))
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
