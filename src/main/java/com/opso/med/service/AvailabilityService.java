package com.opso.med.service;

import com.opso.med.domain.*;
import com.opso.med.repository.AvailabilityRepository;
import com.opso.med.repository.InvestigationRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Service Implementation for managing Domain.
 */
@Service
public class AvailabilityService {

    private final Logger log = LoggerFactory.getLogger(AvailabilityService.class);

    private final AvailabilityRepository availabilityRepository;

    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    /**
     * Save a Entity.
     *
     * @param availability the Entity to save
     * @return the persisted Entity
     */
    public Availability save(Availability availability) {
        log.debug("Request to save Entity : {}", availability);
        Availability result = availabilityRepository.save(availability);
        return result;
    }

    /**
     * Save a initial schedule.
     *
     * @param expert
     * @param office
     * @param interval
     * @return the persisted Entity
     */
    public Availability save(LocalDateTime interval, Office office, Expert expert, boolean available, boolean schedule, boolean appointment) {
        Availability availability = new Availability().startTs(interval).endTs(interval.plusHours(1)).office(new OfficeRef(office)).expert(new ExpertRef(expert)).year(interval.getYear()).appointment(appointment).organization(office.getOrganization()).available(available).schedule(schedule);

        Availability result = availabilityRepository.save(availability);
        return result;
    }

    /**
     * Get all the Entities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    public Page<Availability> findAll(Pageable pageable) {
        log.debug("Request to get all Entities");
        Page<Availability> result = availabilityRepository.findAll(pageable);
        return result;
    }

    public List<Availability> findAll() {
        log.debug("Request to get all Entities");
        List<Availability> result = availabilityRepository.findAll();
        return result;
    }

    /**
     * Get one Entity by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    public Availability findOne(String id) {
        log.debug("Request to get Entity : {}", id);
        Availability availability = availabilityRepository.findOne(id);
        return availability;
    }

    /**
     * Delete the entity by id.
     *
     * @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Entity : {}", id);
        availabilityRepository.delete(id);
    }


    /**
     * Initialize 1 year of disabled avvailabilities. It is run on demand for example when a nwe doctor is created in one office.
     * Will create for each day in the year 16  intervals (06:00 - 22:00) with appointment false, calendar false, available false.
     *
     * @param expert
     * @param office
     * @param year
     * @return void
     */
    public void initYear(Year year, Office office, Expert expert) {
        log.debug("Init year for office and doctor: {}", year.toString() + "office " + office.getName() + "expert " + expert.getCode());
        Year nextYear = year.plusYears(1);
        // For each day in the year
        int noDays = (int) Duration.between(year.atDay(1).atTime(0, 0), nextYear.atDay(1).atTime(0, 0)).toDays();
        Set<Integer> intervals = new HashSet<Integer>(Arrays.asList(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21));

        IntStream.range(1, noDays+1).forEach(
            dayNo -> {
                LocalDate day = LocalDate.ofYearDay(year.getValue(), dayNo);
                intervals.forEach(interval -> {
                    LocalDateTime dayTime = LocalDateTime.of(day, LocalTime.MIN.plusHours(interval.intValue()));
                    save(dayTime, office, expert, false, false, false);
                });
            }
        );

    }

    /**
     * Find all availabilities for office and expert in one year
     *
     * @param expert
     * @param office
     * @param year
     * @return void
     */
    public List<Availability> findAllByOfficeAndExpertAndYear(Year year, Office office, Expert expert) {
        return availabilityRepository.findAllByOfficeAndExpertAndYear(year.getValue(), new ObjectId(office.getId()), new ObjectId(expert.getId()));
    }
}
