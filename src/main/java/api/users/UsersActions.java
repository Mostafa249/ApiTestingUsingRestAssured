package api.users;

import api.Base;
import io.restassured.response.Response;

public class UsersActions extends Base {
    public UsersActions(String baseUrl) {
        super(baseUrl);
    }

    public Response getUserByName(String userName) {
        return getRequest("/user/" + userName);
    }

    public Response addUser(String userPayload) {
        String endpoint = "/user";
        return postRequest(endpoint, userPayload);
    }
    public Response addListOfUsers(String userPayload) {
        String endpoint = "/user/createWithArray";
        return postRequest(endpoint, userPayload);
    }

    public Response updatePet(String userPayload) {
        String endpoint = "/user";
        return putRequest(endpoint, userPayload);
    }

}
