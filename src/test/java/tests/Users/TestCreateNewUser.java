package tests.Users;

import api.users.UsersActions;
import helper.JsonReader;
import helper.Logs;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCreateNewUser {
    private final String baseUrl = "https://petstore.swagger.io/v2";
    JSONObject payloadJson = JsonReader.readJsonFile("userPayloads.json");

    @Test(priority = 1)
    public void createSingleUser() {
        Logs.info("Starting testCreateSingleUser...");
        UsersActions user = new UsersActions(baseUrl);
        String payload = JsonReader.getJsonValue(payloadJson, "createSingleUser");
        Response createSingleUserResponse = user.addListOfUsers(payload);
        Logs.info("Assert on create single user status code");
        Assert.assertEquals(createSingleUserResponse.body().jsonPath().getInt("code"), 200);
        Logs.info("Finished testCreateSingleUser...");
    }

    @Test(priority = 2)
    public void createMultiUsers() {
        Logs.info("Starting testCreateMultiUsers...");
        UsersActions user = new UsersActions(baseUrl);
        String payload = JsonReader.getJsonValue(payloadJson, "createMultiUsers");
        Response createSingleUserResponse = user.addListOfUsers(payload);
        Logs.info("Assert on create multi users status code");
        Assert.assertEquals(createSingleUserResponse.body().jsonPath().getInt("code"), 200);
        Logs.info("Finished testCreateMultiUsers...");
    }
}
