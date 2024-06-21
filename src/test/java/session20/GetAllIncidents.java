package session20;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllIncidents {


    @BeforeClass
    public void setUp(){

    }

    @Test
    public void getIncident() {

        String jsonString = "{\"username\":\"admin\",\"password\":\"password123\"}";
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/auth";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                    .post()
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("token",Matchers.notNullValue())
                    .body("token.length()",Matchers.is(15));


    }


}





