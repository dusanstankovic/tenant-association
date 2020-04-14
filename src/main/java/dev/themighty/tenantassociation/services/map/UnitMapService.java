package dev.themighty.tenantassociation.services.map;

import dev.themighty.tenantassociation.model.Unit;
import dev.themighty.tenantassociation.services.UnitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class UnitMapService extends AbstractMapService<Unit, Long> implements UnitService {

    @Override
    public Set<Unit> findAll() {
        return super.findAll();
    }

    @Override
    public Unit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Unit save(Unit unit) {
        return super.save(unit);
    }

    @Override
    public void delete(Unit unit) {
        super.delete(unit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
