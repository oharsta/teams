package openconext.teams.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity(name = "persons")
@Getter
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
    @JsonIgnore
    private Set<Membership> memberships;

}
