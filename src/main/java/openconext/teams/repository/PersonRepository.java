package openconext.teams.repository;

import openconext.teams.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{

}
