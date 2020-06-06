package com.mytheresa.tests;

import com.mytheresa.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.*;


public class githubApi {
    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI= ConfigurationReader.get("githubapi.uri");
    }

     /*
   Given accept type is json
   And query parameter values are :
    q=tetris+language:assembly
    sort=stars
    order=desc
   When user sends a get request to /search/repositories
   Then status code is 200
   And content type is application/json; charset=utf-8
   And  "total_count" should be in response payload,
        "incomplete_results" should be in response payload
   And value of "incomplete_result" should be false
   And value of "total_count" should be 1925
    */

     @Test
    public void githubAPI1(){
         Response response = given().accept(ContentType.JSON).and()
                 .queryParam("q", "tetris+language:assembly")
                 .queryParam("sort", "stars")
                 .queryParam("order", "desc")
                 .when().get("/search/repositories");

         //check response status code
         Assert.assertEquals(response.statusCode(),200);
         //check response contentType
         Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
         //Verify that body contains "total_count" and "incomplete_results"
         Assert.assertTrue(response.body().asString().contains("total_count"));
         Assert.assertTrue(response.body().asString().contains("incomplete_results"));
         //converts response to JsonPath
         JsonPath json=response.jsonPath();
         String incomplete_results = json.getString("incomplete_results");
         //Verify that "incomplete_result":false
         Assert.assertEquals(incomplete_results,"false");

         //Verify that "total_count":
         String totalCount = json.getString("total_count");
         Assert.assertEquals(totalCount,"319");  //this test case fails because total_count is changing!


     }

      /*
   Given accept type is json
   And query parameter values are :
    q=tetris+language:assembly
    sort=stars
    order=desc
   When user sends a get request to /search/repositories
   Then status code is 200
   And content type is application/json; charset=utf-8
   And all "items" have  "language": "Assembly"
    */

    @Test
    public void githubAPI2(){
        Response response = given().accept(ContentType.JSON).and()
                .queryParam("q", "tetris+language:assembly")
                .queryParam("sort", "stars")
                .queryParam("order", "desc")
                .when().get("/search/repositories");

        //check response status code
        Assert.assertEquals(response.statusCode(),200);
        //check response contentType
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        //converts response to JsonPath
        JsonPath json=response.jsonPath();
        //gets List of languages
        List<Object> list = json.getList("items.language");

        //verify that all languages are "Assembly"
        for (Object o : list) {
            Assert.assertEquals(o,"Assembly");
        }
    }

}
