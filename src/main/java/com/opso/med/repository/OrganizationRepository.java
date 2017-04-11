package com.opso.med.repository;

import com.opso.med.domain.Office;
import com.opso.med.domain.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the User entity.
 */
public interface OrganizationRepository extends MongoRepository<Organization, String> {
}
