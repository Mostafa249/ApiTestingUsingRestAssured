package api;

import helper.Logs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Base {
    protected String baseUrl;

    public Base(String baseUrl) {
        this.baseUrl = baseUrl;
        baseURI = baseUrl;
    }

    public Response getRequest(String endpoint) {
        Logs.info("Sending Get request to: " + baseUrl + endpoint);
        Response response = given()
                .when()
                .get(endpoint);
        Logs.info("Received response: " + response.getBody().asPrettyString());
        return response;
    }

    public Response postRequest(String endpoint, String payload) {
        Logs.info("Sending Get request to: " + baseUrl + endpoint);
        Response response = given()
                .contentType("application/json")
                .body(payload)
                .when().
                post(endpoint);
        Logs.info("Received response: " + response.getBody().asPrettyString());
        return response;
    }

    public Response putRequest(String endpoint, String payload) {
        Logs.info("Sending Get request to: " + baseUrl + endpoint);
        Response response = given()
                .contentType("application/json")
                .body(payload)
                .when().
                put(endpoint);
        Logs.info("Received response: " + response.getBody().asPrettyString());
        return response;
    }

}
