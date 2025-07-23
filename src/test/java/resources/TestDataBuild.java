package resources;

import POJO.AuthenticationRequest;
import POJO.AuthorizeRequest;
import POJO.ClientDetails;
import POJO.GetTokenRequest;
import POJO.RegisterRequest;
import io.restassured.response.Response;

public class TestDataBuild
{
	 static String EmailID;
	 static String ScreenName;
	
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
		
		
		public RegisterRequest registerPayLoad(String partnerId, String EmailId, String screenName )
		{
			
			ClientDetails clientDetails = new ClientDetails();
			clientDetails.setPartnerID(partnerId);
			
			long timeStamp = System.currentTimeMillis();
			  EmailID = "psp" + timeStamp + "@malinator.com";
			 ScreenName = "psp" + timeStamp;
			
			RegisterRequest registerRequest = new RegisterRequest();
			registerRequest.setPartnerID(partnerId);
			registerRequest.setLabelID(partnerId);
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
		
		public AuthenticationRequest authenticationPayLoad(String partnerId, String screenName)
		{

			ClientDetails clientDetails = new ClientDetails();
			clientDetails.setPartnerID(partnerId);
			
			AuthenticationRequest authenticationRequest = new AuthenticationRequest();
			authenticationRequest.setPartnerID(partnerId);
			authenticationRequest.setLabelID("jokaroom");
			authenticationRequest.setProductID("CASINO");
			authenticationRequest.setChannel("desktop");
			authenticationRequest.setSubChannel("native");
			authenticationRequest.setOsType("Windows");
			authenticationRequest.setBrowserType("Chrome");
			authenticationRequest.setEmailID(EmailID);
			authenticationRequest.setScreenName(ScreenName);
			authenticationRequest.setPassword("123123");
			authenticationRequest.setMacAddress("0123456789abcdef");
			authenticationRequest.setIp("46.251.211.52");
			authenticationRequest.setDeviceID("test");
			
			return authenticationRequest;
			
		}
		
	

}
