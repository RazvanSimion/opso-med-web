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

    /**
     * The expert inserts one new schedule entry for monday working hours 08:00-12:00.
     * In the system, the expert has no prior schedules configured for monday and no appointments.
     */
    @Test
    public void applyOneWeekDaySuccessfully(){

    }

    /**
     * The expert inserts one new schedule entry for monday working hours 08:00-12:00.
     * In the system, the expert already has a Monday schedule for 13:00 to 16:00.
     * The expert has no appointments.
     */
    @Test
    public void applyOneWeekDayOverExistingWeekDaySuccessfully(){

    }


    /**
     * The expert inserts one new schedule entry for monday working hours 08:00-12:00.
     * In the system, the expert already has a Monday schedule for 13:00 to 16:00 and
     * an exception for the next monday (it doesn't work in the next monday - full day).
     * The expert has no appointments.
     */
    @Test
    public void applyOneWeekDayOverExistingWeekDayAndExceptionsSuccessfully(){

    }

    /**
     * The expert inserts one new schedule entry for monday working hours 08:00-12:00.
     * In the system, the expert already has a Monday schedule for 13:00 to 16:00 and
     * an exception for the next monday (it doesn't work in the next monday).
     * The expert has four appointments in one monday.
     *  - One with interval 12:00-13:00
     *  - One with interval 09:00-10:00
     *  - One with interval 14:00-15:00
     *  - One with interval 17:00-18:00.
     */
    @Test
    public void applyOneWeekDayOverExistingWeekDayAndExceptionsAndAppointmentsSuccessfully(){

    }
}
