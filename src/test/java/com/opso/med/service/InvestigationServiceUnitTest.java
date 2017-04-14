package com.opso.med.service;

import com.opso.med.OpsomedApp;
import com.opso.med.domain.*;
import com.opso.med.domain.common.InvestigationStatusEnum;
import com.opso.med.domain.common.InvestigationTypeEnum;
import com.opso.med.web.rest.DomainResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 * Created by Razvan.Simion on 4/12/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpsomedApp.class)
public class InvestigationServiceUnitTest {

    private final Logger log = LoggerFactory.getLogger(InvestigationServiceUnitTest.class);

    @Autowired
    private InvestigationService investigationService;

    @Mock
    private ExpertService expertService;

    @Mock
    private CustomerService customerService;

    @Mock
    private OfficeService officeService;

    @Mock
    private Expert expert;

    @Mock
    private Office office;

    @Mock
    private Customer customer;

    @Mock
    private Organization organization;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(expert.getId()).thenReturn(TestConstants.ID_1);
        when(customer.getId()).thenReturn(TestConstants.ID_2);
        when(office.getId()).thenReturn(TestConstants.ID_3);
        when(organization.getId()).thenReturn(TestConstants.ID_4);
    }


    @Test
    public void createSuccessfuly() {
        Investigation investigation = new Investigation().organization(organization).office(office).customer(new CustomerRef(customer)).expert(new ExpertRef(expert)).startTs(TestConstants.START_TS_NOW).endTs(TestConstants.END_TS_PLUS1).type(InvestigationTypeEnum.ANALYSIS.getCode()).status(InvestigationStatusEnum.FINISHED.getCode());
        investigationService.save(investigation);
        log.info(investigation.toString());
        assertThat(investigationService.findAll().size()).isEqualTo(1);
    }

}
