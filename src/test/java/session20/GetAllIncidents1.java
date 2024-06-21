package session20;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.*;
import java.util.List;


public class GetAllIncidents1 {


    @BeforeClass
    public void setUp(){
        
    }

    @Test
    public void getIncident()
    {

        RestAssured.baseURI="https://dev203680.service-now.com/api/now/table/incident";

        RestAssured.authentication=RestAssured.basic("admin","Karthik@123");

        Response response = RestAssured.get();

        JsonPath jsonPath = response.jsonPath();

        List<String> list = jsonPath.getList("result.sys_id");

        for (String i:list
             ) {
            System.out.println(i);
        }

    }


}





