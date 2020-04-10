package dev.themighty.tenantassociation.repositories;

import dev.themighty.tenantassociation.model.Tenant;
import org.springframework.data.repository.CrudRepository;

public interface TenantRepository extends CrudRepository<Tenant, Long> {

}
