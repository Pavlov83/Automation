import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;

public class GetParticularIdTests {


    @Test
    public void getFirstIdTest(){

        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/1");
        response.print();
//        String id = response.jsonPath().getString("[0].firstname");
//        SoftAssert name = new SoftAssert();
//        name.assertEquals(id,"");

    }

}
