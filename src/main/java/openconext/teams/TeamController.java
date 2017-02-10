package openconext.teams;

import openconext.teams.domain.Team;
import openconext.teams.domain.TeamSummary;
import openconext.teams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/summaries")
    public List<TeamSummary> summariesByName(@RequestParam("name") String name) {
        return teamRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name)
            .map(team -> new TeamSummary(team.getId(), team.getName(), team.getMembershipCount(), team.getDescription()))
            .collect(toList());
    }

    @GetMapping("/teams/{id}")
    public Team team(@PathVariable("id") Long id) {
        return teamRepository.findOne(id);
    }

}
