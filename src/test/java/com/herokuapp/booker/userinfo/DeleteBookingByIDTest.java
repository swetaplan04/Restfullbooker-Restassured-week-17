package com.herokuapp.booker.userinfo;

import com.herokuapp.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class DeleteBookingByIDTest extends TestBase {
    @Test
    public void deleteBookingId() {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .auth().preemptive().basic("admin","password123")
                .pathParam("id", 101  )
                .when()
                .delete("/booking/{id}");
        response.then().time(lessThan(3000L));
        response.prettyPrint();
        response.then().statusCode(201);
    }
}


