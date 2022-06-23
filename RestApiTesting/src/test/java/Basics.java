import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class Basics {


    public static void main(String[] args) {

        //validate if project is configured properly
        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().log().all()
                .queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body("")
                .when()
                .post()
                .then().assertThat().statusCode(405);
    }
}