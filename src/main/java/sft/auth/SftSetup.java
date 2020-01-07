package sft.auth;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sforce.ws.shade.org.apache.commons.collections.map.HashedMap;

import io.restassured.RestAssured;

public class SftSetup 
{
	private static String token;
	static Map<String, String> map = new HashedMap();
	@SuppressWarnings("unchecked")
	public static String generate_token(String file_name)
	{
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			map = mapper.readValue( new File(System.getProperty("user.dir")
					+File.separator+"src"
					+File.separator+"main"
					+File.separator+"resources"+
					File.separator+file_name)
					, Map.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestAssured.baseURI = map.get("oauth_url");
		token =  RestAssured.given()
	        .formParam("username", map.get("username"))
	        .formParam("password", map.get("password"))
	        .formParam("grant_type", map.get("grant_type"))
	        .formParam("client_id", map.get("client_id"))
	        .formParam("client_secret", map.get("client_secret"))
	        .post().jsonPath().get("access_token");
		
		System.setProperty("AccessToken", token);
		return token;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, String> getSftSetup()
	{
		final Map<String, String> sftsetup = new HashedMap(map);	
		return sftsetup;
	}
	
	public static void main(String []args)
	{	
		System.out.println(SftSetup.generate_token("SftSetup.json"));
		System.out.println(System.getProperty("AccessToken"));
		
	}
	
}
