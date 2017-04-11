package com.opso.med.repository;

import com.opso.med.domain.Organization;
import com.opso.med.domain.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the User entity.
 */
public interface ScheduleRepository extends MongoRepository<Schedule, String> {
}
