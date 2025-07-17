package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import POJO.AuthorizeRequest;
import POJO.ClientDetails;
import POJO.GetTokenRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.ApiResource;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils
{
	
	TestDataBuild data = new TestDataBuild();
	
	static RequestSpecification authReq;
	Response authorizeResponse ;
	String response;
	static String authCode;
	RequestSpecification tokenReq;
	static String accessToken;
	String partnerId;

	
	
	@Given("Add authorize payload with {string} {string}")
	public void add_authorize_payload_with(String partnerId, String secretCode) throws IOException {
		
		 authReq = given().spec(requestSpecification()).body(data.authorizePayLoad(partnerId, secretCode));
	 
	}
	
	
	
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) throws IOException {
	
	    ApiResource resourceApi = ApiResource.valueOf(resource);
	    System.out.println(resourceApi.getResource());
	    
	    authorizeResponse =  authReq.when().post(resourceApi.getResource());
	    response = authorizeResponse.asString(); 
	    	 
	}
	
	
	@Then("The API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer statusCode) {
		
	    assertEquals((int)authorizeResponse.getStatusCode(), statusCode.intValue());
	    System.out.println(statusCode);
	    
	}
	
	
	@Then("The {string} in response body is {string}")
	public void the_in_response_body_is(String key, String expectedValue) {

		   
		JsonPath js = new JsonPath(response);
	    String actualValue = js.getString(key);
	    System.out.println("Expected: " + expectedValue + " | Actual: " + actualValue);
	    System.out.println("Full Response: " + response);
	    assertEquals(expectedValue, actualValue);
		
		}

	
	
	@Then("Capture the authCode from response")
	public void capture_the_auth_code_from_response() {
	   
		JsonPath js = new JsonPath(response);
		authCode = js.get("authCode");
		System.out.println("AuthCode : " + authCode);
		
		
	}
	
	
	@Given("Add getToken payload using {string}")
	public void add_get_token_payload_using(String partnerId) throws IOException {
		
		System.out.println("AuthCode : " + authCode);
		System.out.println(partnerId);
		tokenReq = given().spec(requestSpecification()).body(data.getTokenPayLoad(partnerId));
		
	   
	}
		
	
	
	@Then("Capture the accessToken from response")
	public void capture_the_access_token_from_response() {
		
		JsonPath js = new JsonPath(response);
		accessToken = js.get("accessToken");
		System.out.println("AccessToken : " + accessToken);
	    
	}
		
	    
}
