package session20;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.*;

import java.util.List;

public class tets01 {

    //@Test

    @Test
    public void test02()
    {

        RestAssured.baseURI="https://gorest.co.in/public/v2/users";

        Response response = RestAssured.given()
                .header("Authorization", "Bearer 8d63df87c4a3da08cdff1b0935a6e08d96ec4faf68f42cf24f0ad6615e2c26dc")
                .contentType(ContentType.JSON)
                .body(new File("C:\\Users\\210076\\payload.json"))
                .post();


        System.out.println(response.getStatusCode());

        response.prettyPrint();

    }

}
