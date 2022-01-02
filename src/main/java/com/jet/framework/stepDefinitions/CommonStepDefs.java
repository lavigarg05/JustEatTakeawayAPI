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

	@Given("I create a new payload")
	public void createPayload(DataTable dt) throws FileNotFoundException {	
		List<Map<String, String>> datamap = dt.asMaps(String.class,String.class);
		logger.info("Creating payload : "+datamap.get(0));
		req = given().spec(requestSpecification()).body(data.AddPayload(datamap)).log().all();
	}	

	@When("I send \"(\\w+)\" with \"(\\w+)\" http request")
	public void createResource(String resource,String method) {
		logger.info("");
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
		resp = resp.then().extract().response();
		logger.info("Response status code verification : status is : "+ status);
	}
	
	@Then("verify \"(\\w+)\" in response body is \"(.*)\"")
	public void idVerify(String field,String value) {
		result = resp.as(Payload.class);	
		if (field.equalsIgnoreCase("id"))
			assertEquals(result.getId(),Integer.parseInt(value));	
		else if(field.equalsIgnoreCase("userId"))
			assertEquals(result.getUserId(),Integer.parseInt(value));	
		else if(field.equalsIgnoreCase("title"))
			assertEquals(result.getTitle(),value);	
		else if(field.equalsIgnoreCase("body"))
			assertEquals(result.getBody(),value);	
		logger.info("Response Payload verification : " +field+" is : "+ value);
	}

}
