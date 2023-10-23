package com.herokuapp.restfulbooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HealthCheckTest {
    //https://restful-booker.herokuapp.com/apidoc/
    @Test
    public void healthCheckTest(){
        given()
                .when()
                .get("https://restful-booker.herokuapp.com/ping")
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    public void getBooking(){
        given()
                .when()
                .get(" https://restful-booker.herokuapp.com/booking/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body("firstname",equalTo("Mary"))
                .log().all();
    }
    @Test
    public void getBookings(){
        given()
                .when()
                .get(" https://restful-booker.herokuapp.com/booking/")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void getBookingsIDs(){
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/");
        response.print();
        Assert.assertEquals(response.getStatusCode(),200,"Statuscode should be 200");
        List<Integer> bookingsIds = response.jsonPath().getList("bookingid");
        Assert.assertFalse(bookingsIds.isEmpty());


    }
}
