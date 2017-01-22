package openconext.teams.repository;

import openconext.teams.AbstractApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class TeamRepositoryTest extends AbstractApplicationTest {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void findByNameContaining() {
        assertEquals(2, teamRepository.findByNameContainingIgnoreCaseOrderByNameAsc("DERS").count());
    }

    @Test
    public void membershipCount() {
        assertEquals(3, teamRepository.findOne(1L).getMembershipCount());
    }


}
