package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class ProjectCreationTest {

    @Test
    public void userCanCreateAProjectTest() {

        RestAssured.baseURI = "https://api.todoist.com";
        RestAssured.basePath = "/rest/v1/";
        RestAssured.requestSpecification = RestAssured.given().header("Authorization", "Bearer 225a183668ebd8367745c77fe9a6094eef654df5")
                .contentType(ContentType.JSON);

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        String projectName = "PierwszyTest";

        RestAssured.given()
                .body("{\"name\":\"PierwszyTest\"}")
        .when()
                .post("/projects")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name",equalTo("PierwszyTest"))
                .header("Content-Type", equalTo("application/json"));

    }
}

