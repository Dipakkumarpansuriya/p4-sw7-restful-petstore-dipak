package io.swagger.petstore.crudtest;

import io.restassured.response.Response;
import io.swagger.petstore.model.PetPojo;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetCRUDTest extends TestBase {

    @Test
    public void addNewPet(){
        PetPojo petPojo = new PetPojo();

        petPojo.setId(101);

        HashMap<Object,Object> newCategory = new HashMap<>();
        newCategory.put("id", 5);
        newCategory.put("name", "cow");
        petPojo.setCategory(newCategory);
        petPojo.setName("Mango");

        List<Object> newList = new ArrayList<>();
        newList.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fimages%2Fanimals%2Fcow&psig=AOvVaw3QhqplMd62FWUjjuSIySTU&ust=1672426302283000&source=images&cd=vfe&ved=0CA4QjRxqFwoTCJCq28-_n_wCFQAAAAAdAAAAABAE");
        petPojo.setPhotoUrls(newList);

        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        HashMap<Object,Object> tagHash = new HashMap<>();
        tagHash.put("id", 11);
        tagHash.put("name", "cattle");
        tagList.add(tagHash);
        petPojo.setTags(tagList);

        petPojo.setStatus("available");

        Response response=given()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .post("/pet");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void findPetById(){
        Response response=given()
                .when()
                .get("/pet/101");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void updateExistingPetDetails(){
        PetPojo petPojo = new PetPojo();

        petPojo.setId(101);

        HashMap<Object,Object> newCategory = new HashMap<>();
        newCategory.put("id", 5);
        newCategory.put("name", "cow");
        petPojo.setCategory(newCategory);
        petPojo.setName("Mangodoly");

        List<Object> newList = new ArrayList<>();
        newList.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fimages%2Fanimals%2Fcow&psig=AOvVaw3QhqplMd62FWUjjuSIySTU&ust=1672426302283000&source=images&cd=vfe&ved=0CA4QjRxqFwoTCJCq28-_n_wCFQAAAAAdAAAAABAE");
        petPojo.setPhotoUrls(newList);

        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        HashMap<Object,Object> tagHash = new HashMap<>();
        tagHash.put("id", 11);
        tagHash.put("name", "cattle");
        tagList.add(tagHash);
        petPojo.setTags(tagList);

        petPojo.setStatus("available");

        Response response=given()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .put("/pet");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void deletePet(){
        Response response=given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/pet/101");
        response.then().statusCode(200);
        response.prettyPrint();

    }



}
