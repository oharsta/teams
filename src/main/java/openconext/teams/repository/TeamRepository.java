package openconext.teams.repository;

import openconext.teams.domain.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface TeamRepository extends PagingAndSortingRepository<Team, Long>{

    Stream<Team> findByNameContainingIgnoreCase(@Param("name") String name);
}
