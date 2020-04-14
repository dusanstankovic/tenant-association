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

        Unit unit1 = Unit.builder()
                .createDateTime(LocalDateTime.now())
                .updateDateTime(LocalDateTime.now())
                .unitName("18")
                .description("Robertson")
                .build();

        unitService.save(unit1);

        Tenant tenant1 = Tenant.builder()
                .createDateTime(LocalDateTime.now())
                .updateDateTime(LocalDateTime.now())
                .firstName("John")
                .lastName("Robertson")
                .unit(unit1)
                .telephone("064-252-8578")
                .email("tenant1@gmail.com")
                .build();

        tenantService.save(tenant1);

        Unit unit2 = Unit.builder()
                .createDateTime(LocalDateTime.now())
                .updateDateTime(LocalDateTime.now())
                .unitName("23")
                .description("Nicholson")
                .build();

        unitService.save(unit2);

        Tenant tenant2 = Tenant.builder()
                .createDateTime(LocalDateTime.now())
                .updateDateTime(LocalDateTime.now())
                .firstName("Robbie")
                .lastName("Nicholson")
                .unit(unit2)
                .telephone("063-180-5555")
                .email("tenant2@gmail.com")
                .build();

        tenantService.save(tenant2);

        Set<Tenant> attendeesMeeting1 = new HashSet<>();
        attendeesMeeting1.add(tenant1);
        attendeesMeeting1.add(tenant2);

        Meeting meeting1 = Meeting.builder()
                .createDateTime(LocalDateTime.now())
                .updateDateTime(LocalDateTime.now())
                .meetingDateTime(LocalDateTime.now())
                .shortDescription("Monthly meeting for January")
                .agenda("Repairs on the roof.")
                .attendees(attendeesMeeting1)
                .build();

        meetingService.save(meeting1);

        Set<Tenant> attendeesMeeting2 = new HashSet<>();
        attendeesMeeting2.add(tenant1);
        attendeesMeeting2.add(tenant2);

        Meeting meeting2 = Meeting.builder()
                .createDateTime(LocalDateTime.now())
                .updateDateTime(LocalDateTime.now())
                .meetingDateTime(LocalDateTime.now())
                .shortDescription("Monthly meeting for February")
                .agenda("Bid for door replacement. Collecting money for March fund.")
                .attendees(attendeesMeeting2)
                .build();

        meetingService.save(meeting2);

        Set<Meeting> meetings = new HashSet<>();
        meetings.add(meeting1);
        meetings.add(meeting2);

        tenant1.setMeetings(meetings);
        tenantService.save(tenant1);

        tenant1.setMeetings(meetings);
        tenantService.save(tenant2);

    }
}
