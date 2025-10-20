package tests;

import base_urls.JPHBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class C12_PostRequestString extends JPHBaseUrl {

    /*
    Given:
    1) URL: https://jsonplaceholder.typicode.com/todos
    2) Request Body:
       {
           "userId": 55,
           "title": "Tidy your room",
           "completed": false
       }

    When:
    A POST request is sent to the URL.

    Then:
    - The status code should be 201.
    - The response body should match:
       {
           "userId": 55,
           "title": "Tidy your room",
           "completed": false,
           "id": 201
       }
    */

    @Test
    void postRequestString() {

        String payload = """
                {
                    "userId": 55,
                    "title": "Tidy your room",
                    "completed": false
                }
                """;

        Response response = given().spec(spec).body(payload).post("/todos");
        response.prettyPrint();
        response
                .then()
                .statusCode(201)
                .body("userId", equalTo(55),
                     "title", equalTo("Tidy your room"),
                     "completed", equalTo(false));

    }
}
