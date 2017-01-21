package openconext.teams;

import openconext.teams.domain.TeamSummary;
import openconext.teams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class TeamController {

    private TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/summaries")
    public List<TeamSummary> summariesByName(@RequestParam("name") String name) {
        return teamRepository.findByNameContainingIgnoreCase(name)
            .map(team -> new TeamSummary(team.getId(), team.getName(), team.getMembershipCount()))
            .collect(toList());
    }

}
