package com.opso.med.service;

import com.opso.med.domain.Customer;
import com.opso.med.domain.Organization;
import com.opso.med.repository.CustomerRepository;
import com.opso.med.repository.OrganizationRepository;
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
public class OrganizationService {

    private final Logger log = LoggerFactory.getLogger(OrganizationService.class);

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    /**
     * Save a Entity.
     *
     * @param organization the Entity to save
     * @return the persisted Entity
     */
    public Organization save(Organization organization) {
        log.debug("Request to save Entity : {}", organization);
        Organization result = organizationRepository.save(organization);
        return result;
    }

    /**
     *  Get all the Entities.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    public Page< Organization> findAll(Pageable pageable) {
        log.debug("Request to get all Entities");
        Page< Organization> result = organizationRepository.findAll(pageable);
        return result;
    }


    public List< Organization> findAll() {
        log.debug("Request to get all Entities");
        List< Organization> result = organizationRepository.findAll();
        return result;
    }

    /**
     *  Get one Entity by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public  Organization findOne(String id) {
        log.debug("Request to get Entity : {}", id);
        Organization organization = organizationRepository.findOne(id);
        return organization;
    }

    /**
     *  Delete the entity by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Entity : {}", id);
        organizationRepository.delete(id);
    }
}
