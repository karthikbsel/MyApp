package session10;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


public class AuthorisationDemo {

    @Test
    public  void postRequest(){

      RestAssured.baseURI="https://petstore.swagger.io/v2/pet/1/uploadImage";

        File file = new File("C:\\Users\\210076\\Vpnerror.png");
        Response response = RestAssured.given().multiPart(file).contentType("multipart/form-data").post();
        System.out.println(response.statusCode());


    }

}


