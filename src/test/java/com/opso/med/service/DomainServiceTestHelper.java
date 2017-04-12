package com.opso.med.service;

import com.opso.med.domain.Domain;

import java.util.List;

/**
 * Created by Razvan.Simion on 4/12/2017.
 */
public class DomainServiceTestHelper {


    private static final String DEF_DESCRIPTION = "Default Desc", DEF_NAME = "Default Desc";

    private final DomainService domainService;

    public DomainServiceTestHelper(DomainService domainService) {
        this.domainService = domainService;
    }

    public Domain create() {
        return domainService.save(new Domain().description(DEF_DESCRIPTION).name(DEF_NAME));
    }

    public List<Domain> findAll() {
        return domainService.findAll();
    }
}
