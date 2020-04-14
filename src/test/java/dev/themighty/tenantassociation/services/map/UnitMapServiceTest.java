package dev.themighty.tenantassociation.services.map;

import dev.themighty.tenantassociation.model.Tenant;
import dev.themighty.tenantassociation.model.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UnitMapServiceTest {

    UnitMapService unitMapService;
    
    final Set<Tenant> tenants = new HashSet<>();
    final Long unitId = 1L;
    final LocalDateTime createDateTime = LocalDateTime.now();
    final LocalDateTime updateDateTime = LocalDateTime.now();
    final String unitName = "20";
    final String unitDescription = "Smith";

    @BeforeEach
    void setUp() {
        unitMapService = new UnitMapService();

        tenants.add(Tenant.builder().build());
        tenants.add(Tenant.builder().build());

        unitMapService.save(Unit.builder()
                .id(unitId)
                .unitName(unitName)
                .createDateTime(createDateTime)
                .updateDateTime(updateDateTime)
                .description(unitDescription)
                .tenants(tenants)
                .build()
        );
    }

    @Test
    void findAll() {
        Set<Unit> units = unitMapService.findAll();

        assertEquals(1, units.size());
    }

    @Test
    void findById() {
        Unit unit = unitMapService.findById(unitId);

        assertEquals(unitId, unit.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Unit unit = Unit.builder().id(id).build();
        Unit savedUnit = unitMapService.save(unit);

        assertEquals(id, savedUnit.getId());
    }

    @Test
    void saveNoId() {
        Unit savedUnit = unitMapService.save(Unit.builder().build());

        assertNotNull(savedUnit);
    }

    @Test
    void delete() {
        unitMapService.delete(unitMapService.findById(unitId));

        assertEquals(0, unitMapService.findAll().size());
    }

    @Test
    void deleteById() {
        unitMapService.deleteById(unitId);

        assertEquals(0, unitMapService.findAll().size());
    }
}