package sft.httpclient;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import sft.auth.SftSetup;

public class GetRequest {
	private String authToken;
	public GetRequest(){
		RestAssured.baseURI = SftSetup.getSftSetup().get("domain_url")+"/"+SftSetup.getSftSetup().get("api_version");
		authToken = SftSetup.generate_token();
	}

	public String GetRequestWithOauth(final String endPoint) {
		return RestAssured.given().header("Authorization", "Bearer " + authToken).contentType("application/json")
				.expect().statusCode(200).when().get(endPoint).then().extract().body().asString();
	}

	public JsonPath GetRequestWithOauthJSON(final String endPoint) {
		return RestAssured.given().header("Authorization", "Bearer " + authToken).contentType("application/json")
				.expect().statusCode(200).when().get(endPoint).then().extract().body().jsonPath();
	}

}
