package tests.petsStore;

import api.petsStore.PetStoreActions;
import helper.Logs;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGetPetByID {
    private final String baseUrl = "https://petstore.swagger.io/v2";

    private final int validID = 10;
    private final int invalidID = 1000;

    @Test(priority = 1)
    public void getPetByValidID() {
        Logs.info("Starting testGetPetByValidID...");
        PetStoreActions petStore = new PetStoreActions(baseUrl);
        Response getPetByIDResponse = petStore.getPetByID(validID);
        Logs.info("Assert on get pey by valid id status code");
        Assert.assertEquals(getPetByIDResponse.statusCode(), 200);
        Logs.info("Assert on get pey by valid id response");
        Assert.assertEquals(getPetByIDResponse.body().jsonPath().getInt("id"), validID);
        Logs.info("Finished testGetPetByValidID...");
    }

    @Test(priority = 2)
    public void getPetByInvalidID() {
        String errorMessage = "Pet not found";
        Logs.info("Starting testGetPetByInvalidID...");
        PetStoreActions petStore = new PetStoreActions(baseUrl);
        Response getPetByIDResponse = petStore.getPetByID(invalidID);
        Logs.info("Assert on get pey by invalid id status code");
        Assert.assertEquals(getPetByIDResponse.statusCode(), 404);
        Logs.info("Assert on get pey by invalid id response");
        Assert.assertEquals(getPetByIDResponse.body().jsonPath().getString("message"), errorMessage);
        Logs.info("Finished testGetPetByInvalidID...");
    }
}
