package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Ron"));
    }

    @Test
    public void testHelloNameEndpoint() {
        final String name = UUID.randomUUID().toString();
        given()
                .when().get("/hello/"+name)
                .then()
                .statusCode(200)
                .body(is("Hello "+ name + ", your id is 1234"));
    }

}