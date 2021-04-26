package com.productStore.stepDefinitions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class ApiStepDefs {

    @BeforeClass
    public void before(){
        baseURI = "https://petstore.swagger.io";
    }


    @Test
    public void getAvailablePet(){

       Response response = given().accept(ContentType.JSON)
                .and().queryParam("status","available")
                .when().get("v2/pet/findByStatus");
       response.then().statusCode(200);

        List<String> status = response.path("status");

        for (String actualStatus : status) {
            assertEquals(actualStatus,"available");
        }
    }

    @Test (priority = 1)
    public long postPet(){

        String bodyData ="{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        Response response = given().contentType(ContentType.JSON)
                .and().body(bodyData)
                .when().post("v2/pet/");

                response.then().assertThat().statusCode(200);

                long id = response.path("id");
        return id;

    }

    @Test(priority = 2)
    public void putExistingPet(){

        String id=Long.toString(postPet());

        String bodyData = "{\n" +
                "    \"id\": "+id+",\n" +
                "    \"category\": {\n" +
                "        \"id\": 0,\n" +
                "        \"name\": \"string\"\n" +
                "    },\n" +
                "    \"name\": \"doggie\",\n" +
                "    \"photoUrls\": [\n" +
                "        \"string\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"id\": 0,\n" +
                "            \"name\": \"string\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"sold\"\n" +
                "}";

        Response response = given().contentType(ContentType.JSON)
                .and().body(bodyData)
                .when().put("https://petstore.swagger.io/v2/pet");

        response.then().assertThat().statusCode(200);

        String actualStatus = response.path("status");

        Assert.assertEquals(actualStatus,"sold");

        //response.then().log().all();

    }

    @Test(priority = 3)
    public void deleteExistingPet(){

        given().pathParam("id",postPet())
                .when().delete("https://petstore.swagger.io/v2/pet/{id}")
                .then().assertThat().statusCode(200);
    }



}
