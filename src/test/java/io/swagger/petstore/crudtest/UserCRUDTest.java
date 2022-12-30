package io.swagger.petstore.crudtest;

import io.restassured.response.Response;
import io.swagger.petstore.model.UserPojo;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

    @Test
    public void createUser(){

        UserPojo userPojo = new UserPojo();

        userPojo.setId(0);
        userPojo.setUsername("Dipak101");
        userPojo.setFirstName("Dipak");
        userPojo.setLastName("Patel");
        userPojo.setEmail("dpatel" + getRandomValue() + "@email.com");
        userPojo.setPassword("patel123");
        userPojo.setPhone("07766655555");
        userPojo.setUserStatus(1);


        Response response=given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post("/user");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getUserByUserId(){
        Response response=given()
                .when()
                .get("/user/Dipak101");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void updateUserByUserName(){

        UserPojo userPojo = new UserPojo();

        userPojo.setId(101);
        userPojo.setUsername("Dipak101");
        userPojo.setFirstName("Dipak");
        userPojo.setLastName("Patel");
        userPojo.setEmail("dpatel" + getRandomValue() + "@email.com");
        userPojo.setPassword("patel123");
        userPojo.setPhone("07766655555");
        userPojo.setUserStatus(1);

        Response response=given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .put("/user/Dipak101");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void deleteUserByUsername(){

        Response response=given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/user/Dipak101");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
