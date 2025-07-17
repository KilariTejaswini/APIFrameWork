package resources;

import POJO.AuthorizeRequest;
import POJO.ClientDetails;
import POJO.GetTokenRequest;
import POJO.GetTokenRequest;
import io.restassured.response.Response;

public class TestDataBuild
{
	  String authCode;  
	    
	public AuthorizeRequest authorizePayLoad(String partnerId, String secretCode)
	{
		ClientDetails clientDetails = new ClientDetails();
		   clientDetails.setPartnerId("jokaroom");
		   clientDetails.setSecretCode("mVfbZCu3rh3uw7d");
		
		
		   AuthorizeRequest authorizeRequest = new AuthorizeRequest();
		   authorizeRequest.setGrantType("CLIENT_CREDENTIALS");
		   authorizeRequest.setClientDetails(clientDetails);
		   
		   return authorizeRequest;
	}
	
	public GetTokenRequest getTokenPayLoad(String partnerId)
	{
		ClientDetails clientDetails = new ClientDetails();
		clientDetails.setPartnerId("jokaroom");

		   
		
		 GetTokenRequest tokenRequest = new GetTokenRequest();
			tokenRequest.setAuthCode(authCode);
			tokenRequest.setGrantType("CLIENT_CREDENTIALS");
			tokenRequest.setPartnerId(partnerId);
		
		return tokenRequest;
		
		}
		
	

}
