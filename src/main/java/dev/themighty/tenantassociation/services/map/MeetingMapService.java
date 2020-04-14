package dev.themighty.tenantassociation.services.map;

import dev.themighty.tenantassociation.model.Meeting;
import dev.themighty.tenantassociation.services.MeetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class MeetingMapService extends AbstractMapService<Meeting, Long> implements MeetingService {

    @Override
    public Set<Meeting> findAll() {
        return super.findAll();
    }

    @Override
    public Meeting findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Meeting save(Meeting meeting) {
        return super.save(meeting);
    }

    @Override
    public void delete(Meeting meeting) {
        super.delete(meeting);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
