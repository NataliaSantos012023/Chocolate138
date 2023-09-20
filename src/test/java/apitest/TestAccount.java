package apitest;

import com.google.gson.Gson;
import entities.AccountEntity;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.ITestContext;  // Interface do TestNG para compartilhar variaveis do grupo

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TestAccount {
    // 3.1 - Atributos
 String userId;
 String ct = "application/json"; // contentType da API
 String jsonBody; // Variavel para guardar o json que será enviado
    String uri = "https://bookstore.toolsqa.com/Account/v1/"; // Endereço Base
    Response resposta; // Vai Guardar o retorno da API
    static String token; // Guardar o token - autenticação do usuário
    // 3.1.2 - Instanciar Classes externas
    Gson gson = new Gson(); // Instancia o objeto de conversão classe para json
    AccountEntity account = new AccountEntity(); // instancia da entidade usuario

    // Método #1 - Criar usuário
    @Test(priority = 1)
    public void testCreateuser(ITestContext context){
        // Arrange - Configuea

        account.userName = "giovanna23"; //Entrada e saida (resultado esperado)
        account.password = "Gi@12345";     // Entrada

        jsonBody = gson.toJson(account); // Converte a entidade usuario no formato Json

        // Act - Executa

        // Dado - Quando - Então
        // Given - When  - Then
        resposta =  (Response) given() // Dado
                .contentType(ct) // tipo de contéudo
                .log().all()                     // Registre tudo
                .body(jsonBody)    // Corpo da mensagem que será enviada
        .when() // Quando
                .post(uri + "User")
        // Assert - Valida
        .then() // Então
                .log().all() // Registra tudo de volta
                .statusCode(201) // Valida o usuario
                .body("username", is (account.userName)) // Valida o usuario
                .extract()
        ; // Fim da linha do REST-assured

         // Extrair o userID (identificação do usuario)
        userId = resposta.jsonPath().getString("userID");
        context.setAttribute("userID", userId);
        System.out.println("userID extraido: " + userId);


    }
    @Test(priority = 2)
    public void testGenerateToken(ITestContext context){  // Declarar a interface do contexto
        // configura
        // ---> Dados de Entrada são fornecidos pela AccountEntity
        // ---> Resultado Esperado é que ele receba um token

        // Executa
        resposta = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "GenerateToken")
        .then()
                .log().all()
                .statusCode(200)
        .extract()
        ;
         // Extração do Token
        token = resposta.jsonPath().getString("token");
        context.setAttribute("token", token);
        System.out.println("token: " + token);


        // Valida
        Assert.assertTrue(token.length() != 0); // verifica ser e verdadeiro


    } // fim do método de geração de tokem identificação de usuario

    @Test(priority = 3)
    public void testAuthorized(){
        // Configura
        // Dados de Entrada
        // ---> São fornecidos pelo AccountEntity através do método testCreateUser - priority = 1

        //Dados de Saída / Resultado Esperado
        // StatusCode = 200
        // Response Body = true

    // Executa
        //  Esta estrutura são divisão do teste --> Given, when, then, no formato do teste REST-assured
    given()
                .contentType(ct)    // Formato da msg
                .log().all()        // Registra no log.all tudo que aconteceu na ida da msg
                .body(jsonBody)     // Corpo da msg
    .when() // Ação --> de post ---> Incluir
            .post(uri + "Authorized")
    // Valida
            // then == Resposta
    .then()
            .log().all()  // Exibi tudo que aconteceu na  voltou
            .statusCode(200)  // Valida se a conexão teve sucesso
    // .body(is (true)-// olha uma o mais informação que eu queira //Todo:ComoValidar o retorno do body apenas como true
    ;

    }

    @Test(priority = 4)
    public void testResearchUserNotAuthorized(){
        // Configura
        // Dados De Entrada
        // userId foi extraido no método testCreateUser e está na memória
        // Dados de saída / Resultado Esperado
        // Status code = 401, Code = 1200 e Message = User not authorized!

        // Executa
        given()                                        //Dado // Comandos do REST-assured
                .contentType(ct)
                .log().all()
        .when()
                .get(uri + "user/" + userId)      // Consulta o usuário pelo userId
        // Valida
        .then()
                .log().all()
                .statusCode(401)           // Valida se não esta autorizado
                .body("code", is("1200"))  //Valida o código da mensagem 'não autorizado"
                .body("message", is("User not authorized!"))
        ;  // Conclui o bloco do REST-assured
    }

    @Test(priority = 5)
    public void testResearchUser(){
        // Configura
        // Dados De Entrada
        // userId foi extraido no método testCreateUser e está na memória
        // Dados de saída / Resultado Esperado

        // Executa
        given()                                        //Dado // Comandos do REST-assured
                .contentType(ct)
                .log().all()
                .header("Authorization", "Bearer " + token)
        .when()
                .get(uri + "user/" + userId)      // Consulta o usuário pelo userId
                // Valida
        .then()
                .log().all()
                .statusCode(200)// Valida se a conexão teve sucesso
                .body("userId", is(userId))
                .body("username", is(account.userName))  //Valida o nome do usuário
        ;  // Conclui o bloco do REST-assured
    }

    @Test(priority = 6)
    public void testDeleteUser(){
        // Configura
        //Dados de entrada vem do método de teste de criação do usuário (UserId)
        // Resultado esperado é o código e mensagem de sucesso na extração do usuário

        // Executa
        given()
                .log().all()
                .contentType(ct)
                .header("Authorization", "Bearer " + token)
        .when()
                .delete(uri + "User/" + userId)
         // Valida
        .then()
                .log().all()
                .statusCode(204)
        ;

    }



}
