package com.example.spring_boot_homework_003.service;
import com.example.spring_boot_homework_003.model.Events;
import com.example.spring_boot_homework_003.model.dao.EventRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    List<Events> getAllEvents(Integer offset, Integer limit);

    Events getEventById(Integer eventId);

    Events addEvent(EventRequest eventRequest);

    Events updateEventById(Integer eventId, EventRequest eventRequest);

    Events deleteEventById(Integer eventId);
}
