package com.example.spring_boot_homework_003.repository;

import com.example.spring_boot_homework_003.model.Attendee;
import com.example.spring_boot_homework_003.model.Events;
import com.example.spring_boot_homework_003.model.dao.AttendeeRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeeRepository {

    @Select("""
                SELECT * FROM attendees
                offset #{offset} * (#{limit} - 1)
                limit #{limit}
            """)
    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name"),
            @Result(property = "email", column = "email")
    })
    List<Attendee> getAllAttendees(Integer offset, Integer limit);

    @Select("""
                SELECT * FROM attendees
                WHERE attendee_id = #{attendeeId}
            """)
    @ResultMap("attendeeMapper")
    Attendee getAttendeeById(Integer attendId);

    @Select("""
                SELECT a.* FROM attendees a
                JOIN event_attendee ea ON a.attendee_id = ea.attendee_id
                WHERE ea.event_id = #{eventId}
            """)
    @ResultMap("attendeeMapper")
    List<Attendee> getAttendeesByEventId(Integer eventId);

    @Select("""
                INSERT INTO attendees(attendee_name, email)
                VALUES (#{request.attendeeName}, #{request.email})
                RETURNING *
            """)
    @ResultMap("attendeeMapper")
    Attendee addAttendee(@Param("request") AttendeeRequest attendeeRequest);

    @Select("""
                UPDATE Attendees
                SET attendee_name = #{request.attendeeName}, email = #{request.email}
                WHERE attendee_id = #{attendeeId}
                RETURNING *
            """)
    @ResultMap("attendeeMapper")
    Attendee updateAttendeeById(Integer attendeeId, @Param("request") AttendeeRequest attendeeRequest);

    @Select("""
                DELETE FROM attendees
                where attendee_id = #{attendeeId}
                RETURNING *
            """)
    @ResultMap("attendeeMapper")
    Attendee deleteAttendeeById(Integer attendeeId);

    @Select("""
            SELECT a.attendee_id, attendee_name ,email, ea.attendee_id FROM attendees a JOIN event_attendee ea ON a.attendee_id = ea.attendee_id WHERE event_id = #{eventId}
            """)
    @ResultMap("attendeeMapper")
    List<Events> getAttendeeForEvent(Integer eventId);

    @Insert("""
            INSERT INTO event_attendee (event_id, attendee_id) VALUES (#{eventId}, #{attendeeId})
            """)
    @ResultMap("attendeeMapper")
    void insertAttendeeIdAndEventIdToEventAttendeeTable(Integer eventId, Integer attendeeId);

    @Delete("""
        DELETE FROM event_attendee WHERE event_id = #{eventId}
    """)
    void deleteEventAttendeeById(Integer eventId);

}
