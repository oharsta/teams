package openconext.teams.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity(name = "memberships")
@Getter
@EqualsAndHashCode(of = {"person", "team"})
public class Membership implements Serializable, Comparable<Membership> {

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
    @JsonIgnore
    private Team team;

    @Override
    public int compareTo(Membership other) {
        return this.role.compareTo(other.getRole());
    }
}
