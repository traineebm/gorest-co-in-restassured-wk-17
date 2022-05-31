package in.co.gorest.usersinfo;

import in.co.gorest.model.UsersPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateSingleUserData extends TestBase {
    @Test
    public void createSingleUser() {
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName("Tenali Ramakrishna");
        usersPojo.setGender("male");
        usersPojo.setEmail("tenali.ramakrishna129@ce.com");
        usersPojo.setStatus("active");

        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer afce2670e372d104f4c0bffe2cbdc82dfa20a9dac22d83de7e2066d0f5a6a686")
                .body(usersPojo)
                .when()
                .post();
        response.then().statusCode(201); //id 3928
        response.prettyPrint();

    }
}
