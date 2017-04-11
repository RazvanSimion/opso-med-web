package com.opso.med.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.opso.med.domain.Expert;
import com.opso.med.domain.Expert;
import com.opso.med.service.ExpertService;
import com.opso.med.web.rest.util.HeaderUtil;
import com.opso.med.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Entity.
 */
@RestController
@RequestMapping("/api")
public class ExpertResource {

    private final Logger log = LoggerFactory.getLogger(ExpertResource.class);

    private static final String ENTITY_NAME = "expert";

    private final ExpertService expertService;

    public ExpertResource(ExpertService expertService) {
        this.expertService = expertService;
    }

    /**
     * POST  /experts : Create a new expert.
     *
     * @param expert the expert to create
     * @return the ResponseEntity with status 201 (Created) and with body the new expert, or with status 400 (Bad Request) if the expert has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/experts")
    @Timed
    public ResponseEntity<Expert> createExpert(@RequestBody Expert expert) throws URISyntaxException {
        log.debug("REST request to save Expert : {}", expert);
        if (expert.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new expert cannot already have an ID")).body(null);
        }
        Expert result = expertService.save(expert);
        return ResponseEntity.created(new URI("/api/experts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /experts : Updates an existing expert.
     *
     * @param expert the expert to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated expert,
     * or with status 400 (Bad Request) if the expert is not valid,
     * or with status 500 (Internal Server Error) if the expert couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/experts")
    @Timed
    public ResponseEntity<Expert> updateExpert(@RequestBody Expert expert) throws URISyntaxException {
        log.debug("REST request to update Expert : {}", expert);
        if (expert.getId() == null) {
            return createExpert(expert);
        }
        Expert result = expertService.save(expert);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, expert.getId().toString()))
            .body(result);
    }

    /**
     * GET  /experts : get all the experts.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of experts in body
     */
    @GetMapping("/experts")
    @Timed
    public ResponseEntity<List<Expert>> getAllExperts(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Experts");
        Page<Expert> page = expertService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/experts");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /experts/:id : get the "id" expert.
     *
     * @param id the id of the expert to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the expert, or with status 404 (Not Found)
     */
    @GetMapping("/experts/{id}")
    @Timed
    public ResponseEntity<Expert> getExpert(@PathVariable String id) {
        log.debug("REST request to get Expert : {}", id);
        Expert expert = expertService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(expert));
    }

    /**
     * DELETE  /experts/:id : delete the "id" expert.
     *
     * @param id the id of the expert to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/experts/{id}")
    @Timed
    public ResponseEntity<Void> deleteExpert(@PathVariable String id) {
        log.debug("REST request to delete Expert : {}", id);
        expertService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
