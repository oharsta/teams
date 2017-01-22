package openconext.teams.repository;

import openconext.teams.AbstractApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class PersonRepositoryTest extends AbstractApplicationTest {

    @Autowired
    private PersonRepository personRepository;

	@Test
	public void findTeamsByPerson() {
        List<String> names = personRepository.findOne(4L).getMemberships().stream()
            .map(membership -> membership.getTeam().getName())
            .collect(toList());
        names.sort(naturalOrder());

        assertEquals(names, asList("giants", "gliders"));

    }


}
