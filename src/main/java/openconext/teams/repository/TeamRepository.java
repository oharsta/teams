package openconext.teams.repository;

import openconext.teams.domain.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface TeamRepository extends PagingAndSortingRepository<Team, Long>{

    Stream<Team> findByNameContainingIgnoreCaseOrderByNameAsc(@Param("name") String name);

}
