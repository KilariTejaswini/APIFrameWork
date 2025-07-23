package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
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
	Utils utils = new Utils();
	
	
	static RequestSpecification authReq;
	static Response response ; 
    static String authCode;
	static RequestSpecification tokenReq;
	static String accessToken;
	static String partnerId; 
	static String EmailID;
	static String ScreenName;
	static RequestSpecification reqRegister;
	static RequestSpecification reqAuthentication;
	
 
	
	@Given("Add authorize payload with {string} {string}")
	public void add_authorize_payload_with(String partnerID, String secretCode) throws IOException {
		
		 partnerId = Utils.getGlobalValue("partnerID");
         String secretcode = Utils.getGlobalValue("secretCode");
		 authReq = given().spec(requestSpecification()).body(data.authorizePayLoad(partnerId, secretcode));
	}


	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) throws IOException {
		
	    ApiResource resourceApi = ApiResource.valueOf(resource);
	    System.out.println(resourceApi.getResource());
	    
	    if (resource.equals("AuthorizeAPI")) 
	    {
	        response = authReq.when().post(resourceApi.getResource());
	    } 
	    else if (resource.equals("GetTokenAPI"))
	    {
	        response = tokenReq.when().post(resourceApi.getResource());
	    }
	    else if (resource.equals("RegisterAPI"))
	    {
	    	response = reqRegister.when().post(resourceApi.getResource());
	    }
	    else if (resource.equals("AuthenticationAPI"))
	    {
	    	response =  reqAuthentication.when().post(resourceApi.getResource());
	    }
	    
	}

	@Then("The API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		
		assertEquals(response.getStatusCode(), 200);
	    
	}
	
	@Then("The API call got failure with status code {int}")
	public void the_api_call_got_failure_with_status_code(Integer int1) {
	   
		assertEquals(response.getStatusCode(), 404);
		
	}
	

	@Then("The {string} in response body is {string}")
	public void the_in_response_body_is(String keyValue, String expectedValue) {
		
		assertEquals(getJsonPath(response, keyValue), expectedValue);
	    
	    }
	
	@Then("Extract the authCode from response")
	public void extract_the_auth_code_from_response() {
		
		authCode = getJsonPath(response,"authCode");
		System.out.println("authcode : " + authCode);
		System.out.println("partnerId : " + partnerId);
	   
	}


	@Given("Add getToken payload")
	public void add_get_token_payload() throws IOException {
		System.out.println("partnerId : " + partnerId);
	  
		tokenReq = given().spec(requestSpecification()).body(data.getTokenPayLoad(authCode, partnerId));
				
		}
	
	@Then("Extract the accessToken from response")
	public void extract_the_access_token_from_response() {
	    
		accessToken = getJsonPath(response,"accessToken");
		System.out.println("accessToken : " + accessToken);
	}
	
	
	@Given("Add register payload")
	public void add_register_payload() {
		
		long timeStamp = System.currentTimeMillis();
		 EmailID = "psp" + timeStamp + "@malinator.com";
		 ScreenName = "psp" + timeStamp;
		
		 
		 reqRegister = given().spec(req).headers("accessToken",accessToken).body(data.registerPayLoad(partnerId,EmailID,ScreenName));
	}
	
	
	@Given("Add authentication payload")
	public void add_authentication_payload() {
	    
	  reqAuthentication = given().spec(req).headers("accessToken",accessToken).body(data.authenticationPayLoad(partnerId, ScreenName));
	}

	
	
	    	
		
				
}
	
		
		
	
	
	    
