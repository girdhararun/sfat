package sft.httpclient;

import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import sft.auth.SftSetup;

public class GetRequest 
{
	private String authToken;
	
	public GetRequest()
	{
		authToken = SftSetup.generate_token();
	}

	public String getRequestWithOauth(final String endPoint) {		
		Response response = getRequest(endPoint);
		if(response.getStatusCode() == 200)
			return response.getBody().asString();
		else
			Assert.fail("[[[[[Error in api hit: " + endPoint + "]]]]]");
		return null;
	}
	
	private Response getRequest(final String endPoint)
	{
		return RestAssured.given().header("Authorization", "Bearer " + authToken).contentType("application/json").get(endPoint);
	}
}
