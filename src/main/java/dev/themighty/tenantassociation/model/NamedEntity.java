package dev.themighty.tenantassociation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    public NamedEntity(Long id, LocalDateTime createDateTime, LocalDateTime updateDateTime, String firstName,
                       String lastName) {
        super(id, createDateTime, updateDateTime);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
