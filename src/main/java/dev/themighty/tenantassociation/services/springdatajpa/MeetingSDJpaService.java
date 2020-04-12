package dev.themighty.tenantassociation.services.springdatajpa;

import dev.themighty.tenantassociation.model.Meeting;
import dev.themighty.tenantassociation.repositories.MeetingRepository;
import dev.themighty.tenantassociation.repositories.TenantRepository;
import dev.themighty.tenantassociation.repositories.UnitRepository;
import dev.themighty.tenantassociation.services.MeetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class MeetingSDJpaService implements MeetingService {

    private final MeetingRepository meetingRepository;
    private final TenantRepository tenantRepository;
    private final UnitRepository unitRepository;

    public MeetingSDJpaService(MeetingRepository meetingRepository, TenantRepository tenantRepository, UnitRepository unitRepository) {
        this.meetingRepository = meetingRepository;
        this.tenantRepository = tenantRepository;
        this.unitRepository = unitRepository;
    }

    @Override
    public Set<Meeting> findAll() {
        Set<Meeting> meetings = new HashSet<>();

        meetingRepository.findAll().forEach(meetings::add);

        return meetings;
    }

    @Override
    public Meeting findById(Long id) {
        return meetingRepository.findById(id).orElse(null);
    }

    @Override
    public Meeting save(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public void delete(Meeting meeting) {
        meetingRepository.delete(meeting);
    }

    @Override
    public void deleteById(Long id) {
        meetingRepository.deleteById(id);
    }
}
