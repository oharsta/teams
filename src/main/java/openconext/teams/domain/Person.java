package openconext.teams.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

@Entity(name = "persons")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Instant created;

    @OneToMany(mappedBy = "person")
    private Set<Membership> memberships;

}
