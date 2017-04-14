package com.opso.med.service;

import com.opso.med.OpsomedApp;
import com.opso.med.config.Constants;
import com.opso.med.domain.Domain;
import com.opso.med.domain.Expert;
import com.opso.med.domain.TestConstants;
import com.opso.med.domain.User;
import com.opso.med.repository.UserRepository;
import com.opso.med.service.dto.UserDTO;
import com.opso.med.service.util.RandomUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for the DomainService.
 *
 * @see DomainService
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpsomedApp.class)
public class DomainServiceUnitTest {


    @Autowired
    private DomainService domainService;

    private final Logger log = LoggerFactory.getLogger(DomainServiceUnitTest.class);

    @Mock
    private Domain domain;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        domain = mock(Domain.class);
        when(domain.getName()).thenReturn(TestConstants.DOMAIN_NAME);
        when(domain.getDescription()).thenReturn(TestConstants.DOMAIN_NAME);
    }

    @Test
    public void createSuccessfuly() {
        domainService.save(domain);
        log.info(domain.toString());

        assertThat(domainService.findAll().size()).isEqualTo(2);
    }
}
