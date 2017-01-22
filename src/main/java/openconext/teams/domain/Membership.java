package openconext.teams.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Entity(name = "memberships")
@Getter
@Setter
@EqualsAndHashCode(of = {"person", "team"})
public class Membership implements Serializable {

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private Instant created;

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
