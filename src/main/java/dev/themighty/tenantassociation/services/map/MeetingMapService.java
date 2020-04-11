package dev.themighty.tenantassociation.services.map;

import dev.themighty.tenantassociation.model.Meeting;
import dev.themighty.tenantassociation.services.CrudService;

import java.util.Set;

public class MeetingMapService extends AbstractMapService<Meeting, Long> implements CrudService<Meeting, Long> {

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
        return super.save(meeting.getId(), meeting);
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
