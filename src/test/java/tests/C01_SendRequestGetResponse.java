package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class C01_SendRequestGetResponse {

    public static void main(String[] args) {
        Response response = RestAssured .get("https://restful-booker.herokuapp.com/booking");// sends a GET request to the specified URL

        response.prettyPrint();// prints the JSON response body in a pretty format

        int statusCode = response.getStatusCode();// retrieves the status code from the response
        System.out.println("Status Code: " + statusCode);

        System.out.println("response.statusLine() = " + response.statusLine());// gets the status line from the response
        System.out.println("response.contentType() = " + response.contentType());// gets the content type of the response
        System.out.println("response.time() = " + response.time());// gets the time taken to receive the response in milliseconds

        System.out.println("response.header(\"Server\") = " + response.header("Server"));// retrieves the value of the "Server" header from the response

        System.out.println("response.headers() = " + response.headers());// get all headers from the response
    }
}
