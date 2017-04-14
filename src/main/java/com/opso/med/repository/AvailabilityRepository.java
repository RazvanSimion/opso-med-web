package com.opso.med.repository;

import com.opso.med.domain.Appointment;
import com.opso.med.domain.Availability;
import com.opso.med.domain.Expert;
import com.opso.med.domain.Office;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

/**
 * Spring Data MongoDB repository for the Appointment entity.
 */
public interface AvailabilityRepository extends MongoRepository<Availability, String> {

    @Query("{ 'office._id' : ?1, 'expert._id' : ?2, 'year':?0 }")
    List<Availability> findAllByOfficeAndExpertAndYear(int year, ObjectId office, ObjectId expert);
}
