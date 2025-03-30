package com.example.spring_boot_homework_003.service;

import com.example.spring_boot_homework_003.model.Attendee;
import com.example.spring_boot_homework_003.model.Events;
import com.example.spring_boot_homework_003.model.dao.AttendeeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendeeService {

    List<Attendee> getAllAttendees(Integer offset, Integer limit);

    Attendee getAttendeeById(Integer attendId);

    Attendee addAttendee(AttendeeRequest attendeeRequest);

    Attendee updateAttendeeById(Integer attendId, AttendeeRequest attendeeRequest);

    Attendee deleteAttendeeById(Integer attendId);

    List<Attendee> getAttendeesByEventId(Integer attendId);
}
