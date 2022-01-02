package com.jet.framework.stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.jet.framework.POJO.Payload;



public class TestClass {
	
	public static void main(String [] args) {
		Payload p=new Payload();
		p.setUserId(1);
		p.setTitle("foo");
		p.setBody("bar");
		
		
		//RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RequestSpecification reqSpec=new RequestSpecBuilder().
		setBaseUri("https://jsonplaceholder.typicode.com").
		setContentType(ContentType.JSON).build();
		
		ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
//		Response res=given().header("Content-type","application/json; charset=UTF-8").body("{	\"title\": \"foo\",\r\n"
//				+ "    \"body\": \"bar\",\r\n"
//				+ "    \"userId\": 1}").log().all().when().post("/posts").then()	
//			.assertThat().statusCode(201).extract().response();
		
		Payload res=given().spec(reqSpec).body(p).log().all().when().post("/posts").then().spec(resp).extract().response().as(Payload.class);
		System.out.println(res.getId());
//		JsonPath js=new JsonPath(res);
//		String IssueID=js.get("id");
//		System.out.println("IssueID : "+IssueID);
		
	}

}
