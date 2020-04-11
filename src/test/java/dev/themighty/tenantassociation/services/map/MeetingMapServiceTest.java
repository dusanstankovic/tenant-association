package dev.themighty.tenantassociation.services.map;

import dev.themighty.tenantassociation.model.Meeting;
import dev.themighty.tenantassociation.model.Tenant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MeetingMapServiceTest {

    MeetingMapService meetingMapService;
    final Long meetingId = 1L;
    final LocalDateTime createDateTime = LocalDateTime.now();
    final LocalDateTime updateDateTime = LocalDateTime.now();
    final LocalDateTime meetingDateTime = LocalDateTime.now();
    final String shortDescription = "Regular meeting";
    final String agenda = "Bullet points of the agenda";
    final Set<Tenant> attendees = new HashSet<>();


    @BeforeEach
    void setUp() {
        meetingMapService = new MeetingMapService();

        attendees.add(Tenant.builder().build());
        attendees.add(Tenant.builder().build());

        meetingMapService.save(Meeting.builder()
                .id(meetingId)
                .meetingDateTime(meetingDateTime)
                .createDateTime(createDateTime)
                .updateDateTime(updateDateTime)
                .agenda(agenda)
                .shortDescription(shortDescription)
                .attendees(attendees)
                .build()
        );
    }

    @Test
    void findAll() {
        Set<Meeting> meetings = meetingMapService.findAll();

        assertEquals(1, meetings.size());
    }

    @Test
    void findById() {
        Meeting meeting = meetingMapService.findById(meetingId);

        assertEquals(meetingId, meeting.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Meeting meeting = Meeting.builder().id(id).build();
        Meeting savedMeeting = meetingMapService.save(meeting);

        assertEquals(id, savedMeeting.getId());
    }

    @Test
    void saveNoId() {
        Meeting savedMeeting = Meeting.builder().build();

        assertNotNull(savedMeeting);
    }

    @Test
    void delete() {
        meetingMapService.delete(meetingMapService.findById(meetingId));

        assertEquals(0, meetingMapService.findAll().size());
    }

    @Test
    void deleteById() {
        meetingMapService.deleteById(meetingId);

        assertEquals(0, meetingMapService.findAll().size());
    }
}