package sft.auth;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

public class SftSetup {
	private static String token;
	static HashMap<String, String> map = new HashMap<String,String>();
	final static String setup_file = System.getProperty("user.dir") + File.separator + "SftSetup.json";

	public static String generate_token() {
		read_sftsetup();
		
		//Setting the base URI for all rest calls further
		RestAssured.baseURI = map.get("domain_url")+"/"+map.get("api_version")+"/";
		
		token = RestAssured.given().formParam("username", map.get("username"))
				.formParam("password", map.get("password")).formParam("grant_type", map.get("grant_type"))
				.formParam("client_id", map.get("client_id")).formParam("client_secret", map.get("client_secret"))
				.post(map.get("oauth_url")).jsonPath().get("access_token");

		System.setProperty("AccessToken", token);
		return token;
	}

	public static void read_sftsetup() {
		final ObjectMapper mapper = new ObjectMapper();
		try {
			map = mapper.readValue(new File(setup_file), new TypeReference<Map<String, String>>() {
			});
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
	}

	
	public static Map<String, String> getSftSetup() {
		read_sftsetup();
		final Map<String, String> sftsetup = new HashMap<String, String>(map);
		return sftsetup;
	}

	public static void main(final String[] args) {
		System.out.println(SftSetup.generate_token());
		System.out.println(System.getProperty("AccessToken"));
		System.out.println(getSftSetup().get("username"));
	}

}
