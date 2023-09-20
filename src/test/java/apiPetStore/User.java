package apiPetStore;

import com.google.gson.Gson;               // Importação de Bibliotecas
import entities.UserEntity;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class User {  // Abertura de classe


    private static int userStatus;
    String JsonBody;
    String ct = "application/json";
    String uri = "https://petstore.swagger.io/v2/";
     Gson gson = new Gson();


    @Test
    public void testCreateUser(){
         UserEntity user = new UserEntity();  //  Criação da Instancia da intidade usuario

        // Atribuição de valores aos campos da instancia
     user.id = 1030;        // Todos esses campos servem para criar um registro de usuario na API
     user.username = "Giovanna";
     user.firstName = "Giovanna";
     user.lastName = "Ferreira";
     user.email = "giovannaf@gmail.com";
     user.password ="123456";
     user.phone = "11999998888";
     User.userStatus = 0;

     JsonBody = gson.toJson(user);      // Converte a entidade usuario no formato Json

     int code = 200;
     String type = "unknown";
     String message = "1030";

     given() //
             .contentType(ct)
             .log().all()
             .body(JsonBody)
     .when()  // Valida
             .post(uri + "user")
     .then() //Serve para dar um retorno de todas as informações fornecidas
             .log().all()
             .statusCode(200)
             .body("code", is(code))
             .body("type", is(type))
             .body("message", is(message))
     ;

    }


}
