package com.opso.med.service;

import com.opso.med.domain.Customer;
import com.opso.med.domain.Office;
import com.opso.med.repository.CustomerRepository;
import com.opso.med.repository.OfficeRepository;
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
public class CustomerService {

    private final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Save a Entity.
     *
     * @param customer the Entity to save
     * @return the persisted Entity
     */
    public Customer save(Customer customer) {
        log.debug("Request to save Entity : {}", customer);
        Customer result = customerRepository.save(customer);
        return result;
    }

    /**
     *  Get all the Entities.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    public Page<Customer> findAll(Pageable pageable) {
        log.debug("Request to get all Entities");
        Page<Customer> result = customerRepository.findAll(pageable);
        return result;
    }


    public List<Customer> findAll() {
        log.debug("Request to get all Entities");
        List<Customer> result = customerRepository.findAll();
        return result;
    }

    /**
     *  Get one Entity by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Customer findOne(String id) {
        log.debug("Request to get Entity : {}", id);
        Customer customer = customerRepository.findOne(id);
        return customer;
    }

    /**
     *  Delete the entity by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Entity : {}", id);
        customerRepository.delete(id);
    }
}
