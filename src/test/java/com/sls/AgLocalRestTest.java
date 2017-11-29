package com.sls;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class AgLocalRestTest {

    @Test
    public void isLocalServerActive() {
        Response response = given().when().get("http://localhost:8080/app/greetings/Robert").andReturn();

        int code = response.getStatusCode();
        Assert.assertEquals("getClientTest Failure - status code: ", 200, code);
    }

    @Test
    public void greetingsTest() throws Exception {
        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(
                "http://localhost:8080/app/greetings/Robert").
                andReturn();
        String json = response.getBody().asString();
        Assert.assertEquals("Greetings Test Failure", "\"Hello, Robert!\"", json);
    }

    class Client{
        Client(String name, int height, int mass, String hair_color) {
            this.name = name;
            this.height = height;
            this.mass = mass;
            this.hair_color = hair_color;
        }
        String name;
        int height;
        int mass;
        String hair_color;
    }

    @Test
    public void getClientTest() throws Exception {

        Response response = given().when().get("http://localhost:8080/app/getClient/Robert").andReturn();

        int code = response.getStatusCode();
        Assert.assertEquals("getClientTest Failure - status code: ", 200, code);

        String json = response.getBody().asString();

        // Use the JsonPath parsing library to Parse the JSON into an object
        Client client = new JsonPath(json).getObject("$", Client.class);

        // test fields in the object
        Assert.assertEquals("getClientTest Failure", "Goober", client.name);
    }

    private class Reply {
        String results;
        String details;
    }

    @Test
    public void addClientTest() {
        Client client = new Client("Goober Pyle", 610, 530, "Brown");
        Response response = given().contentType("application/json").body(client)
                .when().post("http://localhost:8080/app/addClient")
                .andReturn();

        String json = response.getBody().asString();

        Reply reply = new JsonPath(json).getObject("$", Reply.class);
        Assert.assertEquals("addClientTest Failure", "true", reply.results);

    }

}
