package com.opso.med.repository;

import com.opso.med.domain.Expert;
import com.opso.med.domain.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the User entity.
 */
public interface JobRepository extends MongoRepository<Job, String> {
}
