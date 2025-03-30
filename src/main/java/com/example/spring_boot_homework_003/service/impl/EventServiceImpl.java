package com.example.spring_boot_homework_003.service.impl;

import com.example.spring_boot_homework_003.exception.NotFoundException;
import com.example.spring_boot_homework_003.model.Events;
import com.example.spring_boot_homework_003.model.dao.EventRequest;
import com.example.spring_boot_homework_003.repository.AttendeeRepository;
import com.example.spring_boot_homework_003.repository.EventRepository;
import com.example.spring_boot_homework_003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final AttendeeRepository attendeeRepository;
    private final EventRepository eventRepository;

    public EventServiceImpl(AttendeeRepository attendeeRepository, EventRepository eventRepository) {
        this.attendeeRepository = attendeeRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Events> getAllEvents(Integer offset, Integer limit) {
        return eventRepository.getAllEvents(offset, limit);
    }

    @Override
    public Events getEventById(Integer eventId) {
        Events event = eventRepository.getEventById(eventId);
        if (event == null) {
            throw new NotFoundException("Event ID " + eventId + " not found.");
        }
        return event;
    }

    @Override
    public Events addEvent(EventRequest eventRequest) {
        Events events = eventRepository.addEvent(eventRequest);
        for(Integer attendeeId : eventRequest.getAttendeesId()){
            attendeeRepository.insertAttendeeIdAndEventIdToEventAttendeeTable(events.getEventId(), attendeeId);
        }
        return events;
    }

    @Override
    public Events updateEventById(Integer eventId, EventRequest eventRequest) {
        Events events = eventRepository.updateEventById(eventId, eventRequest);
        attendeeRepository.deleteEventAttendeeById(events.getEventId());
        for(Integer attendeeId : eventRequest.getAttendeesId()){
            attendeeRepository.insertAttendeeIdAndEventIdToEventAttendeeTable(events.getEventId(), attendeeId);
        }
        return eventRepository.updateEventById(events.getEventId(), eventRequest);
    }

    @Override
    public Events deleteEventById(Integer eventId) {
        Events events = eventRepository.deleteEventById(eventId);
        if(events == null){
            throw new NotFoundException("Event ID " + eventId + " not found.");
        }
        return events;
    }

}
