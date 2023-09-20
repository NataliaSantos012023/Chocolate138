package bookingTest;

import com.google.gson.Gson;
import entities.BookingAuthEntity;
import entities.BookingUpdateEntity;
import entities.BookingEntity;
import entities.PatchBookingEntity;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


 public class CreateBookingTest {
    Gson gson = new Gson();
    Response resposta;
    String token;
    String uri = "https://restful-booker.herokuapp.com/";
    String ct = "application/json";
    int bookingId = 1;
    BookingEntity bookingEntity = new BookingEntity();




     @BeforeClass
     public void setup() {
         createToken();
     }

     public void createToken() {
        BookingAuthEntity bookingAuth = new BookingAuthEntity();

        bookingAuth.username = "admin";
        bookingAuth.password = "password123";
        String JsonBody = gson.toJson(bookingAuth);

        resposta = (Response) given()
                .log().all()
                .contentType(ct)
                .body(JsonBody)
        .when()
                .post(uri + "auth")
        .then()
                .log().all()
                .statusCode(200)
                .extract()
        ;

        token = resposta.jsonPath().getString("token");
        System.out.println("token: " + token);

    }

     @Test(priority = 1)  // Obter Ids de Reserva
     public void BookingIdsTest(){


         given()
                 .contentType(ct)
                 .log().all()
         .when()
                 .get(uri + "booking")
         .then()
                 .log().all()
                 .statusCode(200)
         ;
     }

    @Test(priority = 2)  // Criar uma reserva
    public void BookingUserTest()  {

        bookingEntity.firstname = "Jim";
        bookingEntity.lastname = "Brown";
        bookingEntity.totalprice = 111;
        bookingEntity.depositpaid = true;

        BookingEntity.BookingDates bookingDates = new BookingEntity.BookingDates();
        bookingDates.checkin = "2018-01-01";
        bookingDates.checkout = "2019-01-01";

        bookingEntity.bookingdates = bookingDates;
        bookingEntity.additionalneeds = "Breakfast";

        String gsonBookingEntity = new Gson().toJson(bookingEntity);

        resposta = (Response) given()
                .log().all()
                .contentType(ct)
                .body(gsonBookingEntity)

        .when()
                .post(uri + "booking")
        .then()
                .log().all()
                .statusCode(200)
                .extract()
        ;
    }

     @Test(priority = 3)  // Obter uma reserva
     public void GetBookingTest(){

          resposta = (Response) given()
                 .header("Accept", "application/json")
                 .log().all()
          .when()
                 .get(uri + "booking/" + bookingId)
          .then()
                 .log().all()
                 .statusCode(200)
                  .extract()
          ;
     }

     @Test(priority = 4)  // Atualizar reserva
     public void UpdateBookingTest()  {
         BookingUpdateEntity bookingUpdateEntity = new BookingUpdateEntity();
         bookingUpdateEntity.firstname = "Sally";
         bookingUpdateEntity.lastname = "Jackson";
         bookingUpdateEntity.totalprice = 833;
         bookingUpdateEntity.depositpaid = true;

         BookingUpdateEntity.DatesBooking datesBooking = new BookingUpdateEntity.DatesBooking();
         datesBooking.checkin = "2022-02-10";
         datesBooking.checkout = "2023-04-02";

         bookingUpdateEntity.bookingdates = datesBooking;
         bookingUpdateEntity.additionalneeds = "Breakfast";

         String gsonBookingUpdateEntity = new Gson().toJson(bookingUpdateEntity);

         given()
                 .log().all()
                 .contentType(ct)
                 .header("Cookie", "token= " + token )
                 .body(gsonBookingUpdateEntity)
         .when()
                 .put(uri + "booking/" + bookingId)
         .then()
                 .log().all()
                 .statusCode(200)
                 .body("firstname", is(bookingUpdateEntity.firstname))
                 .body("lastname", is(bookingUpdateEntity.lastname))
                 .body("totalprice", is(bookingUpdateEntity.totalprice))
                 .body("depositpaid", is(bookingUpdateEntity.depositpaid))
                 .body("bookingdates.checkin",is(datesBooking.checkin))
                 .body("bookingdates.checkout", is(datesBooking.checkout))
                 .body("additionalneeds", is(bookingUpdateEntity.additionalneeds));

     }

     @Test(priority = 5)  // Atualização parcial da reserva
     public void PartialUpdateBookingTest(){
         PatchBookingEntity patchBookingEntity = new PatchBookingEntity();

         patchBookingEntity.firstname = "Gigi";
         patchBookingEntity.lastname = "Princess";

         String gsonPatchBookingEntity = new Gson().toJson(patchBookingEntity);

        given()
                .log().all()
                .contentType(ct)
                .header("Cookie", "token= " + token )
                .body(gsonPatchBookingEntity)
        .when()
                 .patch(uri + "booking/" + bookingId)
        .then()
                 .log().all()
                .statusCode(200)
                .body("firstname", is(patchBookingEntity.firstname))
                .body("lastname", is(patchBookingEntity.lastname))
        ;

     }

     @Test(priority = 6)  // Excluir reserva
     public void DeleteBookingTest(){

         given()
                 .contentType(ct)
                 .header("Cookie", "token= " + token)
         .when()
                 .delete(uri + "booking/" + bookingId)
         .then()
                 .log().all()
                 .statusCode(201)
                 .body(is("Created"))
         ;
     }

     @Test(priority = 7)
     public void testHealthCheckEndpoint() {

         given()
                 .log().all()
                 .when()
                 .get(uri + "ping")
                 .then()
                 .log().all()
                 .statusCode(201)
                 .body(is("Created"))
         ;
     }

 }













