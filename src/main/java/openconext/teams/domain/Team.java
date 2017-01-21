package openconext.teams.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

@Entity(name = "teams")
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Instant created;

    @Formula("(select count(*) from memberships m where m.team_id = id)")
    private int membershipCount;

    @OneToMany(mappedBy = "team")
    private Set<Membership> memberships;

}
