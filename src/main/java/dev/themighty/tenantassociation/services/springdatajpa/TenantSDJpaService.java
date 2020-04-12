package dev.themighty.tenantassociation.services.springdatajpa;

import dev.themighty.tenantassociation.model.Tenant;
import dev.themighty.tenantassociation.repositories.MeetingRepository;
import dev.themighty.tenantassociation.repositories.TenantRepository;
import dev.themighty.tenantassociation.repositories.UnitRepository;
import dev.themighty.tenantassociation.services.TenantService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class TenantSDJpaService implements TenantService {

    private final TenantRepository tenantRepository;
    private final MeetingRepository meetingRepository;
    private final UnitRepository unitRepository;

    public TenantSDJpaService(TenantRepository tenantRepository, MeetingRepository meetingRepository, UnitRepository unitRepository) {
        this.tenantRepository = tenantRepository;
        this.meetingRepository = meetingRepository;
        this.unitRepository = unitRepository;
    }

    @Override
    public Set<Tenant> findAll() {
        Set<Tenant> tenants = new HashSet<>();

        tenantRepository.findAll().forEach(tenants::add);

        return tenants;
    }

    @Override
    public Tenant findById(Long id) {
        return tenantRepository.findById(id).orElse(null);
    }

    @Override
    public Tenant save(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    @Override
    public void delete(Tenant tenant) {
        tenantRepository.delete(tenant);
    }

    @Override
    public void deleteById(Long id) {
        tenantRepository.deleteById(id);
    }
}
