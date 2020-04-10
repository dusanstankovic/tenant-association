package dev.themighty.tenantassociation.repositories;

import dev.themighty.tenantassociation.model.Meeting;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {

}
