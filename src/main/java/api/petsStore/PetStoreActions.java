package api.petsStore;

import api.Base;
import io.restassured.response.Response;

public class PetStoreActions extends Base {
    public PetStoreActions(String baseUrl) {
        super(baseUrl);

    }

    public Response getPetByID(int petID) {
        return getRequest("/pet/" + petID);
    }

    public Response addPet(String petPayload) {
        String endpoint = "/pet";
        return postRequest(endpoint, petPayload);
    }

    public Response updatePet(String petPayload) {
        String endpoint = "/pet";
        return putRequest(endpoint, petPayload);
    }
}
