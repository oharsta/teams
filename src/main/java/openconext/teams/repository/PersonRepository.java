package openconext.teams.repository;

import openconext.teams.domain.Person;
import openconext.teams.domain.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{

}
