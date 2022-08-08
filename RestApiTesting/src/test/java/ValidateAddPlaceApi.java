import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class ValidateAddPlaceApi {

    public static void main(String[] args) {
        //validate if given,when,then is working
        //given all input details
        //when submit to the api -resource,http
        //Then validate the response
        RestAssured.baseURI="https://rahulshettyacademy.com";
        String response = given().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(payload.AddPlace()).when().post("maps/api/place/add/json")
                            .then().log().all().assertThat().statusCode(200)
                            .body("scope", equalTo("APP"))
                            .header("server","Apache/2.4.41 (Ubuntu)")
                            .extract().response().asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response); //parsing json
        String placeId = js.getString("place_id");

        //Add place -> Update place with new address ->get Place to validate if New address is present in the response
            System.out.println(placeId);
        given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"place_id\":\""+ placeId +"\",\n" +
                        "    \"address\":\"Third avenue\",\n" +
                        "    \"key\":\"qaclick123\"\n" +
                        "}")
                .when()
                .put("maps/api/place/update/json")
                .then()
                .assertThat()
                .log().all()
                .statusCode(200)
                .body("msg",equalTo("Address successfully updated"));

        String getPlaceResponse= given().log().all().queryParam("key","qaclick123")

                .queryParam("place_id", placeId)
                .when()
                .get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        JsonPath getUpdatedValue = new JsonPath(getPlaceResponse);
        String actualAddress = getUpdatedValue.getString("address");
        System.out.println(actualAddress);


    }
}
