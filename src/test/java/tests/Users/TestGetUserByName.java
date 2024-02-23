package tests.Users;

import api.users.UsersActions;
import helper.Logs;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGetUserByName {
    private final String baseUrl = "https://petstore.swagger.io/v2";
    String validUserName = "string";
    String invalidUserName = "Mostafa";


    @Test(priority = 1)
    public void getUserByValidName() {
        Logs.info("Starting testGetUserByValidName...");
        UsersActions user = new UsersActions(baseUrl);
        Response getUserByNameResponse = user.getUserByName(validUserName);
        Logs.info("Assert on get user by valid name status code");
        Assert.assertEquals(getUserByNameResponse.statusCode(), 200);
        Logs.info("Assert on get user by valid name response");
        Assert.assertEquals(getUserByNameResponse.body().jsonPath().getString("username"), validUserName);
        Logs.info("Finished testGetUserByValidName...");
    }

    @Test(priority = 2)
    public void getUserByInvalidName() {
        String invalidUserErrorMessage = "User not found";
        Logs.info("Starting testGetUserByInvalidName...");
        UsersActions user = new UsersActions(baseUrl);
        Response getUserByNameResponse = user.getUserByName(invalidUserName);
        Logs.info("Assert on get user by invalid name status code");
        Assert.assertEquals(getUserByNameResponse.statusCode(), 404);
        Logs.info("Assert on get user by invalid name response");
        Assert.assertEquals(getUserByNameResponse.body().jsonPath().getString("message"), invalidUserErrorMessage);
        Logs.info("Finished testGetUserByInvalidName...");
    }
}
