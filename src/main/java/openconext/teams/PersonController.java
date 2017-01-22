package openconext.teams;

import openconext.teams.domain.Membership;
import openconext.teams.domain.MyTeamSummary;
import openconext.teams.domain.Team;
import openconext.teams.domain.TeamSummary;
import openconext.teams.repository.PersonRepository;
import openconext.teams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/myTeams")
    public List<MyTeamSummary> myTeams(@RequestParam("id") Long id) {
        //TODO get the id from the logged person JWT
        List<MyTeamSummary> myTeams = personRepository.findOne(id).getMemberships().stream()
            .map(this::teamSummary)
            .collect(toList());
        myTeams.sort(naturalOrder());
        return myTeams;
    }

    private MyTeamSummary teamSummary(Membership membership) {
        Team team = membership.getTeam();
        return new MyTeamSummary(team.getId(), team.getName(), team.getMembershipCount(), membership.getRole());
    }

}
