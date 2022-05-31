package in.co.gorest.usersinfo;

import in.co.gorest.model.UsersPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateSingleUserData extends TestBase {

    @Test
    public void updateUserRecord(){
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName("Allasani Peddana");
        usersPojo.setEmail("allasani.peddana@gmail.com");
        usersPojo.setStatus("active");
        usersPojo.setGender("female");

        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer afce2670e372d104f4c0bffe2cbdc82dfa20a9dac22d83de7e2066d0f5a6a686")
                .body(usersPojo)
                .pathParam("id",3928)
                .when()
                .patch("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
