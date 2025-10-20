package tests;

import base_urls.BookerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;

public class C19_NestedPojo extends BookerBaseUrl {
/*
    Given
    1) Endpoint: https://restful-booker.herokuapp.com/booking
    2) Request Body:
            {
                "firstname": "Josh",
                "lastname": "Allen",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "super bowls"
            }

    When
    I send a POST request to the above URL

    Then
    1) The status code should be 200
    2) The response body should match the following structure:
       {
           "bookingid": 2243,
           "booking":
                {
                    "firstname": "Josh",
                    "lastname": "Allen",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Tea"
                }
       }
*/

    @Test
    void nestedPojoTest() {

        //Prepare the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Josh", "Allen", 111, true, bookingDatesPojo, "Coffee");
        System.out.println("expectedData = " + expectedData);

        //Send the request
        Response response = given(spec).body(expectedData).post("/booking");
        response.prettyPrint();


    }
}
