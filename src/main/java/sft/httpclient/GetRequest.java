package sft.httpclient;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import sft.auth.SftSetup;

public class GetRequest {
	private String authToken;
	public GetRequest(){
		authToken = SftSetup.generate_token();
	}
	
	public String GetRequestWithOauth(final String endPoint) {
		
		Response response = hit_request(endPoint);
		
		if(response.getStatusCode() == 200)
			return response.getBody().asString();
		else
			throw_exception(endPoint);
		return null;
	}

	public JsonPath GetRequestWithOauthJSON(final String endPoint) {
		
		Response response = hit_request(endPoint);
		if(response.getStatusCode() == 200)
			return response.getBody().jsonPath();
		else
			throw_exception(endPoint);
		return null;
	}
	
	
	
	
	private Response hit_request(final String endPoint)
	{
		 return RestAssured.given().header("Authorization", "Bearer " + authToken)
				.contentType("application/json")
				.get(endPoint);
	}
	
	
	private void throw_exception(final String endPoint)
	{
		try {
			throw new Exception("Error in api hit: " + endPoint);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.exit(1);
		}
	}
	
	
	public static void main(String []args)
	{
		GetRequest get_request = new GetRequest();
		System.out.println(get_request.GetRequestWithOauth("sobjects/Lead/describe/layouts"));
		
	}
	
}
