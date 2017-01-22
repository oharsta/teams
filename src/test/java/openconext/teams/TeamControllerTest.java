package openconext.teams;

import openconext.teams.domain.Membership;
import openconext.teams.domain.Role;
import openconext.teams.domain.Team;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static java.util.Comparator.naturalOrder;
import static openconext.teams.domain.Role.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class TeamControllerTest extends AbstractApplicationTest {

    @Test
    public void summariesByName() throws Exception {
        given()
            .param("name", "DERS")
            .auth().basic(user, password)
            .when()
            .get(contextPath + "/summaries")
            .then()
            .statusCode(SC_OK)
            .body("[0].name", equalTo("gliders"))
            .body("[0].membershipCount", equalTo(2))
            .body("[1].name", equalTo("riders"))
            .body("[1].membershipCount", equalTo(3));
    }

    @Test
    public void team() throws Exception {
        Team team = given()
            .auth().basic(user, password)
            .when()
            .get(contextPath + "/teams/1")
            .getBody()
            .as(Team.class);

        assertEquals("riders", team.getName());
        List<Membership> memberships = new ArrayList<>(team.getMemberships());
        memberships.sort(naturalOrder());

        assertMembership(memberships.get(0), MEMBER, "Mary Doe");
        assertMembership(memberships.get(1), MANAGER, "William Doe");
        assertMembership(memberships.get(2), ADMIN, "John Doe");
    }

    private void assertMembership(Membership membership, Role role, String name) {
        assertEquals(role, membership.getRole());
        assertEquals(name, membership.getPerson().getName());

    }
}