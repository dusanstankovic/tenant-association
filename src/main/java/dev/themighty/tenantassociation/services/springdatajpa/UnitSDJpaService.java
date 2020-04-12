package dev.themighty.tenantassociation.services.springdatajpa;

import dev.themighty.tenantassociation.model.Unit;
import dev.themighty.tenantassociation.repositories.MeetingRepository;
import dev.themighty.tenantassociation.repositories.TenantRepository;
import dev.themighty.tenantassociation.repositories.UnitRepository;
import dev.themighty.tenantassociation.services.UnitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class UnitSDJpaService implements UnitService {

    private final UnitRepository unitRepository;
    private final TenantRepository tenantRepository;
    private final MeetingRepository meetingRepository;

    public UnitSDJpaService(UnitRepository unitRepository, TenantRepository tenantRepository,
                            MeetingRepository meetingRepository) {
        this.unitRepository = unitRepository;
        this.tenantRepository = tenantRepository;
        this.meetingRepository = meetingRepository;
    }

    @Override
    public Set<Unit> findAll() {
        Set<Unit> units = new HashSet<>();

        unitRepository.findAll().forEach(units::add);

        return units;
    }

    @Override
    public Unit findById(Long id) {

        return unitRepository.findById(id).orElse(null);
    }

    @Override
    public Unit save(Unit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public void delete(Unit unit) {
        unitRepository.delete(unit);
    }

    @Override
    public void deleteById(Long id) {
        unitRepository.deleteById(id);
    }
}
