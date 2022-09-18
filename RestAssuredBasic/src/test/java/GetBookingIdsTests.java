import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class GetBookingIdsTests {


    @Test
    public void getBookingIdsWithoutFilterTest(){
        //Get response with booking ids
        Response response =
                RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.print();
        Assert.assertEquals(response.getStatusCode(),200,
                "Status code should be 200 but it is not");
        //Verify that the list is not empty
        List<Integer> bookingIds = response.jsonPath().getList("bookingId");
        Assert.assertFalse(bookingIds.isEmpty(),
                "List of bookingIds is empty but shouldn't be");
    }
}
