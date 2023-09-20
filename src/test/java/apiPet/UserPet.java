package apiPet;

import com.google.gson.Gson;
import entities.PetEntity;
import io.restassured.specification.Argument;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


 public class UserPet {

    String jsonBoby;
    String ct = "application/json";
    String uri = "https://petstore.swagger.io/v2/";
    Gson gson = new Gson();


    @Test
    public void testCreateUser(){

        PetEntity pet =  new PetEntity();
        pet.id = 2540;
        pet.name = "Ozzy";
        pet.category = new PetEntity.Category();
        pet.category.id = 0;
        pet.category.name = "Cachorro";
        pet.status = "available";

        jsonBoby = gson.toJson(pet);

        int code = 200;
        String type = "unlwnown";
        String message = "2540";

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBoby)
        .when()
                .post(uri + "pet")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(pet.id))
                .body("name" ,is (pet.name))
                .body("status", is(pet.status))
        ;


    }




 }


