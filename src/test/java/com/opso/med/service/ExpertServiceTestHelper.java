package com.opso.med.service;

import com.opso.med.domain.Domain;
import com.opso.med.domain.Expert;

import java.util.List;

/**
 * Created by Razvan.Simion on 4/12/2017.
 */
public class ExpertServiceTestHelper {

    private static final String DEF_CODE = "1830293845831", DEF_LAST_NAME = "POPESCU", DEF_FIRST_NAME = "ANA";

    private final ExpertService expertService;

    public ExpertServiceTestHelper(ExpertService expertService) {
        this.expertService = expertService;
    }

    public Expert create() {
        return expertService.save(new Expert().code(DEF_CODE).lastName(DEF_LAST_NAME).firstName(DEF_FIRST_NAME));
    }

    public Expert create(String code, String lastName, String firstName) {
        return expertService.save(new Expert().code(code).lastName(lastName).firstName(firstName));
    }

    public List<Expert> findAll() {
        return expertService.findAll();
    }
}
