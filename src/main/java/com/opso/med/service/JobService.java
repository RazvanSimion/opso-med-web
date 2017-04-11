package com.opso.med.service;

import com.opso.med.domain.Expert;
import com.opso.med.domain.Job;
import com.opso.med.repository.ExpertRepository;
import com.opso.med.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing Domain.
 */
@Service
public class JobService {

    private final Logger log = LoggerFactory.getLogger(JobService.class);

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    /**
     * Save a Entity.
     *
     * @param job the Entity to save
     * @return the persisted Entity
     */
    public Job save(Job job) {
        log.debug("Request to save Entity : {}", job);
        Job result = jobRepository.save(job);
        return result;
    }

    /**
     *  Get all the Entities.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    public Page<Job> findAll(Pageable pageable) {
        log.debug("Request to get all Entities");
        Page<Job> result = jobRepository.findAll(pageable);
        return result;
    }

    /**
     *  Get one Entity by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Job findOne(String id) {
        log.debug("Request to get Entity : {}", id);
        Job job = jobRepository.findOne(id);
        return job;
    }

    /**
     *  Delete the entity by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Entity : {}", id);
        jobRepository.delete(id);
    }
}
