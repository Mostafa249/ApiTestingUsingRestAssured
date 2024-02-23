package tests.petsStore;

import api.petsStore.PetStoreActions;
import helper.JsonReader;
import helper.Logs;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUpdatePet {
    private final String baseUrl = "https://petstore.swagger.io/v2";
    JSONObject payloadJson = JsonReader.readJsonFile("petPayloads.json");

    @Test
    public void updatePetName() {
        Logs.info("Starting testUpdatePetName...");
        PetStoreActions petStore = new PetStoreActions(baseUrl);
        String payload = JsonReader.getJsonValue(payloadJson, "updatePetName");
        Response createPetResponse = petStore.updatePet(payload);
        Logs.info("Assert on update pet name status code");
        Assert.assertEquals(createPetResponse.statusCode(), 200);
        Logs.info("Finished testUpdatePetName...");
    }
}
