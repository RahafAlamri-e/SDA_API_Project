package tests;

import base_urls.JPHBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ToDoPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C18_POJOPayload extends JPHBaseUrl {

    /*
    Given
        https://jsonplaceholder.typicode.com/todos
        {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
        }
    When
        I send a POST Request to the URL
    Then
        Status code is 201
    And
        Response body is like:
        {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
        }
    */

    @Test
    void pojoPayloadTest(){

        // prepare the payload(POJO)
        ToDoPojo expectedData = new ToDoPojo(55,"Tidy your roo",false);
        System.out.println("payload = " + expectedData);

        // send the request
        Response response = given(spec).body(expectedData).post("/todos");
        response.prettyPrint();

        //Do assertion
        //Convert the response into ToDoPojo object and assert it
        ToDoPojo actualData = response.as(ToDoPojo.class);//De-Serialization -> Uses default constructor to convert
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 201);
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());


    }
}
