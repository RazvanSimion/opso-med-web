package com.opso.med.service;

import com.opso.med.OpsomedApp;
import com.opso.med.domain.*;
import com.opso.med.domain.common.InvestigationStatusEnum;
import com.opso.med.domain.common.InvestigationTypeEnum;
import com.opso.med.domain.common.ScheduleTypeEnum;
import com.opso.med.repository.AppointmentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Razvan.Simion on 4/12/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpsomedApp.class)
public class AvailabilityServiceIntTest {

    private final Logger log = LoggerFactory.getLogger(AvailabilityServiceIntTest.class);


    @Autowired
    private OfficeService officeService;

    @Autowired
    private ExpertService expertService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private JobService jobService;

    private Job job;

    private Expert expert;

    private Office office;

    private Customer customer;

    private Organization organization;


    private Schedule monday;
    private Schedule sunday;
    private Schedule closedDay;
    private Schedule openedDay;
    private Schedule openedInterval;
    private Schedule closedInterval;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        //SAVE ORGANIZATION
        organization = new Organization().name(TestConstants.ORG_NAME);
        log.info(organization.toString());
        organization = organizationService.save(organization);

        // SAVE OFFICES
        office = new Office().name(TestConstants.OFFICE_NAME).position(TestConstants.OFFICE_POSITION).organization(organization);
        office = officeService.save(office);

        //SAVE JOB
        job = new Job().office(office);
        job.setOffice(office);
        job = jobService.save(job);

        //SAVE EXPERT
        expert = new Expert().lastName(TestConstants.EXPERT_LAST_NAME).firstName(TestConstants.EXPERT_FIRST_NAME).code(TestConstants.EXPERT_CODE);
        expert.setJobs(new HashSet<>(Arrays.asList(job)));
        expert = expertService.save(expert);

        //MONDAY
        monday = new Schedule().dayOfWeek(DayOfWeek.MONDAY.getValue()).startHour(LocalTime.MIN.plusHours(8)).endHour(LocalTime.MIN.plusHours(16)).type(ScheduleTypeEnum.DAY_OF_WEEK.getCode()).expert(new ExpertRef(expert)).office(new OfficeRef(office));
        scheduleService.save(monday);


    }

    @Test
    public void initDataSuccessfuly() {
        assertThat(organizationService.findAll().size()).isGreaterThan(0);
        assertThat(officeService.findAll().size()).isGreaterThan(0);
        assertThat(expertService.findAll().size()).isGreaterThan(0);
    }

    @Test
    public void sundayIsClosed() {
        // There is not entry in availability for mondays in the current week.
    }

    @Test
    public void mondayFrom8To19IsOpenened() {
        // For all mondays from current week we will find all intervals from 08-19

        // For all mondays from current week we will not find intervals outside the  interval 08-19

    }

    @Test
    public void initYearSuccessfully() {
        Year currentYear = Year.now();

        availabilityService.initYear(currentYear, office, expert);

        List<Availability> availabilityList = availabilityService.findAllByOfficeAndExpertAndYear(currentYear, office, expert);
        Year nextYear = currentYear.plusYears(1);
        availabilityList.forEach(availability -> {
            log.debug(availability.toString());
        });
        int noDays = (int) Duration.between(currentYear.atDay(1).atTime(0, 0), nextYear.atDay(1).atTime(0, 0)).toDays();

        log.info("CURRENT YEAR:" + currentYear.toString() + " NEXT YEAR:" + nextYear.toString() + " NO DAYS:" + noDays);
        assertThat(availabilityList.size()).isEqualTo(noDays * 16);
    }

}
