package resources;

import POJO.AuthorizeRequest;
import POJO.ClientDetails;
import POJO.GetTokenRequest;
import POJO.RegisterRequest;
import io.restassured.response.Response;

public class TestDataBuild
{

	
	public AuthorizeRequest  authorizePayLoad(String partnerId, String secretCode)
	{
		ClientDetails clientDetails = new ClientDetails();
		   clientDetails.setPartnerID(partnerId);
		   clientDetails.setSecretCode(secretCode);
		
		
		   AuthorizeRequest authorizeRequest = new AuthorizeRequest();
		   authorizeRequest.setGrantType("CLIENT_CREDENTIALS");
		   authorizeRequest.setClientDetails(clientDetails);
		   
		   return authorizeRequest;
	}

	
	
	
	public GetTokenRequest getTokenPayLoad(String authCode, String partnerId)
	{
		ClientDetails clientDetails = new ClientDetails();
		clientDetails.setPartnerID(partnerId);

		   
		
		    GetTokenRequest tokenRequest = new GetTokenRequest();
			tokenRequest.setAuthCode(authCode);
			tokenRequest.setGrantType("CLIENT_CREDENTIALS");
			tokenRequest.setClientDetails(clientDetails);
			
		return tokenRequest;
		
		}
		
		
		/*public RegisterRequest registerPayLoad(String partnerID, String labelId )
		{
			long timeStamp = System.currentTimeMillis();
			String EmailID = "psp" + timeStamp + "@malinator.com";
			String ScreenName = "psp" + timeStamp;
			
			RegisterRequest registerRequest = new RegisterRequest();
			registerRequest.setPartnerID(partnerID);
			registerRequest.setLabelID(partnerID);
			registerRequest.setProductID("CASINO");
			registerRequest.setEmailID(EmailID);
			registerRequest.setScreenName(ScreenName);
			registerRequest.setPassword("123123");
			registerRequest.setChannel("web");
			registerRequest.setSubChannel("native");
			registerRequest.setBonusCode("");
			registerRequest.setBannerId("1");
			registerRequest.setEcrCurrency("EUR");
			registerRequest.setLanguage("fr-BE");
			registerRequest.setAffiliateId("");
			registerRequest.setAffiliateName("");
			registerRequest.setTrackerId("400216_0_");
			registerRequest.setEmailAndMobileSubscribed(true);
			registerRequest.setTimezone("Pacific/Kiritimati");
			registerRequest.setGovId1Type("aadhar");
			registerRequest.setGovId1("181229248100001");
			registerRequest.setCountryCode("FI");
			
			return registerRequest;
			
		}
		*/
		
	

}
