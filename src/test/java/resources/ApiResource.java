package resources;

public enum ApiResource 
{
	AuthorizeAPI("/oauth/authorize"),
	GetTokenAPI("/oauth/getToken");
	
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
