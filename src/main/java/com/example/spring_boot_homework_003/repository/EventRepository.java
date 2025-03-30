package com.example.spring_boot_homework_003.repository;
import com.example.spring_boot_homework_003.model.Events;
import com.example.spring_boot_homework_003.model.dao.EventRequest;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface EventRepository {

    @Select("""
        SELECT * FROM events
        offset #{offset} * (#{limit} - 1)
        limit #{limit}
    """)
    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venues",
                    column = "venue_id",
                    one = @One(select = "com.example.spring_boot_homework_003.repository.VenueRepository.getVenueById")
            ),
            @Result(property = "attendees",
                    column = "event_id",
                    many = @Many(select = "com.example.spring_boot_homework_003.repository.AttendeeRepository.getAttendeeForEvent")
            )
    })
    List<Events> getAllEvents(Integer offset, Integer limit);

    @Select("""
        SELECT * FROM events
        WHERE event_id=#{eventId}
    """)
    @ResultMap("eventMapper")
    Events getEventById(Integer eventId);

    @Select("""
        INSERT INTO events(event_name, event_date, venue_id)
        VALUES (#{request.eventName}, #{request.eventDate}, #{request.venueId}) RETURNING *
    """)
    @ResultMap("eventMapper")
    Events addEvent(@Param("request") EventRequest eventRequest);

    @Select("""
        UPDATE events
        SET event_name = #{request.eventName}, event_date = #{request.eventDate}, venue_id = #{request.venueId}
        WHERE event_id = #{eventId}
        RETURNING *
    """)
    @ResultMap("eventMapper")
    Events updateEventById(Integer eventId, @Param("request") EventRequest eventRequest);

    @Select("""
        DELETE FROM events
        WHERE event_id = #{eventId}
        RETURNING *
    """)
    @ResultMap("eventMapper")
    Events deleteEventById(Integer eventId);
}
