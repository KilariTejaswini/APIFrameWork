package resources;

public enum ApiResource 
{
	AuthorizeAPI("/oauth/authorize"),
	GetTokenAPI("/oauth/getToken"),
	RegisterAPI("/ecr/registration/register"),
	AuthenticationAPI("/ecr/auth/authenticate");
	
	private String resource;
	
	ApiResource(String resource)
	{
		this.resource=resource;
		
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
