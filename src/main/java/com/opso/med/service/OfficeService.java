package com.opso.med.service;

import com.opso.med.domain.Job;
import com.opso.med.domain.Office;
import com.opso.med.repository.JobRepository;
import com.opso.med.repository.OfficeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing Domain.
 */
@Service
public class OfficeService {

    private final Logger log = LoggerFactory.getLogger(OfficeService.class);

    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    /**
     * Save a Entity.
     *
     * @param office the Entity to save
     * @return the persisted Entity
     */
    public Office save(Office office) {
        log.debug("Request to save Entity : {}", office);
        Office result = officeRepository.save(office);
        return result;
    }

    /**
     *  Get all the Entities.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    public Page<Office> findAll(Pageable pageable) {
        log.debug("Request to get all Entities");
        Page<Office> result = officeRepository.findAll(pageable);
        return result;
    }

    /**
     *  Get one Entity by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Office findOne(String id) {
        log.debug("Request to get Entity : {}", id);
        Office office = officeRepository.findOne(id);
        return office;
    }

    /**
     *  Delete the entity by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Entity : {}", id);
        officeRepository.delete(id);
    }
}
