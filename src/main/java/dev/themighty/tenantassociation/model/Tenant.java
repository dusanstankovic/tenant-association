package dev.themighty.tenantassociation.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tenants")
public class Tenant extends NamedEntity {

    @Builder
    public Tenant(Long id, LocalDateTime createDateTime, LocalDateTime updateDateTime, String firstName,
                  String lastName, String telephone, String email, Unit unit) {
        super(id, createDateTime, updateDateTime, firstName, lastName);
        this.telephone = telephone;
        this.email = email;
        this.unit = unit;
    }

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToMany(mappedBy = "attendees")
    private Set<Meeting> meetings;

}
