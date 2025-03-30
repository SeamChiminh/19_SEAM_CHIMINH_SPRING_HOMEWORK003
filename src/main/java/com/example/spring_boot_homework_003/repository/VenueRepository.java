package com.example.spring_boot_homework_003.repository;

import com.example.spring_boot_homework_003.model.Venues;
import com.example.spring_boot_homework_003.model.dao.VenuesRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenueRepository {

    @Select("""
        SELECT * FROM venues
        offset #{offset} * (#{limit} - 1)
        limit #{limit}
    """)
    @Results(id = "venueMapper", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name")
    })
    List<Venues> getAllVenues(Integer offset, Integer limit);

    @Select("""
        SELECT * FROM venues
        WHERE venue_id = #{venueId}
    """)
    @ResultMap("venueMapper")
    Venues getVenueById(Integer venueId);

    @Select("""
        INSERT INTO venues(venue_name, location)
        VALUES (#{request.venueName}, #{request.location})
        RETURNING *
    """)
    @ResultMap("venueMapper")
    Venues addVenue(@Param("request") VenuesRequest venuesRequest);

    @Select("""
        UPDATE venues
        SET venue_name = #{request.venueName}, location = #{request.location}
        WHERE venue_id = #{venueId}
        RETURNING *
    """)
    @ResultMap("venueMapper")
    Venues updateVenueById(Integer venueId, @Param("request") VenuesRequest venuesRequest);

    @Select("""
        DELETE FROM venues
        WHERE venue_id = #{venueId}
        RETURNING *
    """)
    @ResultMap("venueMapper")
    Venues deleteVenueById(Integer venueId);
}
