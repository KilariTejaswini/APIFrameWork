package POJO;

public class AuthorizeRequest
{
	 private String grantType;
     private ClientDetails clientDetails;
     
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
