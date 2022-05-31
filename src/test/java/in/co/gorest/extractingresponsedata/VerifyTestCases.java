package in.co.gorest.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class VerifyTestCases {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RestAssured.basePath = "/users";
        response = given()
                .when()
                .get()
                .then().statusCode(200);
    }

    // 1) Verify total records are 20
    @Test
    public void test001() {

        List<String> userRecords = response.extract().path("");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total no of users records are : " + userRecords.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // 2) Verify id ___ has name = ""
    @Test
    public void test002() {

        List<String> name = response.extract().path("findAll{it.id==2667}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of Id 2667 is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    // 3) Verify id ____ has email = ""
    @Test
    public void test003() {

        List<String> email = response.extract().path("findAll{it.id==2665}.email");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The email of id 2665 is : " + email);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Verify All ID has status = "active"
    @Test
    public void test004() {

        List<String> expectedMessage = response.extract().path("status");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Verify all Id status : " + expectedMessage);
        System.out.println("------------------End of Test---------------------------");
    }

    // 5) Verify id 2664 has gender = "female"
    @Test
    public void test005() {

        List<String> fGender = response.extract().path("findAll{it.id==2664}.gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Verify id 2664 has gender male: " + fGender);
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) Verify id 2661 has gender = "male"
    @Test
    public void test006() {

        List<String> mGender = response.extract().path("findAll{it.id==2661}.gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Verify id 2661 has gender male: " + mGender);
        System.out.println("------------------End of Test---------------------------");
    }

}
