package com.herokuapp.restfulbooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getBookingsTest {

    @Test
    public  void getBooking() {
    Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/1");
    response.print();
    Assert.assertEquals(response.getStatusCode(), 200);
    String firstName = response.jsonPath().getString("firstname");
    String lastName = response.jsonPath().getString("lastname");
    int totalPrice = response.jsonPath().getInt("totalprice");
    boolean depositPaid = response.jsonPath().getBoolean("depositpaid");
    String checkIn = response.jsonPath().getString("bookingdates.checkin");
    String checkOut = response.jsonPath().getString("bookingdates.checkout");

    System.out.println(firstName);
    System.out.println(lastName);
    System.out.println(totalPrice);
    System.out.println(depositPaid);
    System.out.println(checkIn);
    System.out.println(checkOut);
    /*
        {"firstname":"Sally",
        "lastname":"Wilson",
        "totalprice":321,
        "depositpaid":false,
        "bookingdates":{"checkin":"2023-04-24","checkout":"2023-06-06"}
        }

    */
    }

}
