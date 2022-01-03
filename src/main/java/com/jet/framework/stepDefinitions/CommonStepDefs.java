package com.jet.framework.stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jet.framework.POJO.Payload;
import com.jet.framework.base.APIResources;

import com.jet.framework.connections.Settings;
import com.jet.framework.utilities.TestDataBuilder;
import com.jet.framework.utilities.Utils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class CommonStepDefs extends Utils{
	RequestSpecification req;
	ResponseSpecification respSpec;
	Response resp;
	Payload result;
	TestDataBuilder data=new TestDataBuilder();
	String pathParameters;
	String queryParameters;

	@Given("I create a new payload")
	public void createPayload(DataTable dt) throws FileNotFoundException {	
		List<Map<String, String>> datamap = dt.asMaps(String.class,String.class);
		logger.info("Creating payload : "+datamap.get(0));
		req = given().spec(requestSpecification()).body(data.AddPayload(datamap)).log().all();
	}
	
	
	@Given("I set \"(\\w+)\" parameters")
	public void createPayload(String parameterType,DataTable dt) throws FileNotFoundException {

		List<Map<String, String>> parameterMap =  dt.asMaps(String.class,String.class);
		if(parameterType.equalsIgnoreCase("path")) 
				req = given().spec(requestSpecification()).pathParam("id", parameterMap.get(0).get("id"));
		if(parameterType.equalsIgnoreCase("query")) 
			req = given().spec(requestSpecification()).queryParam("postId", parameterMap.get(0).get("postId"));

	}
	
	
	@When("I send \"(\\w+)\" with \"(\\w+)\" http request")
	public void createResource(String resource,String method) throws FileNotFoundException {
		if(req==null)
			req = given().spec(requestSpecification());
		APIResources resourceAPI=APIResources.valueOf(resource);
		if(method.equalsIgnoreCase("POST"))
			resp=req.when().post(resourceAPI.getResource());
		if(method.equalsIgnoreCase("GET"))
			resp=req.when().get(resourceAPI.getResource());
		
		logger.info(method+" request sent for "+resource);
	}
	
	
	@Then("The API call is successfull with status code \"(\\d+)\"")
	public void statusCodeverify(int status) {
		respSpec = new ResponseSpecBuilder().expectStatusCode(status).expectContentType(ContentType.JSON).build();
		resp = resp.then().spec(respSpec).extract().response();
		logger.info("Response status code verification : status is : "+ status);
	}
	
	@Then("verify \"(\\w+)\" in response body is \"(.*)\"")
	public void responseVerify(String field,String value) {
		result = resp.as(Payload.class);	
		if (field.equalsIgnoreCase("id"))
			assertEquals(Integer.parseInt(value),result.getId());	
		else if(field.equalsIgnoreCase("userId"))
			assertEquals(Integer.parseInt(value),result.getUserId());	
		else if(field.equalsIgnoreCase("title"))
			assertEquals(value,result.getTitle());	
		else if(field.equalsIgnoreCase("body"))
			assertEquals(value,result.getBody());	
		logger.info("Response Payload verification : " +field+" is : "+ value);
	}
	
	@Then("verify total (\\w+) in response body are \"(\\d+)\"")
	public void commentsVerify(String responseType,int count) {
		String result = resp.asString();	
		JsonPath js=new JsonPath(result);
		int actualCount = js.get("result.size()");
		assertEquals(count,actualCount);	
		logger.info("Response Payload verification : Total "+responseType+" are : "+actualCount);
	}
}
