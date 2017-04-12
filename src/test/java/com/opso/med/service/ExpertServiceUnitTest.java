package com.opso.med.service;

import com.opso.med.OpsomedApp;
import com.opso.med.domain.Domain;
import com.opso.med.domain.Expert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for the DomainService.
 *
 * @see ExpertService
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpsomedApp.class)
public class ExpertServiceUnitTest {



    @Autowired
    private ExpertService expertService;

    private final Logger log = LoggerFactory.getLogger(ExpertServiceUnitTest.class);

    private ExpertServiceTestHelper expertServiceTestHelper;

    @Before
    public void setup() {
        this.expertServiceTestHelper = new ExpertServiceTestHelper(expertService);
    }

    @Test
    public void createSuccessfuly() {
        Expert expert = expertServiceTestHelper.create();
        log.info(expert.toString());
        assertThat(expert).isNotNull();
    }

    @Test
    public void findAllSuccessfuly() {
        expertServiceTestHelper.create();
        assertThat(expertServiceTestHelper.findAll().size()).isEqualTo(1);
    }
}
