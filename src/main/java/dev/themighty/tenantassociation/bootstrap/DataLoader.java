package dev.themighty.tenantassociation.bootstrap;

import dev.themighty.tenantassociation.model.Meeting;
import dev.themighty.tenantassociation.model.Tenant;
import dev.themighty.tenantassociation.model.Unit;
import dev.themighty.tenantassociation.services.MeetingService;
import dev.themighty.tenantassociation.services.TenantService;
import dev.themighty.tenantassociation.services.UnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final UnitService unitService;
    private final TenantService tenantService;
    private final MeetingService meetingService;

    public DataLoader(UnitService unitService, TenantService tenantService, MeetingService meetingService) {
        this.unitService = unitService;
        this.tenantService = tenantService;
        this.meetingService = meetingService;
    }

    @Override
    public void run(String... args) throws Exception {

        loadData();
    }

    private void loadData() {

        Unit unit1 = new Unit();
        unit1.setId(1L);
        unit1.setCreateDateTime(LocalDateTime.now());
        unit1.setUpdateDateTime(LocalDateTime.now());
        unit1.setUnitName("18");
        unit1.setDescription("Stankovic");

        unitService.save(unit1);
        System.out.println("Loaded unit 1 ...");

        Tenant tenant1 = new Tenant();
        tenant1.setId(1L);
        tenant1.setCreateDateTime(LocalDateTime.now());
        tenant1.setUpdateDateTime(LocalDateTime.now());
        tenant1.setUnit(unit1);
        tenant1.setTelephone("064-252-8578");
        tenant1.setEmail("tenant1@gmail.com");

        tenantService.save(tenant1);
        System.out.println("Loaded tenant 1 ...");

        Unit unit2 = new Unit();
        unit2.setId(2L);
        unit2.setCreateDateTime(LocalDateTime.now());
        unit2.setUpdateDateTime(LocalDateTime.now());
        unit2.setUnitName("23");
        unit2.setDescription("Krsanin");

        unitService.save(unit2);
        System.out.println("Loaded unit 2 ...");

        Tenant tenant2 = new Tenant();
        tenant2.setId(2L);
        tenant2.setCreateDateTime(LocalDateTime.now());
        tenant2.setUpdateDateTime(LocalDateTime.now());
        tenant2.setUnit(unit2);
        tenant2.setTelephone("063-180-5555");
        tenant2.setEmail("tenant2@gmail.com");

        tenantService.save(tenant2);
        System.out.println("Loaded tenant 2 ...");

        Set<Tenant> attendeesMeeting1 = new HashSet<>();
        attendeesMeeting1.add(tenant1);
        attendeesMeeting1.add(tenant2);

        Meeting meeting1 = new Meeting();
        meeting1.setId(1L);
        meeting1.setCreateDateTime(LocalDateTime.now());
        meeting1.setUpdateDateTime(LocalDateTime.now());
        meeting1.setMeetingDateTime(LocalDateTime.now());
        meeting1.setShortDescription("Monthly meeting for January");
        meeting1.setAgenda("Repairs on the roof.");
        meeting1.setAttendees(attendeesMeeting1);

        meetingService.save(meeting1);
        System.out.println("Loaded meeting 1 ...");

        Set<Tenant> attendeesMeeting2 = new HashSet<>();
        attendeesMeeting2.add(tenant1);
        attendeesMeeting2.add(tenant2);

        Meeting meeting2 = new Meeting();
        meeting2.setId(2L);
        meeting2.setCreateDateTime(LocalDateTime.now());
        meeting2.setUpdateDateTime(LocalDateTime.now());
        meeting2.setMeetingDateTime(LocalDateTime.now());
        meeting2.setShortDescription("Monthly meeting for February");
        meeting2.setAgenda("Bid for door replacement. Collecting money for March fund.");
        meeting2.setAttendees(attendeesMeeting2);

        meetingService.save(meeting2);
        System.out.println("Loaded meeting 2 ...");

        Set<Meeting> meetings = new HashSet<>();
        meetings.add(meeting1);
        meetings.add(meeting2);

        tenant1.setMeetings(meetings);
        tenantService.save(tenant1);

        tenant1.setMeetings(meetings);
        tenantService.save(tenant2);

    }
}
