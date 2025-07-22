package POJO;

public class GetTokenRequest 
{
	private String authCode;
	private String grantType;
	private ClientDetails clientDetails;
	
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public ClientDetails getClientDetails() {
		return clientDetails;
	}
	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}
	
	
	
	
	
	
	
	 

}
