package in.co.gorest.usersinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteSingleUserData extends TestBase {
    @Test
    public void deleteSingleUserDetails() {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer afce2670e372d104f4c0bffe2cbdc82dfa20a9dac22d83de7e2066d0f5a6a686")
                .pathParam("id",3928)
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}
