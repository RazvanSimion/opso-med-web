package com.opso.med.repository;

import com.opso.med.domain.Appointment;
import com.opso.med.domain.PersistentAuditEvent;
import com.opso.med.domain.Schedule;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Spring Data MongoDB repository for the Appointment entity.
 */
public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    @Query("{ 'expert._id' : ?0 }")
    List<Appointment> findByExpertId(ObjectId expertId);

    @Query("{ 'office._id' : ?0 }")
    List<Appointment> findByOfficeId(ObjectId officeId);

    @Query("{ 'office._id' : ?0, 'expert._id' : ?1 }")
    List<Appointment> findByOfficeIdAndExpertId(ObjectId officeId, ObjectId expertId);

    @Query("{ 'office._id' : ?0, 'expert._id' : ?1 }")
    List<Appointment> findCurrentByOfficeIdAndExpertId(ObjectId officeId, ObjectId expertId);

    List<Appointment> findByStartTsAfter(LocalDateTime after);

    List<Appointment> findByStartTsAfterAndEndTsBefore(LocalDateTime before);

    List<Appointment> findByStartTsBetween(LocalDateTime fromDate, LocalDateTime toDate);

    List<Appointment> findByEndTsBetween(LocalDateTime fromDate, LocalDateTime toDate);

}
