package openconext.teams;

import openconext.teams.domain.Team;
import openconext.teams.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.context.jdbc.SqlConfig.ErrorMode.FAIL_ON_ERROR;
import static org.springframework.test.context.jdbc.SqlConfig.TransactionMode.ISOLATED;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, value = {"spring.profiles.active=test"})
@Transactional
@Sql(scripts = {"classpath:sql/clear.sql", "classpath:sql/seed.sql"},
    config = @SqlConfig(errorMode = FAIL_ON_ERROR, transactionMode = ISOLATED))
public class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

	@Test
	public void findByNameContaining() {
	    assertEquals(2, teamRepository.findByNameContainingIgnoreCase("DERS").count());
	}

    @Test
    public void membershipCount() {
        Team team = teamRepository.findOne(1L);
        assertEquals(3, team.getMembershipCount());
    }


}
