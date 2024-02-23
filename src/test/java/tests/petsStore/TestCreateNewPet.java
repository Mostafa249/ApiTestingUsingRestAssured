package tests.petsStore;

import api.petsStore.PetStoreActions;
import helper.JsonReader;
import helper.Logs;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(helper.Listeners.class)
public class TestCreateNewPet {
    private final String baseUrl = "https://petstore.swagger.io/v2";
    JSONObject payloadJson = JsonReader.readJsonFile("petPayloads.json");

    @Test(priority = 1,description = "Test create new pet without name")
    public void createPetWithoutName() {
        Logs.info("Starting testCreatePetWithoutName...");
        PetStoreActions petStore = new PetStoreActions(baseUrl);
        String payload = JsonReader.getJsonValue(payloadJson, "createPetWithoutName");
        Response createPetResponse = petStore.addPet(payload);
        Logs.info("Assert on create pet without name status code");
        Assert.assertEquals(createPetResponse.statusCode(), 200);
        Logs.info("Assert on create pet without name response");
        Assert.assertFalse(createPetResponse.body().jsonPath().get("name") != null);
        Logs.info("Finished testCreatePetWithoutName...");
    }

    @Test(priority = 2)
    public void createPetWithoutPhoto() {
        Logs.info("Starting testCreatePetWithoutPhoto...");
        PetStoreActions petStore = new PetStoreActions(baseUrl);
        String payload = JsonReader.getJsonValue(payloadJson, "createPetWithoutPhoto");
        Response createPetResponse = petStore.addPet(payload);
        Logs.info("Assert on create pet without photo status code");
        Assert.assertEquals(createPetResponse.statusCode(), 200);
        Logs.info("Assert on create pet without photo response");
        Assert.assertFalse(createPetResponse.body().jsonPath().get("photoUrls") == null);
        Logs.info("Finished testCreatePetWithoutPhoto...");
    }

}
