package com.learning;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Простой тест для метода add класса App.
 */
class AppTest {

    @Test
    void addReturnsSumOfTwoNumbers() {
        assertEquals(5, App.add(2, 3));
        assertEquals(0, App.add(-1, 1));
        assertEquals(-5, App.add(-2, -3));
    }

    @Test
    void placeOrderToStore() {
        RestAssured.baseURI = "https://petstore.swagger.rv-school.ru/api/v3";

        String requestBody = """
            {
            "id": 10,
            "petId": 198772,
            "quantity": 7,
            "shipDate": "2026-02-22T18:21:30.152Z",
            "status": "approved",
            "complete": true
            }
            """;

        Response response = RestAssured
            .given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .post("/store/order")
            .then()
            .extract().response();
       
        assertEquals(200, response.getStatusCode(), "Wrong status code");
        assertEquals(10, response.jsonPath().getInt("id"), "Wrong order id");
        assertEquals(198772, response.jsonPath().getInt("petId"), "Wrong pet id");
        assertEquals(7, response.jsonPath().getInt("quantity"), "Wrong quantity");
        assertEquals("approved", response.jsonPath().getString("status"), "Wrong status");
        assertTrue(response.jsonPath().getBoolean("complete"),"Wrong complete status");
    }

    @Test
    void addNewPet() {
        RestAssured.baseURI = "https://petstore.swagger.rv-school.ru/api/v3";

        String requestBody = """
            {
                id: 1, 
                name: “Buddy”, 
                status: “available”
            }
            """;

        Response response = RestAssured
            .given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .post("/pet")
            .then()
            .extract().response();

        assertEquals(200, response.getStatusCode(), "Wrong status code");
        assertEquals(1, response.jsonPath().getInt("id"), "Wrong pet id");
        assertEquals("Buddy", response.jsonPath().getString("name"), "Wrong pet name");
        assertEquals("available", response.jsonPath().getString("status"), "Wrong status");
    }
}
