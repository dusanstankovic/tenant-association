package dev.themighty.tenantassociation.services.map;

import dev.themighty.tenantassociation.model.Tenant;
import dev.themighty.tenantassociation.model.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TenantMapServiceTest {

    TenantMapService tenantMapService;

    final Long tenantId = 1L;
    final LocalDateTime createDateTime = LocalDateTime.now();
    final LocalDateTime updateDateTime = LocalDateTime.now();
    final String firstName = "John";
    final String lastName = "Smith";
    final String telephone = "065-555-6565";
    final String email = "tenant@gmail.com";

    @BeforeEach
    void setUp() {
        tenantMapService = new TenantMapService();

        tenantMapService.save(Tenant.builder()
                .id(tenantId)
                .createDateTime(createDateTime)
                .updateDateTime(updateDateTime)
                .firstName(firstName)
                .lastName(lastName)
                .telephone(telephone)
                .email(email)
                .unit(Unit.builder().build())
                .build()
        );
    }

    @Test
    void findAll() {
        Set<Tenant> tenants = tenantMapService.findAll();

        assertEquals(1, tenants.size());
    }

    @Test
    void findById() {
        Tenant tenant = tenantMapService.findById(tenantId);

        assertEquals(tenantId, tenant.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Tenant tenant = Tenant.builder().id(id).build();
        Tenant savedTenant = tenantMapService.save(tenant);

        assertEquals(id, savedTenant.getId());
    }

    @Test
    void saveNoId() {
        Tenant savedTenant = tenantMapService.save(Tenant.builder().build());

        assertNotNull(savedTenant);
    }

    @Test
    void delete() {
        tenantMapService.delete(tenantMapService.findById(tenantId));

        assertEquals(0, tenantMapService.findAll().size());
    }

    @Test
    void deleteById() {
        tenantMapService.deleteById(tenantId);

        assertEquals(0, tenantMapService.findAll().size());
    }
}