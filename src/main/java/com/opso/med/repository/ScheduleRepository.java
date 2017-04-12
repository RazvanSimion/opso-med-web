package com.opso.med.repository;

import com.opso.med.domain.Organization;
import com.opso.med.domain.Schedule;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Spring Data MongoDB repository for the User entity.
 */
public interface ScheduleRepository extends MongoRepository<Schedule, String> {
    @Query("{ 'expert._id' : ?0 }")
    List<Schedule> findByExpertId(ObjectId expertId);

    @Query("{ 'office._id' : ?0 }")
    List<Schedule> findByOfficeId(ObjectId officeId);

    @Query("{ 'office._id' : ?0, 'expert._id' : ?1 }")
    List<Schedule> findByOfficeIdAndExpertId(ObjectId officeId, ObjectId expertId);
}
