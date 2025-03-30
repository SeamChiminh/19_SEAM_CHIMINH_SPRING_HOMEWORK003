package com.example.spring_boot_homework_003.service;

import com.example.spring_boot_homework_003.model.Venues;
import com.example.spring_boot_homework_003.model.dao.VenuesRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VenueService {
    List<Venues> getAllVenues(Integer offset, Integer limit);

    Venues getVenueById(Integer venueId);

    Venues addVenue(VenuesRequest venuesRequest);

    Venues updateVenueById(Integer venueId, VenuesRequest venuesRequest);

    Venues deleteVenueById(Integer venueId);
}
