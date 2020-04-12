package dev.themighty.tenantassociation.services.map;

import dev.themighty.tenantassociation.model.Tenant;
import dev.themighty.tenantassociation.services.MeetingService;
import dev.themighty.tenantassociation.services.TenantService;
import dev.themighty.tenantassociation.services.UnitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class TenantMapService extends AbstractMapService<Tenant, Long> implements TenantService {

    private final UnitService unitService;
    private final MeetingService meetingService;

    public TenantMapService(UnitService unitService, MeetingService meetingService) {
        this.unitService = unitService;
        this.meetingService = meetingService;
    }

    @Override
    public Set<Tenant> findAll() {
        return super.findAll();
    }

    @Override
    public Tenant findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Tenant save(Tenant tenant) {
        return super.save(tenant);
    }

    @Override
    public void delete(Tenant tenant) {
        super.delete(tenant);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
