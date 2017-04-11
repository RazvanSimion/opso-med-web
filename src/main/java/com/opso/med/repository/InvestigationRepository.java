package com.opso.med.repository;

import com.opso.med.domain.Customer;
import com.opso.med.domain.Investigation;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the User entity.
 */
public interface InvestigationRepository extends MongoRepository<Investigation, String> {
}
