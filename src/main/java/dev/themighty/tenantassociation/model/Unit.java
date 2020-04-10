package dev.themighty.tenantassociation.model;

import lombok.Builder;
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
@Entity
@Table(name = "units")
public class Unit extends BaseEntity {

    @Builder
    public Unit(Long id, LocalDateTime createDateTime, LocalDateTime updateDateTime, String unitName,
                String description, Set<Tenant> tenants) {
        super(id, createDateTime, updateDateTime);
        this.unitName = unitName;
        this.description = description;
        this.tenants = tenants;
    }

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unit")
    private Set<Tenant> tenants = new HashSet<>();
}
