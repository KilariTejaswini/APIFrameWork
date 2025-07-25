package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils 
{
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req==null)
		{
			
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				                      .addFilter(RequestLoggingFilter.logRequestTo(log))
				                      .addFilter(ResponseLoggingFilter.logResponseTo(log))
                                      .setContentType("application/json").build();
		                              
		return req;
		}
		return req;
	}
	
      public static String getGlobalValue(String key) throws IOException
      {
    	  Properties prop = new Properties();
    	  FileInputStream fis = new FileInputStream("C:\\Users\\tejaswini.kilari\\workspace\\APIFrameWork\\src\\test\\java\\resources\\global.properties");
    	  prop.load(fis);
    	  return prop.getProperty(key);
    	  
     }
      
      public String getJsonPath(Response response, String key)
      {
    	  
    	  String resp = response.asString();
    	  JsonPath js = new JsonPath(resp);
    	  
    	  Object value = js.get(key);

    	    if (value == null)
    	    {
    	        System.err.println("Key not found in response: " + key);
    	        System.err.println(" Response: " + resp);
    	        return null;
    	    }


    	    return value.toString();
    	  
      }
      
      
      
}
