package tests.booker_crud;

import base_urls.BookerBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static tests.booker_crud.R02_CreateBooking.bookingId;
import static utilities.ObjectMapperUtils.getJsonNode;

public class R03_GetBooking extends BookerBaseUrl {

    @Test
    void getBookingTest() {

        //prepare the expected data
        JsonNode expectedData = getJsonNode("booking");

        //send the request
        Response response = given(spec).get("/booking/" + bookingId);
        response.prettyPrint();

        //do assertion
        response
                .then()
                .statusCode(200)
                .body(
                        "firstname", equalTo(expectedData.get("firstname").asText()),
                        "lastname", equalTo(expectedData.get("lastname").asText()),
                        "totalprice", equalTo(expectedData.get("totalprice").asInt()),
                        "depositpaid", equalTo(expectedData.get("depositpaid").asBoolean()),
                        "bookingdates.checkin", equalTo(expectedData.get("bookingdates").get("checkin").asText()),
                        "bookingdates.checkout", equalTo(expectedData.get("bookingdates").get("checkout").asText()),
                        "additionalneeds", equalTo(expectedData.get("additionalneeds").asText())
                );
    }

}
