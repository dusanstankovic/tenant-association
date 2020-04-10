package dev.themighty.tenantassociation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
