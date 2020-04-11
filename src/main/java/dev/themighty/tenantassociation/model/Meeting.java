package dev.themighty.tenantassociation.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "meetings")
public class Meeting extends BaseEntity {

    @Builder
    public Meeting(Long id, LocalDateTime createDateTime, LocalDateTime updateDateTime, LocalDateTime meetingDateTime,
                   String shortDescription, String agenda, Set<Tenant> attendees) {
        super(id, createDateTime, updateDateTime);
        this.meetingDateTime = meetingDateTime;
        this.shortDescription = shortDescription;
        this.agenda = agenda;
        this.attendees = attendees;
    }

    @Column(name = "meeting_dt")
    private LocalDateTime meetingDateTime;

    @Column(name = "short_description")
    private String shortDescription;

    @Lob
    @Column(name = "agenda")
    private String agenda;

    @ManyToMany
    @JoinTable(name = "meeting_tenant", joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "tenant_id"))
    private Set<Tenant> attendees = new HashSet<>();

}
