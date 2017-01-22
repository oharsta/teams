package openconext.teams.repository;

import openconext.teams.domain.Membership;
import openconext.teams.domain.Team;
import openconext.teams.repository.PersonRepository;
import openconext.teams.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.context.jdbc.SqlConfig.ErrorMode.FAIL_ON_ERROR;
import static org.springframework.test.context.jdbc.SqlConfig.TransactionMode.ISOLATED;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, value = {"spring.profiles.active=test"})
@Transactional
@Sql(scripts = {"classpath:sql/clear.sql", "classpath:sql/seed.sql"},
    config = @SqlConfig(errorMode = FAIL_ON_ERROR, transactionMode = ISOLATED))
public class PersonRepositoryTest {

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
