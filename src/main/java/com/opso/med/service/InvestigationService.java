package com.opso.med.service;

import com.opso.med.domain.Investigation;
import com.opso.med.domain.Schedule;
import com.opso.med.repository.InvestigationRepository;
import com.opso.med.repository.ScheduleRepository;
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
public class InvestigationService {

    private final Logger log = LoggerFactory.getLogger(InvestigationService.class);

    private final InvestigationRepository investigationRepository;

    public InvestigationService(InvestigationRepository investigationRepository) {
        this.investigationRepository = investigationRepository;
    }

    /**
     * Save a Entity.
     *
     * @param investigation the Entity to save
     * @return the persisted Entity
     */
    public Investigation save(Investigation investigation) {
        log.debug("Request to save Entity : {}", investigation);
        Investigation result = investigationRepository.save(investigation);
        return result;
    }

    /**
     *  Get all the Entities.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    public Page<Investigation> findAll(Pageable pageable) {
        log.debug("Request to get all Entities");
        Page<Investigation> result = investigationRepository.findAll(pageable);
        return result;
    }

    public List<Investigation> findAll() {
        log.debug("Request to get all Entities");
        List<Investigation> result = investigationRepository.findAll();
        return result;
    }

    /**
     *  Get one Entity by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Investigation findOne(String id) {
        log.debug("Request to get Entity : {}", id);
        Investigation investigation = investigationRepository.findOne(id);
        return investigation;
    }

    /**
     *  Delete the entity by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Entity : {}", id);
        investigationRepository.delete(id);
    }
}
