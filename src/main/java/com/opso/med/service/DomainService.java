package com.opso.med.service;

import com.opso.med.domain.Domain;
import com.opso.med.repository.DomainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for managing Domain.
 */
@Service
public class DomainService {

    private final Logger log = LoggerFactory.getLogger(DomainService.class);
    
    private final DomainRepository domainRepository;

    public DomainService(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    /**
     * Save a domain.
     *
     * @param domain the entity to save
     * @return the persisted entity
     */
    public Domain save(Domain domain) {
        log.debug("Request to save Domain : {}", domain);
        Domain result = domainRepository.save(domain);
        return result;
    }

    /**
     *  Get all the domains.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    public Page<Domain> findAll(Pageable pageable) {
        log.debug("Request to get all Domains");
        Page<Domain> result = domainRepository.findAll(pageable);
        return result;
    }

    /**
     *  Get one domain by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Domain findOne(String id) {
        log.debug("Request to get Domain : {}", id);
        Domain domain = domainRepository.findOne(id);
        return domain;
    }

    /**
     *  Delete the  domain by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Domain : {}", id);
        domainRepository.delete(id);
    }
}
