package dev.themighty.tenantassociation.services.map;

import dev.themighty.tenantassociation.model.Tenant;
import dev.themighty.tenantassociation.services.TenantService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TenantMapService extends AbstractMapService<Tenant, Long> implements TenantService {

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
        return super.save(tenant.getId(), tenant);
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
