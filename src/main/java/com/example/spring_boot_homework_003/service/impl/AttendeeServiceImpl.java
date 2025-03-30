package com.example.spring_boot_homework_003.service.impl;

import com.example.spring_boot_homework_003.model.Attendee;
import com.example.spring_boot_homework_003.model.Events;
import com.example.spring_boot_homework_003.model.dao.AttendeeRequest;
import com.example.spring_boot_homework_003.repository.AttendeeRepository;
import com.example.spring_boot_homework_003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {

    private final AttendeeRepository attendeeRepository;

    public AttendeeServiceImpl(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Attendee> getAllAttendees(Integer offset, Integer limit) {
        return attendeeRepository.getAllAttendees(offset, limit);
    }

    @Override
    public Attendee getAttendeeById(Integer attendId) {
        return attendeeRepository.getAttendeeById(attendId);
    }

    @Override
    public Attendee addAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.addAttendee(attendeeRequest);
    }

    @Override
    public Attendee updateAttendeeById(Integer attendId, AttendeeRequest attendeeRequest) {
        return attendeeRepository.updateAttendeeById(attendId, attendeeRequest);
    }

    @Override
    public Attendee deleteAttendeeById(Integer attendId) {
        return attendeeRepository.deleteAttendeeById(attendId);
    }

    @Override
    public List<Attendee> getAttendeesByEventId(Integer attendId) {
        return attendeeRepository.getAttendeesByEventId(attendId);
    }


}
