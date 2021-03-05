package com.qa.orangehrm.test_api;


import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Test_Get {
		
		@Test
		public void method(){
			given().get("https://reqres.in/api/users?page=2").then().
			statusCode(200).
			body("data.id[1]", equalTo(8)).
			body("data.first_name", hasItems("Michael","Lindsay")).
			log().all();
		}
		
		@Test
		public void test1() {

		//	given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));

		}
		
}
