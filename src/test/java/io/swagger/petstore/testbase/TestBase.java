package io.swagger.petstore.testbase;

import io.restassured.RestAssured;
import io.swagger.petstore.utils.TestUtils;
import org.junit.BeforeClass;

/**
 * Created by Jay Vaghani
 */
public class TestBase extends TestUtils {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://petstore.swagger.io/v2";
        //RestAssured.basePath = "/booking";

    }



}
