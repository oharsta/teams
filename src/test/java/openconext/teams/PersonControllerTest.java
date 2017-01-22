package openconext.teams;

import io.restassured.RestAssured;
import openconext.teams.domain.Membership;
import openconext.teams.domain.Role;
import openconext.teams.domain.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static java.util.Comparator.naturalOrder;
import static openconext.teams.domain.Role.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.context.jdbc.SqlConfig.ErrorMode.FAIL_ON_ERROR;
import static org.springframework.test.context.jdbc.SqlConfig.TransactionMode.ISOLATED;

public class PersonControllerTest extends AbstractApplicationTest {

    @Test
    public void myTeams() throws Exception {
        given()
            .param("id", 5)
            .auth().basic(user, password)
            .when()
            .get(contextPath + "/myTeams")
            .then()
            .statusCode(SC_OK)
            .body("[0].name", equalTo("giants"))
            .body("[0].membershipCount", equalTo(2))
            .body("[0].role", equalTo("MEMBER"))
            .body("[1].name", equalTo("gliders"))
            .body("[1].membershipCount", equalTo(2))
            .body("[1].role", equalTo("ADMIN"));

    }

}