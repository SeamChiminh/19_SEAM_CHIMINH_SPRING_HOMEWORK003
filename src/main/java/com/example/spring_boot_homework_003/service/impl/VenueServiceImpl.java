package com.example.spring_boot_homework_003.service.impl;

import com.example.spring_boot_homework_003.model.Venues;
import com.example.spring_boot_homework_003.model.dao.VenuesRequest;
import com.example.spring_boot_homework_003.repository.VenueRepository;
import com.example.spring_boot_homework_003.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venues> getAllVenues(Integer offset, Integer limit) {
        return venueRepository.getAllVenues(offset, limit);
    }

    @Override
    public Venues getVenueById(Integer venueId) {
        return venueRepository.getVenueById(venueId);
    }

    @Override
    public Venues addVenue(VenuesRequest venuesRequest) {
        return venueRepository.addVenue(venuesRequest);
    }

    @Override
    public Venues updateVenueById(Integer venueId, VenuesRequest venuesRequest) {
        return venueRepository.updateVenueById(venueId, venuesRequest);
    }

    @Override
    public Venues deleteVenueById(Integer venueId) {
        return venueRepository.deleteVenueById(venueId);
    }
}
