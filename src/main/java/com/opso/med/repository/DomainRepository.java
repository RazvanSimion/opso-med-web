package com.opso.med.repository;

import com.opso.med.domain.Domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the Domain entity.
 */
@SuppressWarnings("unused")
public interface DomainRepository extends MongoRepository<Domain,String> {

}
