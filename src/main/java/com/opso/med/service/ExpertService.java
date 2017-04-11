package com.opso.med.service;

import com.opso.med.domain.Domain;
import com.opso.med.domain.Expert;
import com.opso.med.repository.DomainRepository;
import com.opso.med.repository.ExpertRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing Domain.
 */
@Service
public class ExpertService {

    private final Logger log = LoggerFactory.getLogger(ExpertService.class);

    private final ExpertRepository expertRepository;

    public ExpertService(ExpertRepository expertRepository) {
        this.expertRepository = expertRepository;
    }

    /**
     * Save a Entity.
     *
     * @param expert the Entity to save
     * @return the persisted Entity
     */
    public Expert save(Expert expert) {
        log.debug("Request to save Entity : {}", expert);
        Expert result = expertRepository.save(expert);
        return result;
    }

    /**
     *  Get all the Entities.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    public Page<Expert> findAll(Pageable pageable) {
        log.debug("Request to get all Entities");
        Page<Expert> result = expertRepository.findAll(pageable);
        return result;
    }

    /**
     *  Get one Entity by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Expert findOne(String id) {
        log.debug("Request to get Entity : {}", id);
        Expert expert = expertRepository.findOne(id);
        return expert;
    }

    /**
     *  Delete the entity by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Entity : {}", id);
        expertRepository.delete(id);
    }
}
