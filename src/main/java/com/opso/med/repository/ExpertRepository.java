package com.opso.med.repository;

import com.opso.med.domain.Expert;
import com.opso.med.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data MongoDB repository for the User entity.
 */
public interface ExpertRepository extends MongoRepository<Expert, String> {
}
