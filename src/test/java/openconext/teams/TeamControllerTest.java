package openconext.teams;

import io.restassured.RestAssured;
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
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.springframework.test.context.jdbc.SqlConfig.ErrorMode.FAIL_ON_ERROR;
import static org.springframework.test.context.jdbc.SqlConfig.TransactionMode.ISOLATED;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, value = {"spring.profiles.active=test"})
@Transactional
@Sql(scripts = {"classpath:sql/clear.sql", "classpath:sql/seed.sql"},
    config = @SqlConfig(errorMode = FAIL_ON_ERROR, transactionMode = ISOLATED))
public class TeamControllerTest {

    @LocalServerPort
    private int serverPort;

    @Value("${security.user.name}")
    private String user;

    @Value("${security.user.password}")
    private String password;

    @Value("${server.contextPath}")
    private String contextPath;

    @Before
    public void before() throws Exception {
        RestAssured.port = serverPort;
    }

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

}