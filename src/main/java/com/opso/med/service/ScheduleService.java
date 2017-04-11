package com.opso.med.service;

import com.opso.med.domain.Organization;
import com.opso.med.domain.Schedule;
import com.opso.med.repository.OrganizationRepository;
import com.opso.med.repository.ScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing Domain.
 */
@Service
public class ScheduleService {

    private final Logger log = LoggerFactory.getLogger(ScheduleService.class);

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    /**
     * Save a Entity.
     *
     * @param schedule the Entity to save
     * @return the persisted Entity
     */
    public Schedule save(Schedule schedule) {
        log.debug("Request to save Entity : {}", schedule);
        Schedule result = scheduleRepository.save(schedule);
        return result;
    }

    /**
     *  Get all the Entities.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    public Page<Schedule> findAll(Pageable pageable) {
        log.debug("Request to get all Entities");
        Page<Schedule> result = scheduleRepository.findAll(pageable);
        return result;
    }

    /**
     *  Get one Entity by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Schedule findOne(String id) {
        log.debug("Request to get Entity : {}", id);
        Schedule schedule = scheduleRepository.findOne(id);
        return schedule;
    }

    /**
     *  Delete the entity by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Entity : {}", id);
        scheduleRepository.delete(id);
    }
}
