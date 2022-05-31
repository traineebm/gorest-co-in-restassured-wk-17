package in.co.gorest.usersinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersDetails extends TestBase {

    @Test
    public void getAllUsers() {
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
    }

}