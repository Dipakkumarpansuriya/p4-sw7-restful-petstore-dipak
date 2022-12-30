package io.swagger.petstore.testsuite;

import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.testbase.TestBase;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

public class CreatePetTest extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        response = given()
                .when()
                .post("/user/createWithArray")
                .then().statusCode(200); //method type of this is validatable response
    }


}
